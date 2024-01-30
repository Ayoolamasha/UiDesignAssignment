package com.ayoolamasha.uidesignassignment.presentation

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.ayoolamasha.uidesignassignment.R
import com.ayoolamasha.uidesignassignment.core.navigateToDashboardHolder
import com.ayoolamasha.uidesignassignment.core.statusBarColorWhite
import com.ayoolamasha.uidesignassignment.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding


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
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusBarColorWhite()
        binding.constraint.animation = AnimationUtils.loadAnimation(context, R.anim.slide_up_two_anim)
        binding.homeButton.setOnClickListener { navigateToDashboardHolder() }
        estimatedAmountCounter()




    }

    private fun estimatedAmountCounter() {
        val startValue = 0
        val endValue = 1460

        val animator = ValueAnimator.ofInt(startValue, endValue)

        animator.duration = 5000 // Adjust the duration as needed

        animator.addUpdateListener { animation ->
            val animatedValue = animation.animatedValue as Int
            binding.estimatedAmount.text = animatedValue.toString()
        }

        animator.start()

    }


    override fun onResume() {
        super.onResume()
        binding.constraint.animation = AnimationUtils.loadAnimation(context, R.anim.slide_up_two_anim)

    }

    override fun onStart() {
        super.onStart()
        binding.constraint.animation = AnimationUtils.loadAnimation(context, R.anim.slide_up_two_anim)
    }

}