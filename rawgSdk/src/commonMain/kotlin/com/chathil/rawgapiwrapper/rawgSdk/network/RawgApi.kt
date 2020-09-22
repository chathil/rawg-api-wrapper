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

    internal suspend fun getGames(keyword: String?, config: GameRequestConfig): GameListResponse {
        return httpClient.get(GAME){
            config.apply {
                parameter("page_size", pageSize)
                config.order?.let {
                    parameter("ordering", it.value)
                }
            }
            keyword?.let {
                parameter("search", it)
            }
        }
    }

    companion object {
        private const val BASE_URL = "https://api.rawg.io/api"
        private const val GAME = "${BASE_URL}/games"
    }
}