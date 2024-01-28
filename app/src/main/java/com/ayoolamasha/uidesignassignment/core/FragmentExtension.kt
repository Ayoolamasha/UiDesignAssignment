package com.ayoolamasha.uidesignassignment.core

import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.ayoolamasha.uidesignassignment.R

fun Fragment.statusBarColor() {
    val window = requireActivity().window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.color_primary)
}