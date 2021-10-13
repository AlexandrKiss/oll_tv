package com.kiss.olltv.models

data class Subscription(
    val id: Long,
    val price: Int,
    val name: String,
    val subsId: Long,
    val type: String
)
