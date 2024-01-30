package com.ayoolamasha.uidesignassignment.presentation

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ayoolamasha.uidesignassignment.R
import com.ayoolamasha.uidesignassignment.core.bounceAnimation
import com.ayoolamasha.uidesignassignment.core.navigateToDashboardHolder
import com.ayoolamasha.uidesignassignment.core.statusBarColor
import com.ayoolamasha.uidesignassignment.databinding.FragmentCalaulateBinding
import com.google.android.material.chip.ChipGroup
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CalculateFragment : Fragment() {
    private lateinit var binding: FragmentCalaulateBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigateToDashboardHolder()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalaulateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusBarColor()
        binding.contentConstraint.animation = AnimationUtils.loadAnimation(context, R.anim.slide_up_anim)
        binding.topInfoDash.animation = AnimationUtils.loadAnimation(context, R.anim.slide_down_anim)

        binding.backArrow.setOnClickListener { navigateToDashboardHolder() }

        binding.calculateButton.setOnClickListener {
            bounceAnimation(binding.calculateButton)
            lifecycleScope.launch {
                delay(500)
                findNavController().navigate(R.id.action_homeFragment_to_resultFragment)
            }
        }


    }

    private fun slideDownTabLayout() {
        val fadeInAnimator = ObjectAnimator.ofFloat(binding.calculatorText, "alpha", 0f, 1f)
        fadeInAnimator.duration = 1000
        fadeInAnimator.start()
    }

    override fun onResume() {
        super.onResume()
        slideDownTabLayout()
        binding.contentConstraint.animation = AnimationUtils.loadAnimation(context, R.anim.slide_up_anim)
    }
}