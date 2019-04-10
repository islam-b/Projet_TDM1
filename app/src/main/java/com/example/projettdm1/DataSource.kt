package com.example.projettdm1

import com.example.projettdm1.models.Categorie
import com.example.projettdm1.models.News

object DataSource {
    var newsList = ArrayList<News>()
    var categoriesList= ArrayList<Categorie>()

    var filterContreints = ArrayList<Categorie>()

    init {
        val category1 =  Categorie(R.mipmap.ic_launcher,"Me","Hello")
        val category2 =  Categorie(R.mipmap.ic_launcher,"Me2","Hello")
        val category3 =  Categorie(R.mipmap.ic_launcher,"Me3","Hello")

        newsList.add(News(R.mipmap.ic_launcher,"01/04/2019","Hello1 ", "detail11", category1))
        newsList.add(News(R.mipmap.ic_launcher,"01/04/2019","Hello2 ","detail22", category2))
        newsList.add(News(R.mipmap.ic_launcher,"01/04/2019","Hello3 ","detail33", category3))

        categoriesList.add(category1)
        categoriesList.add(category2)
        categoriesList.add(category3)
    }

    fun getNews(): ArrayList<News> {
        return newsList
    }

    fun getCategories(): ArrayList<Categorie> {
        return categoriesList
    }

    fun filterNewsByCategories(): ArrayList<News> {
        val res= ArrayList<News>()
        for (i in 0 until newsList.size) {
            for (j in 0 until filterContreints.size) {
                if (newsList[i].categorie == filterContreints[j]) res.add(newsList[i])
            }
        }
        return res
    }

    fun deleteFilterContreint(cat:Categorie):Boolean {
        filterContreints.remove(cat)
        return filterContreints.isEmpty()
    }
    fun addFilterContreint(position: Int) {
        filterContreints.add(categoriesList[position])
    }

    fun clearConstreints() {
        filterContreints.clear()
    }
}