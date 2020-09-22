package com.chathil.rawgapiwrapper.rawgSdk.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

interface RequestConfig {
    val forceReload: Boolean
}

@Serializable
data class GameRequestConfig(
//    @SerialName("page")
//    val page: Int? = null, TODO enable page when there's a multiplatform paging lib
    @SerialName("page_size")
    val pageSize: Int = 20,
    override val forceReload: Boolean = true,
//    val dates: Set<Int>, TODO date config
//    val platformCount: Int? = null, TODO add this later
//    val exclude_collection, TODO find out what is this
//    val excludeAddition: Boolean? = null, TODO add this later
//    val excludeParents: Boolean? = null, TODO add this later
//    val excludeGameSeries: Boolean? = null, TODO add this later
    val order: Order? = null
) : RequestConfig {
    enum class Order(val value: String) {
        NAME_ASC("name"),
        RELEASED_ASC("released"),
        ADDED_ASC("released"),
        CREATED_ASC("created"),
        RATING_ASC("rating"),
        NAME_DESC("-name"),
        RELEASED_DESC("-released"),
        ADDED_DESC("-added"),
        CREATED_DESC("-created"),
        RATING_DESC("-rating"),
    }
}


