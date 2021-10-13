package com.kiss.olltv.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kiss.olltv.BuildConfig
import com.kiss.olltv.api.ApiHelper
import com.kiss.olltv.api.ApiHelperImpl
import com.kiss.olltv.api.ApiService
import com.kiss.olltv.other.BooleanTypeAdapter
import com.kiss.olltv.other.Constants
import com.kiss.olltv.other.DateTypeAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiHelperModule {
    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient =
            OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)

        return if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClient.addInterceptor(loggingInterceptor).build()
        } else {
            okHttpClient.build()
        }
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson = GsonBuilder()
        .registerTypeAdapter(Boolean::class.java, BooleanTypeAdapter())
        .registerTypeAdapter(Date::class.java, DateTypeAdapter())
        .create()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String, gsonBuilder: Gson): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideNewsApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper
}