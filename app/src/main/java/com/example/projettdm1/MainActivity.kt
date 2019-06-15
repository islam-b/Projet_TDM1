package com.example.projettdm1

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import com.google.android.material.tabs.TabLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager.widget.ViewPager
import com.example.projettdm1.adapters.CategoriesListAdapter
import com.example.projettdm1.adapters.NewsListAdapter
import com.example.projettdm1.fragments.*
import com.example.projettdm1.models.Categorie
import com.example.projettdm1.models.News
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), NewsListAdapter.OnNewsClickListener,
    CategoriesListAdapter.OnCategoryClickListener ,
    FilterNewsFragment.OnChipClickListener , ChipFragment.OnCloseListener,NewsFilteredContainer.OnFragmentInteractionListener {

    override fun OnNewsClick(news: News) {
       val intent = NewsDetails.newIntent(this,news)
               startActivity(intent)
    }

    override fun OnCategoryClick(position: Int) {
        DataSource.clearConstreints()
        Log.d("POSITION",position.toString())
        DataSource.addFilterContreint(position)
        val fragment = FilterNewsFragment.newInstance()
        findViewById<ViewPager>(R.id.container).setCurrentItem(2,true)

        supportFragmentManager.beginTransaction().replace(R.id.news_filtered_container,fragment).commit()
    }

    override fun onClose(chip: Fragment,categorie: Categorie) {
        supportFragmentManager.beginTransaction().remove(chip).commit()
        if (DataSource.deleteFilterContreint(categorie)) {
            findViewById<ViewPager>(R.id.container).setCurrentItem(0,true)
        }

    }

    override fun onChipClick(category: Categorie) {
        val fragment = ChipFragment.newInstance(category)

        supportFragmentManager.beginTransaction().
            add(R.id.chips_container,fragment).commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (LocaleHelper.lang=="ar") {
            window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL
        } else {
            window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
        }

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme)
        } else setTheme(R.style.AppTheme)

        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))



    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.

        menuInflater.inflate(R.menu.menu_main2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        when (id) {
            R.id.favorite_btn -> {
                val intent = FavoriteNews.newIntent(this)
                startActivity(intent)
            }
            R.id.mode_btn -> {
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    restartApp()
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    restartApp()
                }
            }
            R.id.fr_btn -> {
                LocaleHelper.setLocale(this,"en")
                this.recreate()

            }
            R.id.ar_btn -> {
                LocaleHelper.setLocale(this,"ar")
                this.recreate()
            }

                else -> return false
        }
        return true
    }



    fun restartApp() {
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
        finish()
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){



        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            val fragment: Fragment
            when (position) {
                0 -> fragment = NewsFragment.newInstance()
                1 -> fragment = CategoriesFragment.newInstance()
                2 -> fragment = NewsFilteredContainer.newInstance()
                else -> fragment = NewsFragment.newInstance()
            }
            return fragment
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent= Intent(context, MainActivity::class.java)
            return intent
        }
    }



}
