package com.kiss.olltv.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.kiss.olltv.models.Page
import com.kiss.olltv.models.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {
    fun getTvShow(): LiveData<PagingData<TvShow>>
}