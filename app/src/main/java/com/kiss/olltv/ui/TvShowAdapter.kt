package com.kiss.olltv.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kiss.olltv.databinding.TvShowItemBinding
import com.kiss.olltv.models.TvShow
import java.text.SimpleDateFormat
import java.util.*

class TvShowAdapter(private val tvShowCallback: (tvShow: TvShow, imageView: ImageView) -> Unit
): PagingDataAdapter<TvShow, TvShowAdapter.TvShowHolder>(TvShowDiffItemCallback) {

    class TvShowHolder(binding: TvShowItemBinding,
                       private val tvShowCallback: (tvShow: TvShow, imageView: ImageView) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {
        private val root = binding.root
        private val logo = binding.logo
        private val name = binding.name
        private val time = binding.time

        fun bind(tvShow: TvShow?) {

            if (tvShow != null) {
                logo.apply {
                    transitionName = tvShow.icon
                    Glide.with(this)
                        .load(tvShow.icon)
                        .into(this)
                }
                name.text = tvShow.name

                val dateFormat = SimpleDateFormat("dd.MM HH:mm", Locale.getDefault())
                time.text = dateFormat.format(tvShow.start)

                root.setOnClickListener { tvShowCallback(tvShow, logo) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TvShowItemBinding.inflate(inflater, parent, false)
        return TvShowHolder(binding, tvShowCallback)
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
