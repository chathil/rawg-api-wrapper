package com.chathil.rawgapiwrapper.rawgSdk.network

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class RawgApi {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    internal suspend fun getGames(config: GameListRequestConfig): GameListResponse {
        return httpClient.get(GAME)
//            config.apply {
//                page?.let {
//                    parameter("page", it)
//                }
//                pageSize?.let {
//                    parameter("page_size", it)
//                }
//                search?.let {
//                    parameter("search", it)
//                }
//            }
//        }
    }

    companion object {
        private const val BASE_URL = "https://api.rawg.io/api"
        private const val GAME = "${BASE_URL}/games"
    }
}