package com.ayoolamasha.uidesignassignment.presentation

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.Scene
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.SearchView
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayoolamasha.uidesignassignment.R
import com.ayoolamasha.uidesignassignment.core.expand
import com.ayoolamasha.uidesignassignment.core.navigateToDashboardHolder
import com.ayoolamasha.uidesignassignment.core.statusBarColor
import com.ayoolamasha.uidesignassignment.data.LocalDataRepository
import com.ayoolamasha.uidesignassignment.databinding.FragmentSearchBinding
import com.ayoolamasha.uidesignassignment.presentation.adapter.SearchDataAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchDataAdapter: SearchDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigateToDashboardHolder()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusBarColor()
       initRecycler()
        binding.searchBarConstraint.animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_left__two_anim)
        lifecycleScope.launch {
            delay(100)
            binding.backArrow.animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_left_anim)
        }

        binding.backArrow.setOnClickListener { navigateToDashboardHolder() }


        binding.searchText.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                searchDataAdapter.filter.filter(p0)

                return true
            }

        })


    }


    private fun initRecycler(){
        searchDataAdapter = SearchDataAdapter()
        searchDataAdapter.setData(LocalDataRepository.searchItemsData())

        binding.searchRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            animation = AnimationUtils.loadAnimation(context, R.anim.slide_up_anim)
            adapter = searchDataAdapter
        }
    }
}