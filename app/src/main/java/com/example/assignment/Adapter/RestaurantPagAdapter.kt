package com.example.assignment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment.Model.Businesses
import com.example.assignment.R

class RestaurantPagAdapter() : PagingDataAdapter<Businesses, RestaurantPagAdapter.MyView>(
    RESTAURANT_COMPARATOR) {


    inner class MyView(view: View): RecyclerView.ViewHolder(view){
        var  tvName : TextView = view.findViewById(R.id.tv_restro_name)
        var  tv_address : TextView = view.findViewById(R.id.tv_restro_address)
        var  tv_status : TextView = view.findViewById(R.id.tv_restro_status)
        var  tv_rating : TextView = view.findViewById(R.id.tv_restro_rating)
        var  ivImage : ImageView = view.findViewById(R.id.iv_restro_img)


    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
       var businesses=getItem(position)
        if (businesses != null) {
            holder.tvName.text = businesses.name
            holder.tv_address.text=businesses.location?.address1
            holder.tv_rating.text=""+businesses.rating
            if (businesses.isClosed == true){
                holder.tv_status.text="Currently Open"
            }else{
                holder.tv_status.text="Currently Closed"
            }

            Glide.with(holder.ivImage)
                .load(businesses.imageUrl)
                .circleCrop()
                .into(holder.ivImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurant_detail_sigle_row, parent, false)
        return MyView(itemView)
    }



    companion object {
        private val RESTAURANT_COMPARATOR = object : DiffUtil.ItemCallback<Businesses>() {
            override fun areItemsTheSame(oldItem: Businesses, newItem: Businesses) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Businesses, newItem: Businesses) =
                oldItem == newItem

        }
    }
}