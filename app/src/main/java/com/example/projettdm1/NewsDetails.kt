package com.example.projettdm1

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.projettdm1.R.color.*
import com.example.projettdm1.models.News
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.Serializable


class NewsDetails : AppCompatActivity() {


    private var currentNew:News?=null
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
        setContentView(R.layout.details_news)

        val bundle = intent.extras
        bundle?.let {
            bundle.apply {
                currentNew = getParcelable("NEWS")
            }
        }

        initView()

        findViewById<FloatingActionButton>(R.id.back_btn).setOnClickListener {
            finish()
        }

        findViewById<FloatingActionButton>(R.id.share_btn).setOnClickListener {
            currentNew?.let{
                shareNews(it)
            }
        }

    }

    fun initView() {
        if (LocaleHelper.lang=="ar") {
            findViewById<TextView>(R.id.title_info).text =currentNew?.title_ar
            findViewById<TextView>(R.id.detail_info).text =currentNew?.description_ar
        } else {
            findViewById<TextView>(R.id.title_info).text =currentNew?.title
            findViewById<TextView>(R.id.detail_info).text =currentNew?.description
        }

        findViewById<TextView>(R.id.date_info).text =currentNew?.date
        currentNew?.iconRes?.let {
            findViewById<ImageView>(R.id.image_info).setImageResource(it)
        }
        val like_btn = findViewById<FloatingActionButton>(R.id.like_btn)
        currentNew?.let {
            if (DataSource.isFavorite( it))
                like_btn.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.colorAccent))
            else
                like_btn.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.colorAccent2))
        }


        like_btn.setOnClickListener {
            currentNew?.let {
                if (DataSource.isFavorite( it)) {
                    DataSource.removeFromFavorites( it)
                    like_btn.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.colorAccent2))

                } else {
                    DataSource.addToFavorites( it)
                    like_btn.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.colorAccent))

                }
            }
        }

        findViewById<MaterialCardView>(R.id.news_card).setOnClickListener {
            openLectureMode()
        }
    }


    fun shareNews(content: News) {
        Log.d("SHARE",content.description)

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, content.title)
        intent.putExtra(Intent.EXTRA_TEXT, content.description)
        startActivity(Intent.createChooser(intent,"Partager via"))

    }

    fun openLectureMode() {
        currentNew?.let{
            val intent = lecture_mode.newIntent(this,it)
            startActivity(intent)
        }

    }

    companion object {
        fun newIntent(context: Context, news: News): Intent {
            val intent= Intent(context, NewsDetails::class.java)
            Log.d("NEWS",news.description)
            intent.putExtra("NEWS",news)
            //intent.putExtra("TITLE",news.description)
            return intent
        }
    }
}
