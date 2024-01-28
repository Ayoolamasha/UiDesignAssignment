package com.ayoolamasha.uidesignassignment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ayoolamasha.uidesignassignment.core.statusBarColor
import com.ayoolamasha.uidesignassignment.databinding.FragmentCalaulateBinding

class CalculateFragment : Fragment() {
    private lateinit var binding: FragmentCalaulateBinding

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
    }
}