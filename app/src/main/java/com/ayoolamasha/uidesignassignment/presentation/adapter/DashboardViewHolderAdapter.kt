package com.ayoolamasha.uidesignassignment.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ayoolamasha.uidesignassignment.presentation.CalculateFragment
import com.ayoolamasha.uidesignassignment.presentation.HomeFragment
import com.ayoolamasha.uidesignassignment.presentation.ShipmentFragment

const val HOME_FRAGMENT = 0
const val CALCULATE_FRAGMENT = 1
const val SHIPMENT_FRAGMENT = 2
const val PROFILE_FRAGMENT = 3

class DashboardViewHolderAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> CalculateFragment()
            2 -> ShipmentFragment()
            3 -> CalculateFragment()
            else -> HomeFragment()

        }
    }
}