package com.ayoolamasha.uidesignassignment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ayoolamasha.uidesignassignment.core.statusBarColor
import com.ayoolamasha.uidesignassignment.databinding.FragmentShipmentBinding
import com.ayoolamasha.uidesignassignment.databinding.ItemTabItemsBinding

class ShipmentFragment : Fragment() {
    private lateinit var binding: FragmentShipmentBinding

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

        val tabLayout = binding.tabLayout
        val tabTitles = listOf("All", "Completed", "In progress", "Pending order", "Cancelled")
        val badgeCounts = listOf(12, 5, 3, 4)

        for ((index, title) in tabTitles.withIndex()) {
            val tab = tabLayout.newTab()
            tab.customView = createTabView(title, badgeCounts[index])
            tabLayout.addTab(tab)
        }
    }

    private fun createTabView(title: String, badgeCount: Int): View {
        //val tabView = ItemTabItemsBinding.inflate(LayoutInflater.from(requireContext()), null, false)
        val tabView = ItemTabItemsBinding.inflate(LayoutInflater.from(requireContext()))
        val tabText = tabView.tabTex
        val badgeIcon = tabView.badgeIcon
        val badgeCountTextView = tabView.badgeCount

        tabText.text = title

        // Customize badge icon visibility
        badgeIcon.visibility = if (badgeCount > 0) View.VISIBLE else View.GONE

        // Set badge count
        badgeCountTextView.text = badgeCount.toString()

        return tabView.root
    }

}