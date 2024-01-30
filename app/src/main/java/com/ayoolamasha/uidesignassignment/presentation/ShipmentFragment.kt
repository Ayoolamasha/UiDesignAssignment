package com.ayoolamasha.uidesignassignment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.ayoolamasha.uidesignassignment.R
import com.ayoolamasha.uidesignassignment.core.navigateToDashboardHolder
import com.ayoolamasha.uidesignassignment.core.statusBarColor
import com.ayoolamasha.uidesignassignment.databinding.FragmentShipmentBinding
import com.ayoolamasha.uidesignassignment.presentation.adapter.ALL_FRAGMENT
import com.ayoolamasha.uidesignassignment.presentation.adapter.CANCELLED_FRAGMENT
import com.ayoolamasha.uidesignassignment.presentation.adapter.COMPLETED_FRAGMENT
import com.ayoolamasha.uidesignassignment.presentation.adapter.IN_PROGRESS_FRAGMENT
import com.ayoolamasha.uidesignassignment.presentation.adapter.PENDING_ORDERS_FRAGMENT
import com.ayoolamasha.uidesignassignment.presentation.adapter.ShipmentViewHolderAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ShipmentFragment : Fragment() {
    private lateinit var binding: FragmentShipmentBinding


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
        binding = FragmentShipmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusBarColor()
        binding.actionTabs.animation =
            AnimationUtils.loadAnimation(context, R.anim.slide_in_right_anim)
        binding.shipmentLinear.animation =
            AnimationUtils.loadAnimation(context, R.anim.slide_up_anim)

        binding.backArrow.setOnClickListener { navigateToDashboardHolder() }


        val viewPager = binding.viewPager

        viewPager.adapter = ShipmentViewHolderAdapter(this)
        viewPager.isUserInputEnabled = false
        getTabTitles()



        binding.actionTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //binding.actionTabs.animation = AnimationUtils.loadAnimation(context, R.anim.bounce_anim)
                when (tab?.position) {
                    1 -> {
                        tabBadges(tabs = tab, badgeNumber = 5)
                    }

                    2 -> {
                        tabBadges(tabs = tab, badgeNumber = 3)
                    }

                    3 -> {
                        tabBadges(tabs = tab, badgeNumber = 4)
                    }
                }
                val badge = tab?.orCreateBadge
                if (badge != null) {
                    badge.backgroundColor =
                        ContextCompat.getColor(requireContext(), R.color.color_secondary)
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val badge = tab?.orCreateBadge
                if (badge != null) {
                    badge.backgroundColor =
                        ContextCompat.getColor(requireContext(), R.color.color_primary_two)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                val badge = tab?.orCreateBadge
                if (badge != null) {
                    badge.backgroundColor =
                        ContextCompat.getColor(requireContext(), R.color.color_secondary)
                }
            }

        })
    }

    private fun getTabTitles() {
        TabLayoutMediator(binding.actionTabs, binding.viewPager) { tabs, position ->
            when (position) {
                ALL_FRAGMENT -> {
                    tabs.text = getString(R.string.all)
                    tabBadges(tabs = tabs, badgeNumber = 12)

                }

                COMPLETED_FRAGMENT -> {
                    tabs.text = getString(R.string.completed)
                    notSelectedTabBadges(tabs = tabs, badgeNumber = 5)


                }

                IN_PROGRESS_FRAGMENT -> {
                    tabs.text = getString(R.string.in_progress_c)
                    notSelectedTabBadges(tabs = tabs, badgeNumber = 3)

                }

                PENDING_ORDERS_FRAGMENT -> {
                    tabs.text = getString(R.string.pending_orders)
                    notSelectedTabBadges(tabs = tabs, badgeNumber = 4)

                }

                CANCELLED_FRAGMENT -> {
                    tabs.text = getString(R.string.cancelled)
                }
            }

        }.attach()
    }

    private fun tabBadges(tabs: TabLayout.Tab, badgeNumber: Int) {
        val badge = tabs.orCreateBadge
        badge.number = badgeNumber
        badge.bounds.left
        badge.backgroundColor =
            ContextCompat.getColor(requireContext(), R.color.color_secondary)
    }

    private fun notSelectedTabBadges(tabs: TabLayout.Tab, badgeNumber: Int) {
        val badge = tabs.orCreateBadge
        badge.number = badgeNumber
        badge.bounds.left
        badge.backgroundColor =
            ContextCompat.getColor(requireContext(), R.color.color_primary_two)
    }


    override fun onResume() {
        super.onResume()
        binding.actionTabs.getTabAt(0)?.isSelected
        binding.shipmentLinear.animation =
            AnimationUtils.loadAnimation(context, R.anim.slide_up_anim)
    }

}