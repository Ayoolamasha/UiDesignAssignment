package com.ayoolamasha.uidesignassignment.presentation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.Scene
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.ayoolamasha.uidesignassignment.R
import com.ayoolamasha.uidesignassignment.core.statusBarColor
import com.ayoolamasha.uidesignassignment.data.LocalDataRepository
import com.ayoolamasha.uidesignassignment.databinding.FragmentHomeBinding
import com.ayoolamasha.uidesignassignment.presentation.adapter.AvailableVehicleAdapter
import com.google.android.material.appbar.AppBarLayout

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
        binding.contentConstraint.animation = AnimationUtils.loadAnimation(context, R.anim.slide_up_anim)



        binding.searchBarConstraint.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }
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

    private fun slideDownTabLayout() {
        val tabLayoutHeight = binding.contentConstraint.height.toFloat()

        val animator = ObjectAnimator.ofFloat(binding.contentConstraint, "translationY", 0f, tabLayoutHeight)

        // Set the duration and start the animation
        animator.duration = 20000
        animator.start()
    }


    override fun onStart() {
        super.onStart()
        binding.contentConstraint.animation = AnimationUtils.loadAnimation(context, R.anim.slide_up_anim)

    }

    override fun onResume() {
        super.onResume()
        binding.contentConstraint.animation = AnimationUtils.loadAnimation(context, R.anim.slide_up_anim)
    }


}