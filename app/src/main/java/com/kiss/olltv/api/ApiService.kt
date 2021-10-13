package com.kiss.olltv.api

import com.kiss.olltv.models.Page
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("demo")
    suspend fun getTvShow(
        @Query("serial_number") imei: Long, // device IMEI
        @Query("borderId") borderId: Long, // идентификатор элемента, который является граничным в ответах сервера
        @Query("direction") direction: Int // направление листания(может принимать значения -1, 0 и 1)
    ): Page
}