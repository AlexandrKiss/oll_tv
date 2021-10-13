package com.kiss.olltv.api

import com.kiss.olltv.models.Page
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService): ApiHelper {
    override suspend fun getTvShow(imei: Long, borderId: Long, direction: Int): Page {
        TODO("Not yet implemented")
    }
}