package com.keepcoding.keepcoding_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*
import java.util.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {

    private val mData = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val element = mData[position]
        holder.bindItem(element)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun addAll(items: ArrayList<String>) {
        if (items.size > 0) {
            val prevSize = mData.size
            this.mData.addAll(prevSize, items)
            notifyItemRangeInserted(prevSize, items.size)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: String) {
            Picasso.get().load(item).into(itemView.image)
        }
    }

    companion object {
        private const val TYPE_GLEAMIO_ITEM = 0
        private const val TYPE_AD_ITEM = 1
        private const val TYPE_HEADER_ITEM = 2
        private const val TYPE_LOADING_ITEM = 3
    }
}
