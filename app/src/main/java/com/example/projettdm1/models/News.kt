package com.example.projettdm1.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.io.Serializable

@Parcelize
data class News(val iconRes: Int,val  date: String,  val source: String ,val srcIcon: Int, val title: String, val description: String, val categorie: @RawValue  Categorie) : Parcelable  {

}