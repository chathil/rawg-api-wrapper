package com.chathil.rawgapiwrapper.rawgSdk

import com.chathil.rawgapiwrapper.rawgSdk.cache.Database
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import com.chathil.rawgapiwrapper.rawgSdk.models.Game
import com.chathil.rawgapiwrapper.rawgSdk.network.GameListResponse
import com.chathil.rawgapiwrapper.rawgSdk.network.RawgApi
import com.dropbox.android.external.store4.Fetcher
import com.dropbox.android.external.store4.SourceOfTruth
import com.dropbox.android.external.store4.StoreBuilder

actual class RawgSDK actual constructor(databaseDriverFactory: DatabaseDriverFactory) {
    internal actual val database = Database(databaseDriverFactory)
    internal actual val api = RawgApi()

    @Throws(Exception::class)
    actual suspend fun getLaunches(forceReload: Boolean): List<Game> {
//        StoreBuilder
//            .from<Pair<String, String>, GameListResponse, GameListResponse>(
//                Fetcher.of { (query, config) ->
//                    api.getGames()
//                },
//                sourceOfTruth = SourceOfTruth.of(
//                    reader = { (query, _) -> database.getAllGames() },
//                    writer = { (query, _), posts -> db.postDao().insertPosts(query, posts) },
//                    delete = { (query, _) -> db.postDao().clearFeedBySubredditName(query) },
//                    deleteAll = db.postDao()::clearAllFeeds
//                )
//            )
//            .build()
        val cachedLaunches = database.getAllGames()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getGames().also {
                database.clearAllGames()
                println("$TAG : API Response, $it")
                database.cacheGames(it)
            }
            val dbResponse = database.getAllGames()
            println("$TAG : DB Response, $dbResponse")
            return dbResponse
        }
    }

    companion object {
        val TAG = RawgSDK::class.simpleName
    }
}