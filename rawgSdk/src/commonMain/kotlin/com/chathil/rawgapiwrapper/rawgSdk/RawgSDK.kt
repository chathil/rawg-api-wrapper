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

    fun allGames(
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

    fun gamesByPublishers(
        publisherId: Int,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gamesByPublisher(publisherId) },
            fetch = { api.getGames(publishersId = publisherId, config = config) },
            saveFetchResult = { items -> database.cacheGames(items, publisherId) },
            shouldFetch = { config.forceReload }
        )
    }

    fun gamesByPlatform(
        platformIds: Set<Int>,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gamesByPlatform(platformIds) },
            fetch = { api.getGames(platformIds = platformIds, config = config) },
            saveFetchResult = { items -> database.cacheGames(items) },
            shouldFetch = { config.forceReload }
        )
    }

    fun gamesByParentPlatforms(
        platformIds: Set<Int>,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gamesByParentPlatforms(platformIds) },
            fetch = { api.getGames(platformIds = platformIds, config = config) },
            saveFetchResult = { items -> database.cacheGames(items) },
            shouldFetch = { config.forceReload }
        )
    }

    fun gamesByDevelopers(
        developerIds: Set<Int>,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gamesByDevelopers(developerIds) },
            fetch = { api.getGames(developerIds = developerIds, config = config) },
            saveFetchResult = { items -> database.cacheGames(items) },
            shouldFetch = { config.forceReload }
        )
    }

    fun gamesByGenres(
        genreIds: Set<Int>,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gamesByGenres(genreIds) },
            fetch = { api.getGames(genreIds = genreIds, config = config) },
            saveFetchResult = { items -> database.cacheGames(items) },
            shouldFetch = { config.forceReload }
        )
    }

    fun gamesByTags(
        tagIds: Set<Int>,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gamesByTags(tagIds) },
            fetch = { api.getGames(tagIds = tagIds, config = config) },
            saveFetchResult = { items -> database.cacheGames(items) },
            shouldFetch = { config.forceReload }
        )
    }
}