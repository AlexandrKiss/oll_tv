package com.kiss.olltv.models

import com.google.gson.annotations.SerializedName

data class TvShow(
    val id: Long, // уникальный идентификатор записи (нужно подставлять в качестве значения borderId)
    @SerializedName("channel_id")
    val channelId: Long,
    @SerializedName("channel_name")
    val channelName: Long,
    val alias: String,
    val icon: String?, // ссылка на логотип телеканала
    val name: String, // название телепередачи
    val description: String,
    val start: String,
    @SerializedName("start_ts")
    val startTs: Long,
    val stop: String,
    @SerializedName("stop_ts")
    val stopTs: String,
    @SerializedName("is_free")
    val isFree: Boolean,
    @SerializedName("is_favorite")
    val isFavorite: Boolean,
    @SerializedName("under_parental_protect")
    val underParentalProtect: Boolean,
    val dvr: Boolean,
    val now: Boolean,
    @SerializedName("FK_catalog")
    val fkCatalog: Long,
    val subscription: Subscription
)
