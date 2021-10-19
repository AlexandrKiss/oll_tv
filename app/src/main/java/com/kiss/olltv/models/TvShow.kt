package com.kiss.olltv.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

/**
 * @param id уникальный идентификатор записи (нужно подставлять в качестве значения borderId)
 * @param channelName название телеканала
 * @param icon ссылка на логотип телеканала
 * @param name название телепередачи
 * @param start время начала телепередачи
 * @param stop время окончания телепередачи
 */
data class TvShow(
    val id: Long,
    @SerializedName("channel_id")
    val channelId: Long,
    @SerializedName("channel_name")
    val channelName: String,
    val alias: String,
    val icon: String?,
    val name: String,
    val description: String,
    val start: Date,
    @SerializedName("start_ts")
    val startTs: Long,
    val stop: Date,
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
    @SerializedName("subs")
    val subscription: Subscription
): Serializable
