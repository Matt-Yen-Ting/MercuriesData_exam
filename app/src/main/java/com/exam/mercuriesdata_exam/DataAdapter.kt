package com.exam.mercuriesdata_exam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.exam.mercuriesdata_exam.entities.RequestDataItem
import com.exam.mercuriesdata_exam.databinding.DataListItemBinding

class DataAdapter(private val onClick: (apodSite: String) -> Unit) :
    ListAdapter<RequestDataItem, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ItemViewHolder(
            DataListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let { (holder as ItemViewHolder).bind(it) }
    }

    private inner class ItemViewHolder(
        private val binding: DataListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RequestDataItem) = with(binding) {
            ivPicture.load(item.url)
            tvTitle.text = item.title
            tvContent.text = item.description
            tvTimestamp.text = item.date
            binding.root.setOnClickListener {
                onClick.invoke(item.apodSite)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RequestDataItem>() {
            override fun areItemsTheSame(
                oldItem: RequestDataItem,
                newItem: RequestDataItem
            ): Boolean = oldItem == newItem


            override fun areContentsTheSame(
                oldItem: RequestDataItem,
                newItem: RequestDataItem
            ): Boolean = oldItem == newItem
        }

    }
}