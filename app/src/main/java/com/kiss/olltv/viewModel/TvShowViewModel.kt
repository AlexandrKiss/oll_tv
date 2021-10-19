package com.kiss.olltv.viewModel

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.kiss.olltv.api.ApiHelper
import com.kiss.olltv.models.Page
import com.kiss.olltv.models.TvShow
import com.kiss.olltv.repository.TvShowPagingSource
import com.kiss.olltv.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(private val repository: TvShowRepository): ViewModel() {
    fun getMovies(): LiveData<PagingData<TvShow>> =
        repository.getTvShow()
            .cachedIn(viewModelScope)
}