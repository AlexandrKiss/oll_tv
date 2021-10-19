package com.kiss.olltv.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.kiss.olltv.databinding.MainFragmentBinding
import com.kiss.olltv.ui.LoaderStateAdapter
import com.kiss.olltv.ui.TvShowAdapter
import com.kiss.olltv.viewModel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment: Fragment() {
    private val binding by lazy { MainFragmentBinding.inflate(layoutInflater) }
    private val viewModel: TvShowViewModel by viewModels()

    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAdapter()
        binding.tvShowList.apply {
            adapter = tvShowAdapter
            adapter = tvShowAdapter.withLoadStateHeaderAndFooter(
                header = LoaderStateAdapter(),
                footer = LoaderStateAdapter()
            )
        }

        viewModel.getMovies().observe(this, {
            lifecycleScope.launch {
                tvShowAdapter.submitData(it)
            }
        })
    }

    private fun setAdapter() {
        tvShowAdapter = TvShowAdapter { tvShow, imageView ->
            println(tvShow.channelName)
            val extras = FragmentNavigatorExtras(imageView to tvShow.icon!!)
            val action = MainFragmentDirections.actionMainFragmentToTvShowFullFragment(tvShow)
            findNavController().navigate(action, extras)
        }
    }
}