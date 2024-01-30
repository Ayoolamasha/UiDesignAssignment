package com.ayoolamasha.uidesignassignment.core

import android.content.Intent
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.ayoolamasha.uidesignassignment.MainActivity
import com.ayoolamasha.uidesignassignment.R

fun Fragment.statusBarColor() {
    val window = requireActivity().window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.color_primary)
}

fun Fragment.statusBarColorWhite() {
    val window = requireActivity().window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.white_background)
}

fun Fragment.navigateToDashboardHolder(){
    val intent = Intent(requireActivity(), MainActivity::class.java)
    startActivity(intent)
    requireActivity().finish()
}

/**
 * BOUNCE ANIMATION PARAMETERS
 */
const val BOUNCE_AMPLITUDE = 0.2
const val BOUNCE_FREQUENCY = 2.0

fun Fragment.bounceAnimation(view: View) {
    val animationBounce = AnimationUtils.loadAnimation(requireContext(), R.anim.bounce_anim)
    val bounceInterpolator = BounceInterpolator(BOUNCE_AMPLITUDE, BOUNCE_FREQUENCY)
    animationBounce.interpolator = bounceInterpolator
    view.startAnimation(animationBounce)
}