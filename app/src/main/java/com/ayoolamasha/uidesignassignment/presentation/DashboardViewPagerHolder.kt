package com.ayoolamasha.uidesignassignment.presentation

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.ayoolamasha.uidesignassignment.R
import com.ayoolamasha.uidesignassignment.core.DepthPageTransformer
import com.ayoolamasha.uidesignassignment.core.ExpandPageTransformer
import com.ayoolamasha.uidesignassignment.core.ZoomOutPageTransformer
import com.ayoolamasha.uidesignassignment.databinding.FragmentDashboardHolderBinding
import com.ayoolamasha.uidesignassignment.presentation.adapter.CALCULATE_FRAGMENT
import com.ayoolamasha.uidesignassignment.presentation.adapter.DashboardViewHolderAdapter
import com.ayoolamasha.uidesignassignment.presentation.adapter.HOME_FRAGMENT
import com.ayoolamasha.uidesignassignment.presentation.adapter.PROFILE_FRAGMENT
import com.ayoolamasha.uidesignassignment.presentation.adapter.SHIPMENT_FRAGMENT
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class DashboardViewPagerHolder : Fragment() {
    private lateinit var binding: FragmentDashboardHolderBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardHolderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.viewPager

        viewPager.adapter = DashboardViewHolderAdapter(this)
        viewPager.isUserInputEnabled = false
        getTabTitles()


        binding.actionTabs.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
              slideDownTabLayout()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })


    }

    private fun getTabTitles(){
        TabLayoutMediator(binding.actionTabs, binding.viewPager) { tabs, position ->
            when (position) {
                HOME_FRAGMENT ->{
                   tabs.text = getString(R.string.home)
                    tabs.icon = ContextCompat.getDrawable(requireContext(), R.drawable.home_icon)
                }
                CALCULATE_FRAGMENT ->{
                   tabs.text = getString(R.string.calculate)
                    tabs.icon = ContextCompat.getDrawable(requireContext(), R.drawable.calculate_icon)


                }

                SHIPMENT_FRAGMENT ->{
                   tabs.text = getString(R.string.shipment)
                    tabs.icon = ContextCompat.getDrawable(requireContext(), R.drawable.shipment_outline)
                }

                PROFILE_FRAGMENT ->{
                   tabs.text = getString(R.string.profile)
                    tabs.icon = ContextCompat.getDrawable(requireContext(), R.drawable.profile_icon)
                }
            }

        }.attach()
    }


    private fun slideDownTabLayout() {
        val tabLayoutHeight = binding.actionTabs.height.toFloat()

        val animator = ObjectAnimator.ofFloat(binding.actionTabs, "translationY", 0f, tabLayoutHeight)

        // Set the duration and start the animation
        animator.duration = 1000
        animator.start()
    }



}