package com.tony.baseadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

//abstract class BaseAdapter<T>(
//    private val itemClickListener: (T) -> Unit,
//    private val layoutResId: Int,
//    private val bindViewHolder: (BaseAdapter<T>.ItemViewHolder, T) -> Unit
//) : RecyclerView.Adapter<BaseAdapter<T>.ItemViewHolder>() {
//
//    private var items: List<T> = listOf()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
//        return ItemViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        val item = items[position]
//        bindViewHolder.invoke(holder, item)
//        holder.itemView.setOnClickListener { itemClickListener.invoke(item) }
//    }
//
//    override fun getItemCount(): Int = items.size
//
//    fun setItems(newItems: List<T>) {
//        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
//            override fun getOldListSize(): Int = items.size
//
//            override fun getNewListSize(): Int = newItems.size
//
//            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//                return items[oldItemPosition] == newItems[newItemPosition]
//            }
//
//            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//                return items[oldItemPosition] == newItems[newItemPosition]
//            }
//        })
//        items = newItems
//        diffResult.dispatchUpdatesTo(this)
//    }
//
//    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
//}

abstract class BaseAdapter<T>(
    private val itemClickListener: (T) -> Unit,
    private val layoutResId: Int,
    private val bindViewHolder: (BaseAdapter<T>.ItemViewHolder, T) -> Unit
) : ListAdapter<T, BaseAdapter<T>.ItemViewHolder>(ItemDiffCallback<T>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        bindViewHolder.invoke(holder, item)
        holder.itemView.setOnClickListener { itemClickListener.invoke(item) }
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private class ItemDiffCallback<T> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
            return oldItem == newItem
        }
    }
}

