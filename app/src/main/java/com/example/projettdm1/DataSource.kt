package com.example.projettdm1

import com.example.projettdm1.models.Categorie
import com.example.projettdm1.models.News

object DataSource {
    var newsList = ArrayList<News>()
    var categoriesList= ArrayList<Categorie>()
    var favoritesList= ArrayList<News>()

    var filterContreints = ArrayList<Categorie>()

    init {
        val category1 =  Categorie(R.drawable.a,"Me","Hello")
        val category2 =  Categorie(R.drawable.a,"Me2","Hello")
        val category3 =  Categorie(R.drawable.a,"Me3","Hello")
        val category4 =  Categorie(R.drawable.a,"Me3","Hello")
        val category5 =  Categorie(R.drawable.a,"Me4","Hello")
        val category6 =  Categorie(R.drawable.a,"Me5","Hello")

        val news1=News(R.drawable.a,"05/04/2019","EL Watan",R.drawable.a, "This is a loooong title to test how it fit", "this is a very long long deciprtion to see how it fit with the view, this is a very long long deciprtion to see how it fit with the view,",category1)
        val news2=News(R.drawable.a,"05/04/2019","EL Watan",R.drawable.a, "This is a loooong title to test how it fit", "this is a very long long deciprtion to see how it fit with the view, this is a very long long deciprtion to see how it fit with the view,",category2)
        val news3=News(R.drawable.a,"05/04/2019","EL Watan",R.drawable.a, "This is a loooong title to test how it fit", "this is a very long long deciprtion to see how it fit with the view, this is a very long long deciprtion to see how it fit with the view,",category3)
        val news4=News(R.drawable.a,"05/04/2019","EL Watan",R.drawable.a, "This is a loooong title to test how it fit", "this is a very long long deciprtion to see how it fit with the view, this is a very long long deciprtion to see how it fit with the view,",category2)

        newsList.add(news1)
        newsList.add(news2)
        newsList.add(news3)
        newsList.add(news4)

        categoriesList.add(category1)
        categoriesList.add(category2)
        categoriesList.add(category3)
        categoriesList.add(category4)
        categoriesList.add(category5)
        categoriesList.add(category6)

        favoritesList.add(news2)
        favoritesList.add(news1)
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

    fun getFavorites(): ArrayList<News> {
        return favoritesList
    }

    fun addToFavorites(news: News) {
        favoritesList.add(news)
    }
    fun removeFromFavorites(news: News) {
        favoritesList.remove(news)
    }

    fun isFavorite(news: News): Boolean {
        return favoritesList.contains(news)
    }
    fun isConstreint(index:Int):Boolean {
        return filterContreints.contains(categoriesList[index])
    }
}