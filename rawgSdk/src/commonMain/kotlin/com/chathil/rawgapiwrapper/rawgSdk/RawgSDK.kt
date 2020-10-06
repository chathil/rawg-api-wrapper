package com.chathil.rawgapiwrapper.rawgSdk

import com.chathil.rawgapiwrapper.rawgSdk.cache.Database
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import com.chathil.rawgapiwrapper.rawgSdk.models.Game
import com.chathil.rawgapiwrapper.rawgSdk.network.GameRequestConfig
import com.chathil.rawgapiwrapper.rawgSdk.network.PaginatedGameRequest
import com.chathil.rawgapiwrapper.rawgSdk.network.RawgApi
import com.chathil.rawgapiwrapper.rawgSdk.network.networkBoundResource
import com.chathil.rawgapiwrapper.rawgSdk.vo.Resource
import kotlinx.coroutines.flow.Flow

class RawgSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = RawgApi()

    fun paginatedGames(
        search: String? = null
    ) = PaginatedGameRequest(
        init = { games(search) },
        next = { page ->
            games(search, GameRequestConfig(forceReload = false, page = page))
        }
    )

    fun paginatedGamesByPublisher(
        publisherId: Int
    ) = PaginatedGameRequest(
        init = { gamesByPublisher(publisherId) },
        next = { page ->
            gamesByPublisher(
                publisherId,
                GameRequestConfig(forceReload = false, page = page)
            )
        }
    )

    fun paginatedGamesByPlatforms(
        platformIds: Set<Int>
    ) = PaginatedGameRequest(
        init = { gamesByPlatforms(platformIds) },
        next = { page ->
            gamesByPlatforms(
                platformIds,
                GameRequestConfig(forceReload = false, page = page)
            )
        }
    )

    fun paginatedGamesByParentPlatforms(
        platformIds: Set<Int>
    ) = PaginatedGameRequest(
        init = { gamesByParentPlatforms(platformIds) },
        next = { page ->
            gamesByParentPlatforms(
                platformIds,
                GameRequestConfig(forceReload = false, page = page)
            )
        }
    )

    //    TODO test paginatedGamesByDevelopers
    fun paginatedGamesByDevelopers(
        developerIds: Set<Int>
    ) = PaginatedGameRequest(
        init = { gamesByDevelopers(developerIds = developerIds) },
        next = { page ->
            gamesByDevelopers(
                developerIds,
                GameRequestConfig(forceReload = false, page = page)
            )
        }
    )

    //    TODO test paginatedGamesByGenres
    fun paginatedGamesByGenres(
        genreIds: Set<Int>
    ) = PaginatedGameRequest(
        init = { gamesByGenres(genreIds) },
        next = { page ->
            gamesByGenres(
                genreIds,
                GameRequestConfig(forceReload = false, page = page)
            )
        }
    )

    //    TODO test paginatedGamesByTags
    fun paginatedGamesByTags(
        tagIds: Set<Int>
    ) = PaginatedGameRequest(
        init = { gamesByTags(tagIds) },
        next = { page -> gamesByTags(tagIds, GameRequestConfig(forceReload = false, page = page)) }
    )

    fun games(
        search: String? = null,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = {
                if (search == null) database.allGames(
                    page = config.page
                ) else database.searchGames(
                    keyword = search,
                    page = config.page
                )
            },
            fetch = {
                api.allGames(keyword = search, config = config)
            },
            saveFetchResult = { items ->
                if (config.forceReload)
                    database.clearGames()
                database.cacheGames(items, group = if (search != null) "search" else "all")
            },
            shouldFetch = { it.isNullOrEmpty() || config.forceReload || search != null }
        )
    }

    fun gamesByPublisher(
        publisherId: Int,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gamesByPublisher(publisherId, config.page) },
            fetch = { api.allGames(publishersId = publisherId, config = config) },
            saveFetchResult = { items -> database.cacheGames(items, publisherId, "publishers") },
            shouldFetch = { it.isNullOrEmpty() || config.forceReload }
        )
    }

    fun gamesByPlatforms(
        platformIds: Set<Int>,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gamesByPlatform(platformIds, config.page) },
            fetch = { api.allGames(platformIds = platformIds, config = config) },
            saveFetchResult = { items ->
                database.cacheGames(
                    gameListResponse = items,
                    group = "platforms"
                )
            },
            shouldFetch = { it.isNullOrEmpty() || config.forceReload }
        )
    }

    fun gamesByParentPlatforms(
        platformIds: Set<Int>,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gamesByParentPlatforms(platformIds, config.page) },
            fetch = { api.allGames(parentPlatformIds = platformIds, config = config) },
            saveFetchResult = { items ->
                database.cacheGames(
                    gameListResponse = items,
                    group = "parent_platforms"
                )
            },
            shouldFetch = { it.isNullOrEmpty() || config.forceReload }
        )
    }

    fun gamesByDevelopers(
        developerIds: Set<Int>,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gamesByDevelopers(developerIds, config.page) },
            fetch = { api.allGames(developerIds = developerIds, config = config) },
            saveFetchResult = { items -> database.cacheGames(items, group = "developers") },
            shouldFetch = { it.isNullOrEmpty() || config.forceReload }
        )
    }

    fun gamesByGenres(
        genreIds: Set<Int>,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gamesByGenres(genreIds, config.page) },
            fetch = { api.allGames(genreIds = genreIds, config = config) },
            saveFetchResult = { items -> database.cacheGames(items, group = "genres") },
            shouldFetch = { it.isNullOrEmpty() || config.forceReload }
        )
    }

    fun gamesByTags(
        tagIds: Set<Int>,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gamesByTags(tagIds, config.page) },
            fetch = { api.allGames(tagIds = tagIds, config = config) },
            saveFetchResult = { items -> database.cacheGames(items, group = "tags") },
            shouldFetch = { it.isNullOrEmpty() || config.forceReload }
        )
    }

    fun gameAdditions(
        gameId: Int,
        config: GameRequestConfig = GameRequestConfig()
    ): Flow<Resource<List<Game>>> {
        return networkBoundResource(
            query = { database.gameExtras(gameId, "additions") },
            fetch = { api.gameAdditions(gameId = gameId, config = config) },
            saveFetchResult = { items ->
                database.cacheGames(
                    items,
                    group = "${gameId}/additions"
                )
            },
            shouldFetch = { it.isNullOrEmpty() || config.forceReload }
        )
    }

    fun paginatedGameAdditions(gameId: Int) =
        PaginatedGameRequest(
            init = { gameAdditions(gameId) },
            next = { page ->
                gameAdditions(
                    gameId,
                    GameRequestConfig(forceReload = false, page = page)
                )
            }
        )
}