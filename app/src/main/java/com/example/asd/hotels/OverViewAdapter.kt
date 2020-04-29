package com.example.asd.hotels

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.hotel_layout.view.*

class OverViewAdapter(private val hotel_list: List<HotelData>) : RecyclerView.Adapter<OverViewAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(
            R.layout.hotel_layout,
            parent, false)
        return  ViewHolder(layoutView)
    }

    override fun getItemCount() = hotel_list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hotel_data = hotel_list[position]
        val priceString= "Price: "
        holder.view.textView.text = priceString.plus(hotel_data.price.toString())
        holder.view.textView2.text = hotel_data.name
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}