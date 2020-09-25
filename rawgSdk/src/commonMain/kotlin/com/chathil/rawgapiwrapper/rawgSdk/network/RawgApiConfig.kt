package com.chathil.rawgapiwrapper.rawgSdk.network

import com.chathil.rawgapiwrapper.rawgSdk.models.Game
import com.chathil.rawgapiwrapper.rawgSdk.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

interface RequestConfig {
    val forceReload: Boolean
}

data class GameRequestConfig(
    val page: Int = 1,
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

data class PaginatedGameRequest(
    val init: () -> Flow<Resource<List<Game>>>,
    val next: (nextPage: Int) -> Flow<Resource<List<Game>>>
)



