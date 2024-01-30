package com.ayoolamasha.uidesignassignment.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ayoolamasha.uidesignassignment.presentation.AllFragment
import com.ayoolamasha.uidesignassignment.presentation.CalculateFragment
import com.ayoolamasha.uidesignassignment.presentation.HomeFragment
import com.ayoolamasha.uidesignassignment.presentation.InProgressFragment
import com.ayoolamasha.uidesignassignment.presentation.ShipmentFragment

const val ALL_FRAGMENT = 0
const val IN_PROGRESS_FRAGMENT = 2
const val PENDING_ORDERS_FRAGMENT = 3
const val COMPLETED_FRAGMENT = 1
const val CANCELLED_FRAGMENT = 4

class ShipmentViewHolderAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllFragment()
            2 -> InProgressFragment()
            else -> AllFragment()

        }
    }
}