package com.kiss.olltv.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.kiss.olltv.api.ApiHelper
import javax.inject.Inject

class TvShowRepositoryImpl @Inject constructor(private val apiHelper: ApiHelper):
    TvShowRepository {

    companion object {
        const val PAGE_SIZE = 40
    }

    override fun getTvShow() = Pager(PagingConfig(PAGE_SIZE)) {
        TvShowPagingSource(apiHelper)
    }.liveData
}