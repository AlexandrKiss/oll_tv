package com.kiss.olltv.ui.main

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kiss.olltv.databinding.TvShowFullFragmentBinding

class TvShowFullFragment: Fragment() {
    private val binding by lazy { TvShowFullFragmentBinding.inflate(layoutInflater) }
    private val args: TvShowFullFragmentArgs by navArgs()

    private val tvShow by lazy { args.tvShow }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            println(tvShow.channelName)
            channelLogo.apply {
                transitionName = tvShow.icon
                Glide.with(this)
                    .load(tvShow.icon)
                    .into(this)
            }

            channelName.text = tvShow.channelName
            showName.text = tvShow.name

            if (tvShow.description.isNotEmpty())
                showDescription.text = tvShow.description
        }
    }
}