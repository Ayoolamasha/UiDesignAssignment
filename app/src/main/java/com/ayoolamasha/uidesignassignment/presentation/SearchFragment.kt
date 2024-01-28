package com.ayoolamasha.uidesignassignment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayoolamasha.uidesignassignment.core.statusBarColor
import com.ayoolamasha.uidesignassignment.data.LocalDataRepository
import com.ayoolamasha.uidesignassignment.databinding.FragmentSearchBinding
import com.ayoolamasha.uidesignassignment.presentation.adapter.SearchDataAdapter

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchDataAdapter: SearchDataAdapter

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
    }


    private fun initRecycler(){
        searchDataAdapter = SearchDataAdapter()
        searchDataAdapter.setData(LocalDataRepository.searchItemsData())

        binding.searchRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = searchDataAdapter
        }
    }
}