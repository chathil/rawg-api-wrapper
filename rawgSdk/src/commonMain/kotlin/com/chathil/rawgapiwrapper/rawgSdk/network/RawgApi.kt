package com.chathil.rawgapiwrapper.rawgSdk.network

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*

class RawgApi {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    /**
     * TODO For now only one the id sets can be set at a time.
     * Make this able to set multiple params at a time.
     */
    internal suspend fun getGames(
        keyword: String? = null,
        publishersId: Int? = null,
        platformIds: Set<Int>? = null,
        parentPlatformIds: Set<Int>? = null,
        developerIds: Set<Int>? = null,
        genreIds: Set<Int>? = null,
        tagIds: Set<Int>? = null,
        config: GameRequestConfig
    ): GameListResponse {
        return httpClient.get(GAME) {
            config.apply {
                parameter("page_size", pageSize)
                config.order?.let {
                    parameter("ordering", it.value)
                }
            }
            keyword?.let {
                parameter("search", it)
            }
            publishersId?.let {
                parameter("publishers", it)
            }
            platformIds?.let {
                parameter("platform", it.toString().subSequence(1, it.toString().length))
            }
            parentPlatformIds?.let {
                parameter("parent_platforms", it.toString().subSequence(1, it.toString().length))
            }
            developerIds?.let {
                parameter("developers", it.toString().subSequence(1, it.toString().length))
            }
            genreIds?.let {
                parameter("genres", it.toString().subSequence(1, it.toString().length))
            }
            tagIds?.let {
                parameter("tags", it.toString().subSequence(1, it.toString().length))
            }
        }
    }

    companion object {
        private const val BASE_URL = "https://api.rawg.io/api"
        private const val GAME = "${BASE_URL}/games"
    }
}