package com.chathil.rawgapiwrapper.rawgSdk

import com.chathil.rawgapiwrapper.rawgSdk.cache.Database
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import com.chathil.rawgapiwrapper.rawgSdk.models.Game
import com.chathil.rawgapiwrapper.rawgSdk.network.GameRequestConfig
import com.chathil.rawgapiwrapper.rawgSdk.network.RawgApi
import com.chathil.rawgapiwrapper.rawgSdk.network.networkBoundResource
import com.chathil.rawgapiwrapper.rawgSdk.vo.Resource
import kotlinx.coroutines.flow.Flow

class RawgSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = RawgApi()
    fun getGames(
        search: String? = null,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { if (search == null) database.getAllGames() else database.searchGames(search) },
            fetch = { api.getGames(keyword = search, config = config) },
            saveFetchResult = { items -> database.cacheGames(items) },
            shouldFetch = { config.forceReload || search != null }
        )
    }
}