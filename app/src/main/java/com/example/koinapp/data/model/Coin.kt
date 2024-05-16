package com.example.koinapp.data.model

import com.google.gson.annotations.SerializedName

data class Coin(
    @field:SerializedName("24hVolume")
    val Volume: String,
    val btcPrice: String,
    val change: String,
    val coinrankingUrl: String,
    val color: String,
    val contractAddresses: List<Any>,
    val iconUrl: String,
    val listedAt: Int,
    val lowVolume: Boolean,
    val marketCap: String,
    val name: String,
    val price: String,
    val rank: Int,
    val sparkline: List<String>,
    val symbol: String,
    val tier: Int,
    val uuid: String
)