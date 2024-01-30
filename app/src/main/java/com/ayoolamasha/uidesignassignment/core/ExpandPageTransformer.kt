package com.ayoolamasha.uidesignassignment.core

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs

class ExpandPageTransformer : ViewPager2.PageTransformer {
    private val MIN_SCALE = 0.75f

    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val scaleFactor = if (position < 0) {
            1 - abs(position) * (1 - MIN_SCALE)
        } else {
            1 - abs(position) * (1 - MIN_SCALE)
        }

        page.scaleX = scaleFactor
        page.scaleY = scaleFactor
    }
}