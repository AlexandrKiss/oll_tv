package com.kiss.olltv.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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

    private val tvShowAdapter = TvShowAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
}