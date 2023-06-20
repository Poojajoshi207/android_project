package com.example.assignment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R

class RestaurantLoadStateAdapter (private val retry: () -> Unit):
    LoadStateAdapter<RestaurantLoadStateAdapter.LoadStateViewHolder>() {


    inner class LoadStateViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.load_state_footer, parent, false)
        return LoadStateViewHolder (itemView)
    }


}