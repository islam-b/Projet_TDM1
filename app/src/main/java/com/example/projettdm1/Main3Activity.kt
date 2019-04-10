package com.example.projettdm1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
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

        findViewById<TextView>(R.id.title_info).text =currentNew?.description
        findViewById<TextView>(R.id.detail_info).text =currentNew?.detail
        findViewById<TextView>(R.id.date_info).text =currentNew?.date
        currentNew?.iconRes?.let {
            findViewById<ImageView>(R.id.image_info).setImageResource(it)
        }


        findViewById<FloatingActionButton>(R.id.back_btn).setOnClickListener {
            val intent = MainActivity.newIntent(this)
            startActivity(intent)
        }
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
