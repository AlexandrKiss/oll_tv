package com.kiss.olltv.api

import com.kiss.olltv.models.Page
import retrofit2.http.Query

interface ApiHelper {
    suspend fun getTvShow( imei: Long, borderId: Long, direction: Int): Page
}