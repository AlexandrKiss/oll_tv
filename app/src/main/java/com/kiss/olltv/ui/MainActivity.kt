package com.kiss.olltv.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kiss.olltv.databinding.ActivityMainBinding
import com.kiss.olltv.viewModel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: TvShowViewModel by viewModels()

    private val tvShowAdapter = TvShowAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.tvShowList.apply {
            adapter = tvShowAdapter
            adapter = tvShowAdapter.withLoadStateHeaderAndFooter(
                header = LoaderStateAdapter(),
                footer = LoaderStateAdapter()
            )
        }

        viewModel.getMovies().observe(this@MainActivity, {
            lifecycleScope.launch {
                tvShowAdapter.submitData(it)
            }
        })
    }
}