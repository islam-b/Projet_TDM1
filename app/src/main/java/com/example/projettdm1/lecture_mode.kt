package com.example.projettdm1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import com.example.projettdm1.models.News

class lecture_mode : AppCompatActivity() {

    private var currentNew:News?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme)
        } else setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_lecture_mode)

        var toolbar_lect = findViewById<Toolbar>(R.id.toolbar_lecture)
        setSupportActionBar(toolbar_lect)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        currentNew = intent?.extras?.getParcelable("NEWS")

        findViewById<TextView>(R.id.lect_title).text = currentNew?.title
        findViewById<TextView>(R.id.lect_detail).text = currentNew?.description

        /*val bundle = intent.extras
        bundle?.let {
            bundle.apply {
                currentNew = getParcelable("NEWS")
            }
        }*/
    }

    companion object {
        fun newIntent(context: Context, news: News): Intent {
            val intent= Intent(context, lecture_mode::class.java)
            Log.d("NEWS",news.description)
            intent.putExtra("NEWS",news)
            //intent.putExtra("TITLE",news.description)
            return intent
        }
    }
}
