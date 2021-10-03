package com.medalcase.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.medalcase.model.Header
import com.medalcase.model.Medal
import com.medalcase.model.RecordCollection

private val listDiffer = object : DiffUtil.ItemCallback<RecordCollection>() {
    override fun areItemsTheSame(oldItem: RecordCollection, newItem: RecordCollection): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: RecordCollection, newItem: RecordCollection): Boolean =
        oldItem == newItem
}

internal class RecordsAdapter() :
    ListAdapter<RecordCollection, MedalViewHolder>(listDiffer) {

    private val ITEM_VIEW_TYPE_HEADER = 0
    private val ITEM_VIEW_TYPE_MEDAL = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedalViewHolder {
        return when (viewType) {
        }
    }

    override fun onBindViewHolder(holder: RecyclerView, position: Int) {
        when (holder) {
            else -> {

            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Header -> ITEM_VIEW_TYPE_HEADER
            is Medal -> ITEM_VIEW_TYPE_MEDAL
        }
    }

}

internal class HeaderViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

}

internal class MedalViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

}