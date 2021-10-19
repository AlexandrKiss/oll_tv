package com.kiss.olltv.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kiss.olltv.databinding.TvShowItemBinding
import com.kiss.olltv.models.TvShow
import java.text.SimpleDateFormat
import java.util.*

class TvShowAdapter: PagingDataAdapter<TvShow, TvShowAdapter.TvShowHolder>(TvShowDiffItemCallback) {
    class TvShowHolder(binding: TvShowItemBinding): RecyclerView.ViewHolder(binding.root) {
        private val logo = binding.logo
        private val name = binding.name
        private val time = binding.time

        fun bind(tvShow: TvShow?) {
            Glide.with(logo).load(tvShow?.icon).into(logo)
            name.text = tvShow?.name

            if (tvShow != null) {
                val dateFormat = SimpleDateFormat("dd.MM HH:mm", Locale.getDefault())
                time.text = dateFormat.format(tvShow.start)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TvShowItemBinding.inflate(inflater, parent, false)
        return TvShowHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private object TvShowDiffItemCallback : DiffUtil.ItemCallback<TvShow>() {
    override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
        return oldItem == newItem
    }

}
