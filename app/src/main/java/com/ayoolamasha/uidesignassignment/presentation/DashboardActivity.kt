package com.ayoolamasha.uidesignassignment.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayoolamasha.uidesignassignment.databinding.ActivityDashboardHolderBinding

class DashboardActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDashboardHolderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardHolderBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}