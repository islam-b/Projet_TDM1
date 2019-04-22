package com.example.projettdm1.adapters

import android.content.Context
import android.content.res.Configuration
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class GridItemDecoration(spacing: Int, context: Context) : RecyclerView.ItemDecoration() {

    private var mSpace=  spacing
    private var mContext=  context


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {

        if (mContext.resources.configuration.screenLayout.and(Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            if (mContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                if (parent.getChildLayoutPosition(view) < 5) {
                    outRect.top = mSpace
                } else {
                    outRect.top = mSpace / 2
                }
                outRect.bottom = mSpace / 2
                outRect.left = mSpace / 2
                outRect.right = mSpace / 2
            } else {
                if (parent.getChildLayoutPosition(view) < 4) {
                    outRect.top = mSpace
                } else {
                    outRect.top = mSpace / 3
                }
                outRect.bottom = mSpace / 3
                outRect.left = mSpace / 3
                outRect.right = mSpace / 3
            }
        } else {
            if (mContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                if (parent.getChildLayoutPosition(view) < 4) {
                    outRect.top = mSpace
                } else {
                    outRect.top = mSpace / 3
                }
                outRect.bottom = mSpace / 3
                outRect.left = mSpace / 3
                outRect.right = mSpace / 3
            } else {
                if (parent.getChildLayoutPosition(view) % 2 == 0) {
                    if (parent.getChildLayoutPosition(view) == 0) {
                        outRect.top = mSpace * 3 / 2
                    }
                    outRect.left = mSpace  / 2
                    outRect.right = mSpace / 2
                } else {
                    if (parent.getChildLayoutPosition(view) == 1) {
                        outRect.top = mSpace * 3 / 2
                    }
                    outRect.right = mSpace / 2
                    outRect.left = mSpace / 2
                }
                outRect.bottom = mSpace
            }
        }
    }




}