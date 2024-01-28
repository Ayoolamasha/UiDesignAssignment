package com.ayoolamasha.uidesignassignment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.ayoolamasha.uidesignassignment.core.statusBarColor
import com.ayoolamasha.uidesignassignment.data.LocalDataRepository
import com.ayoolamasha.uidesignassignment.databinding.FragmentHomeBinding
import com.ayoolamasha.uidesignassignment.presentation.adapter.AvailableVehicleAdapter

class HomeFragment: Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var availableVehicleAdapter: AvailableVehicleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusBarColor()
        initRecycler()
    }

    private fun initRecycler(){
        availableVehicleAdapter = AvailableVehicleAdapter()
        availableVehicleAdapter.submitList(LocalDataRepository.availableVehiclesData())

        binding.availableVehiclesRecyler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = availableVehicleAdapter
        }

    }
}