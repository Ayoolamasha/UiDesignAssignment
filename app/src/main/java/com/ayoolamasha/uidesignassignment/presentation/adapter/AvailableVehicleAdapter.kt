package com.ayoolamasha.uidesignassignment.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ayoolamasha.uidesignassignment.R
import com.ayoolamasha.uidesignassignment.data.AvailableVehiclesData
import com.ayoolamasha.uidesignassignment.databinding.ItemAvailableVehiclesRecyclerDesignBinding

class AvailableVehicleAdapter :
    ListAdapter<AvailableVehiclesData, AvailableVehicleAdapter.AvailableViewHolder>(
        AvailableVehiclesDiffCallBack
    ) {

    inner class AvailableViewHolder(private val binding: ItemAvailableVehiclesRecyclerDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binds(items: AvailableVehiclesData) {
            binding.apply {
                availableVehicles = items
                executePendingBindings()
            }

            binding.imageSlide.startAnimation(AnimationUtils.loadAnimation(binding.imageSlide.context, R.anim.slide_in_right_anim))
        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AvailableViewHolder {
        return AvailableViewHolder(
            ItemAvailableVehiclesRecyclerDesignBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: AvailableViewHolder,
        position: Int
    ) {
        val availableVehicleData = getItem(position)
        holder.binds(availableVehicleData)
    }


    object AvailableVehiclesDiffCallBack : DiffUtil.ItemCallback<AvailableVehiclesData>() {
        override fun areItemsTheSame(
            oldItem: AvailableVehiclesData,
            newItem: AvailableVehiclesData
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: AvailableVehiclesData,
            newItem: AvailableVehiclesData
        ): Boolean {
            return false
        }

    }


}