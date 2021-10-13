package com.kiss.olltv.models

import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("block_id")
    val blockId: String,
    @SerializedName("block_title")
    val blockTitle: String,
    @SerializedName("block_type")
    val blockType: String,
    @SerializedName("category_name")
    val categoryName: String,
    @SerializedName("first_now_index")
    val firstNowIndex: Int,
    @SerializedName("hasMore")
    val hasMore: Long, // количество элементов от borderId до конца списка
    val items: List<TvShow>?, // массив элементов, которые нужно выводить в списке
    @SerializedName("items_number")
    val itemsNumber: String, // количество элементов в массиве items
    val offset: Long, // количество элементов от начала списка до текущего borderId
    val total: Long // общее количество элементов
)
