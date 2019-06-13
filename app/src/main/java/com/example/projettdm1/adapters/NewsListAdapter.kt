
package com.example.projettdm1.adapters
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.projettdm1.DataSource
import com.example.projettdm1.LocaleHelper
import com.example.projettdm1.R
import com.example.projettdm1.models.Categorie
import com.example.projettdm1.models.News
import de.hdodenhof.circleimageview.CircleImageView

class NewsListAdapter(val news: ArrayList<News>, listener: NewsListAdapter.OnNewsClickListener): RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {


    private val mListener=listener
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val vi = LayoutInflater.from(p0.context).inflate(R.layout.news_item, p0, false)
        Log.d("TXT",news[p1].description)
        return ViewHolder(vi,news[p1],mListener)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val new = news[p1]
        p0.icon.setImageResource(new.iconRes)
        p0.date.text = new.date
        if (LocaleHelper.lang == "ar") {
            p0.title.text = new.title_ar
            p0.description.text = new.description_ar
            p0.source.text = new.source_ar
            p0.categorie.text = new.categorie.Title_ar
        } else {
            p0.title.text = new.title
            p0.description.text = new.description
            p0.source.text = new.source
            p0.categorie.text = new.categorie.Title
        }


        if (DataSource.isFavorite(new)) p0.add_to_fav_button.setImageResource(R.drawable.favorite)
        else p0.add_to_fav_button.setImageResource(R.drawable.favorite_grey)

        p0.add_to_fav_button.setOnClickListener {
            if (DataSource.isFavorite(new)) {
                DataSource.removeFromFavorites(new)
                p0.add_to_fav_button.setImageResource(R.drawable.favorite_grey)
            } else {
                DataSource.addToFavorites(new)
                p0.add_to_fav_button.setImageResource(R.drawable.favorite)
            }

        }
        p0.mNews = new

    }


    inner class ViewHolder(itemView: View,news:News ,listener: NewsListAdapter.OnNewsClickListener): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View?) {
            mListener.OnNewsClick(mNews)
        }
        init {
            itemView.setOnClickListener(this)
        }
        val  mListener = listener
        var mNews=news
        val icon=itemView.findViewById<CircleImageView>(R.id.news_icon)
        val description= itemView.findViewById<TextView>(R.id.news_description)
        val title= itemView.findViewById<TextView>(R.id.news_title)
        val source= itemView.findViewById<TextView>(R.id.news_source)
        val date= itemView.findViewById<TextView>(R.id.news_date)
        val categorie= itemView.findViewById<TextView>(R.id.news_category)
        val add_to_fav_button=itemView.findViewById<ImageButton>(R.id.add_to_fav_btn)
    }
     interface OnNewsClickListener{
        fun OnNewsClick(news: News)
    }
}
