package com.lara.s.lopez.stockapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lara.s.lopez.domain.model.Stock
import com.lara.s.lopez.stockapplication.util.OnItemClickListener
import com.lara.s.lopez.stockapplication.R

class StocksAdapter(private val stocks: List<Stock>) :
    RecyclerView.Adapter<StocksAdapter.ViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.name)
        private val hot = view.findViewById<TextView>(R.id.hot)
        fun bind(stock: List<Stock>, position: Int, listener: OnItemClickListener) {
            name.text = stock[position].name
            hot.text = stock[position].hot.toString()
            itemView.setOnClickListener {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stocks, position, onItemClickListener)
    }

    override fun getItemCount(): Int = stocks.size

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

}