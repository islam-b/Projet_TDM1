package com.example.projettdm1

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projettdm1.adapters.FavListAdapter
import com.example.projettdm1.adapters.LinearItemDecoration
import com.example.projettdm1.adapters.NewsItemLargeScreenDecoration
import com.example.projettdm1.adapters.NewsListAdapter
import com.example.projettdm1.models.News


class FavoriteNews : AppCompatActivity(), FavListAdapter.OnNewsClickListener, NewsListAdapter.OnNewsClickListener {

    override fun OnDislikeClick(new: News) {
        if (DataSource.isFavorite(new)) {
            DataSource.removeFromFavorites(new)
        } else {
            DataSource.addToFavorites(new)
        }
        initFav()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme)
        } else setTheme(R.style.AppTheme)

        if (LocaleHelper.lang=="ar") {
            window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL
        } else {
            window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
        }
        setContentView(R.layout.favorite_news)

        var toolbar_fav = findViewById<Toolbar>(R.id.toolbar_fav)
        setSupportActionBar(toolbar_fav)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        initFav()
    }

    override fun onResume() {
        initFav()
        super.onResume()
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
                restartApp()

            }
            R.id.ar_btn -> {
                LocaleHelper.setLocale(this,"ar")
                restartApp()
            }

            else -> return false
        }
        return true
    }

    fun restartApp() {
        val intent = FavoriteNews.newIntent(this)
        startActivity(intent)
        finish()
    }

    fun initFav() {
        var recylclerview = findViewById<RecyclerView>(R.id.fav_list_container)
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing)
        if (resources.configuration.screenLayout.and(Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {

            recylclerview.addItemDecoration(NewsItemLargeScreenDecoration(spacingInPixels, this))
            if (resources.configuration?.orientation== Configuration.ORIENTATION_LANDSCAPE) {
                recylclerview.layoutManager = GridLayoutManager(this, 3)
            } else recylclerview.layoutManager = GridLayoutManager(this, 2)


            val adapter = NewsListAdapter(DataSource.getFavorites(),this)
            recylclerview.adapter = adapter
        } else {
            recylclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            val adapter = FavListAdapter(DataSource.getFavorites(),this)
            recylclerview.adapter = adapter

        }



    }



    override fun OnNewsClick(news: News) {
        val intent = NewsDetails.newIntent(this,news)
        startActivity(intent)
    }



    companion object {
        fun newIntent(context: Context): Intent {
            val intent= Intent(context, FavoriteNews::class.java)
            return intent
        }
    }
}
