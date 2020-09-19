package com.chathil.rawgapiwrapper.rawgSdk.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameListRequestConfig(
    @SerialName("page")
    val page: Int? = null,
    @SerialName("page_size")
    val pageSize: Int? = null,
    @SerialName("search")
    val search: String? = null,
    val parentPlatforms: Set<Int> = emptySet(),
    val platforms: Set<Int> = emptySet(),
    val stores: Set<Int> = emptySet(),
    val developers: Set<Int> = emptySet(),
    val publishers: Set<Int> = emptySet(),
    val genres: Set<Int> = emptySet(),
    val tags: Set<Int> = emptySet(),
    val creators: Set<Int> = emptySet(),
//    val dates: Set<Int>, TODO date config
//    val platformCount: Int? = null, TODO add this later
//    val exclude_collection, TODO find out what is this
//    val excludeAddition: Boolean? = null, TODO add this later
//    val excludeParents: Boolean? = null, TODO add this later
//    val excludeGameSeries: Boolean? = null, TODO add this later
//    val ordering: Set<Order> = emptySet()
) {
    enum class Order(value: String) {
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


