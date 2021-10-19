package com.kiss.olltv.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kiss.olltv.api.ApiHelper
import com.kiss.olltv.data.PageParam
import androidx.paging.PagingSource.LoadResult.Page
import com.kiss.olltv.models.TvShow
import javax.inject.Inject

class TvShowPagingSource @Inject constructor(private val apiHelper: ApiHelper):
    PagingSource<PageParam, TvShow>() {

    override suspend fun load(params: LoadParams<PageParam>): LoadResult<PageParam, TvShow> {
        val pageParam = params.key
        val data = if (pageParam != null) {
            apiHelper.getTvShow(pageParam.imei, pageParam.borderId,pageParam.direction)
        } else {
            apiHelper.getTvShow(123456789012345, 0,0)
        }

        val loadedData =
            if (pageParam?.direction ?: 1 > 0)
                data.items!!.map { it }
            else
                data.items!!.reversed().map { it }

        return Page(
            data = loadedData,
            prevKey = PageParam(123456789012345, data.items.last().id, -1),
            nextKey = PageParam(123456789012345, data.items.last().id, 1)
        )
    }

    override fun getRefreshKey(state: PagingState<PageParam, TvShow>): PageParam? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }
}