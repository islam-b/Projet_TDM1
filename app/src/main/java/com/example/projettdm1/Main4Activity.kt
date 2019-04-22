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


class Main4Activity : AppCompatActivity(), FavListAdapter.OnNewsClickListener, NewsListAdapter.OnNewsClickListener {


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
        setContentView(R.layout.activity_main4)

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
        val intent = Main3Activity.newIntent(this,news)
        startActivity(intent)
    }



    companion object {
        fun newIntent(context: Context): Intent {
            val intent= Intent(context, Main4Activity::class.java)
            return intent
        }
    }
}
