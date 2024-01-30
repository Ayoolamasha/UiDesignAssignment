package com.ayoolamasha.uidesignassignment.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ayoolamasha.uidesignassignment.R
import com.ayoolamasha.uidesignassignment.data.ShipmentData
import com.ayoolamasha.uidesignassignment.databinding.ItemShipmentRecyclerDesignBinding

class ShipmentHistoryAdapter :
    ListAdapter<ShipmentData, ShipmentHistoryAdapter.ShipmentViewHolder>(ShipmentDiffCallBack) {

    inner class ShipmentViewHolder(private val binding: ItemShipmentRecyclerDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binds(items: ShipmentData) {
            binding.apply {
                shipmentDetails = items
                executePendingBindings()
            }

            binding.recyclerCardHolder.startAnimation(AnimationUtils.loadAnimation(binding.recyclerCardHolder.context, R.anim.slide_up_anim))
        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShipmentViewHolder {
        return ShipmentViewHolder(
            ItemShipmentRecyclerDesignBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ShipmentViewHolder,
        position: Int
    ) {
        val shipmentData = getItem(position)
        holder.binds(shipmentData)
    }


    object ShipmentDiffCallBack : DiffUtil.ItemCallback<ShipmentData>() {
        override fun areItemsTheSame(
            oldItem: ShipmentData,
            newItem: ShipmentData
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ShipmentData,
            newItem: ShipmentData
        ): Boolean {
            return false
        }

    }


}