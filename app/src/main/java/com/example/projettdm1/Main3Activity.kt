package com.example.projettdm1

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.projettdm1.R.color.*
import com.example.projettdm1.models.News
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.Serializable


class Main3Activity : AppCompatActivity() {


    private var currentNew:News?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

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
        findViewById<TextView>(R.id.title_info).text =currentNew?.description
        findViewById<TextView>(R.id.detail_info).text =currentNew?.detail
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
    }


    fun shareNews(content: News) {
        Log.d("SHARE",content.description)

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, content.description)
        intent.putExtra(Intent.EXTRA_TEXT, content.detail)
        startActivity(Intent.createChooser(intent,"Partager via"))

    }

    companion object {
        fun newIntent(context: Context, news: News): Intent {
            val intent= Intent(context, Main3Activity::class.java)
            Log.d("NEWS",news.description)
            intent.putExtra("NEWS",news)
            //intent.putExtra("TITLE",news.description)
            return intent
        }
    }
}
