package com.ayoolamasha.uidesignassignment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayoolamasha.uidesignassignment.R
import com.ayoolamasha.uidesignassignment.data.LocalDataRepository
import com.ayoolamasha.uidesignassignment.databinding.FragmentAllShipmentBinding
import com.ayoolamasha.uidesignassignment.presentation.adapter.ShipmentHistoryAdapter

class AllFragment : Fragment() {
    private lateinit var binding: FragmentAllShipmentBinding
    private lateinit var shipmentHistoryAdapter: ShipmentHistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllShipmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }


    private fun initRecycler(){
        shipmentHistoryAdapter = ShipmentHistoryAdapter()
        shipmentHistoryAdapter.submitList(LocalDataRepository.allShipmentDataSource())

        binding.allShipmentRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            animation = AnimationUtils.loadAnimation(context, R.anim.slide_up_anim)
            adapter = shipmentHistoryAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        initRecycler()
    }

}