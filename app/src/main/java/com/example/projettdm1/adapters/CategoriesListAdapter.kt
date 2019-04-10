
package com.example.projettdm1.adapters
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.projettdm1.R
import com.example.projettdm1.models.Categorie

class CategoriesListAdapter(val categories: ArrayList<Categorie>, listener: OnCategoryClickListener): RecyclerView.Adapter<CategoriesListAdapter.ViewHolder>() {

    private val mListener=listener

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val vi = LayoutInflater.from(p0.context).inflate(R.layout.category_item, p0, false)
        return ViewHolder(vi,mListener)

    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val category = categories[p1]
        p0.icon.setImageResource(category.imageRes)
        p0.title.text = category.Title
        p0.description.text = category.Description
    }


    inner class ViewHolder(itemView: View, listener: OnCategoryClickListener): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        override fun onClick(p0: View?) {
            mListener.OnCategoryClick(adapterPosition)
        }

        init {
            itemView.setOnClickListener(this)
        }
        val  mListener = listener
        val icon=itemView.findViewById<ImageView>(R.id.category_icon)
        val title= itemView.findViewById<TextView>(R.id.category_title)
        val description = itemView.findViewById<TextView>(R.id.category_decription)


    }

    interface OnCategoryClickListener{
        fun OnCategoryClick(position: Int)
    }
}