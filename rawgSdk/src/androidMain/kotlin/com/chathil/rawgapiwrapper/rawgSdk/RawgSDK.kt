package com.chathil.rawgapiwrapper.rawgSdk

import android.app.Application
import android.content.Context
import com.chathil.rawgapiwrapper.rawgSdk.cache.Database
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import com.chathil.rawgapiwrapper.rawgSdk.models.Game
import com.chathil.rawgapiwrapper.rawgSdk.network.GameListRequestConfig
import com.chathil.rawgapiwrapper.rawgSdk.network.GameListResponse
import com.chathil.rawgapiwrapper.rawgSdk.network.RawgApi
import com.chathil.rawgapiwrapper.rawgSdk.utils.flattenToList
import com.dropbox.android.external.store4.Fetcher
import com.dropbox.android.external.store4.SourceOfTruth
import com.dropbox.android.external.store4.StoreBuilder
import com.dropbox.android.external.store4.get
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

actual class RawgSDK actual constructor(databaseDriverFactory: DatabaseDriverFactory) {
    internal actual val database = Database(databaseDriverFactory)
    internal actual val api = RawgApi()

//    @ExperimentalCoroutinesApi
//    @FlowPreview
//    @Throws(Exception::class)
//    actual suspend fun getGames(forceReload: Boolean, config: GameListRequestConfig): List<Game> {
//        return StoreBuilder
//            .from<GameListRequestConfig, GameListResponse, List<Game>>(
//                Fetcher.of { param ->
//                    api.getGames(param)
//                },
//                sourceOfTruth = SourceOfTruth.of(
//                    reader = { param -> database.getAllGames(param) },
//                    writer = { _, posts ->
//                        println(posts.results)
//                        database.cacheGames(posts)
//                    },
//                    deleteAll = { database.clearAllGames() }
//                )
//            )
//            .build().get(config)
//    }

    @Throws(Exception::class) actual suspend fun getGames(forceReload: Boolean, config: GameListRequestConfig): List<Game> {
        val cachedLaunches = database.getAllGames(config).flattenToList()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getGames(config).also {
//                database.clearAllGames()
                println("hai")
                println(it.results)
                database.cacheGames(it)
            }
            val dbResponse = database.getAllGames(config)
            return dbResponse.flattenToList()
        }
    }

    companion object {
        val TAG = RawgSDK::class.simpleName
    }
}