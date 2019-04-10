package com.example.projettdm1.adapters

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class LinearItemDecoration(spacing: Int) : RecyclerView.ItemDecoration() {

    private var mSpace=  spacing


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {

        if (parent.getChildLayoutPosition(view)== 0) {
            outRect.top=mSpace
        }
        outRect.right=mSpace/2
        outRect.left=mSpace/2
        outRect.bottom = mSpace*2/3

    }


}