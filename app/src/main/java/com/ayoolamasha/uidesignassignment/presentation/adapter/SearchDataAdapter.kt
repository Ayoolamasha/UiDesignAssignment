package com.ayoolamasha.uidesignassignment.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ayoolamasha.uidesignassignment.data.SearchData
import com.ayoolamasha.uidesignassignment.databinding.ItemSearchItemsRecyclerDesignBinding

class SearchDataAdapter : ListAdapter<SearchData, SearchDataAdapter.SearchViewHolder>(
    SearchDiffCallBack
), Filterable {

    private var searchList: ArrayList<SearchData> = ArrayList()
    private var searchListFiltered: ArrayList<SearchData> = ArrayList()


    inner class SearchViewHolder(private val binding: ItemSearchItemsRecyclerDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binds(items: SearchData) {
            binding.apply {
                searchItems = items
                executePendingBindings()
            }
        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder {
        return SearchViewHolder(
            ItemSearchItemsRecyclerDesignBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: SearchViewHolder,
        position: Int
    ) {
        holder.binds(searchListFiltered[position])

    }


    object SearchDiffCallBack : DiffUtil.ItemCallback<SearchData>() {
        override fun areItemsTheSame(
            oldItem: SearchData,
            newItem: SearchData
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: SearchData,
            newItem: SearchData
        ): Boolean {
            return false
        }

    }

    fun setData(list: List<SearchData>) {
        val arrayList: ArrayList<SearchData> = ArrayList(list)
        this.searchList = arrayList
        //this.searchList = list as ArrayList<SearchData>
        searchListFiltered = searchList
        submitList(list)
    }

    override fun getItemCount(): Int {
        return searchListFiltered.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    searchListFiltered = searchList
                } else {
                    val resultList = ArrayList<SearchData>()
                    for (row in searchList) {
                        if (row.searchItemName.lowercase()
                                .contains(constraint.toString().lowercase()) ||
                            row.searchItemShipmentCode.lowercase()
                                .contains(constraint.toString().lowercase()) ||
                            row.searchItemSenderLocation.lowercase()
                                .contains(constraint.toString().lowercase()) ||
                            row.searchItemReceiverLocation.lowercase()
                                .contains(constraint.toString().lowercase())
                        ) {
                            resultList.add(row)
                        }
                    }
                    searchListFiltered = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = searchListFiltered
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                searchListFiltered = results?.values as ArrayList<SearchData>
                submitList(searchListFiltered)

            }
        }
    }
}
