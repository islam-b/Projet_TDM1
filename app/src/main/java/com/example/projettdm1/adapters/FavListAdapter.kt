
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

class FavListAdapter(val favorites: ArrayList<News>, listener: FavListAdapter.OnNewsClickListener): RecyclerView.Adapter<FavListAdapter.ViewHolder>() {


    private val mListener=listener
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val vi = LayoutInflater.from(p0.context).inflate(R.layout.fav_item, p0, false)
        Log.d("TXT",favorites[p1].description)
        return ViewHolder(vi,favorites[p1],mListener)
    }

    override fun getItemCount(): Int {
        return favorites.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val new = favorites[p1]
        p0.icon.setImageResource(new.iconRes)
        if (LocaleHelper.lang=="ar") p0.title.text = new.title_ar
        else p0.title.text = new.title
        p0.mNews = new

        /*if (DataSource.isFavorite(new)) p0.fav_dislike.setImageResource(R.drawable.favorite)
        else p0.fav_dislike.setImageResource(R.drawable.favorite_grey)*/

        p0.fav_dislike.setOnClickListener {
            p0.mListener.OnDislikeClick(new)
            if (DataSource.isFavorite(new)) {
                p0.fav_dislike.setImageResource(R.drawable.favorite_grey)
            } else {
                p0.fav_dislike.setImageResource(R.drawable.favorite)
            }

        }

    }


    inner class ViewHolder(itemView: View,news:News ,listener: FavListAdapter.OnNewsClickListener): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View?) {
            mListener.OnNewsClick(mNews)
        }
        init {
            itemView.setOnClickListener(this)
        }
        val  mListener = listener
        var mNews=news
        val icon=itemView.findViewById<CircleImageView>(R.id.fav_icon)
        val title= itemView.findViewById<TextView>(R.id.fav_title)
        val fav_dislike = itemView.findViewById<ImageButton>(R.id.fav_dislike)

    }
    interface OnNewsClickListener{
        fun OnNewsClick(news: News)
        fun OnDislikeClick(new: News)
    }


}
