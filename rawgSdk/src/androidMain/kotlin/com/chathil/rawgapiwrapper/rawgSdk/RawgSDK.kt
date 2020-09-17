package com.chathil.rawgapiwrapper.rawgSdk

import android.app.Application
import android.content.Context
import com.chathil.rawgapiwrapper.rawgSdk.cache.Database
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import com.chathil.rawgapiwrapper.rawgSdk.models.Game
import com.chathil.rawgapiwrapper.rawgSdk.network.GameListResponse
import com.chathil.rawgapiwrapper.rawgSdk.network.RawgApi
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

    @ExperimentalCoroutinesApi
    @FlowPreview
    @Throws(Exception::class)
    actual suspend fun getLaunches(forceReload: Boolean): List<Game> {
        return StoreBuilder
            .from<Pair<String, String>, GameListResponse, List<Game>>(
                Fetcher.of { (query, config) ->
                    api.getGames()
                },
                sourceOfTruth = SourceOfTruth.of(
                    reader = { (query, _) -> database.getAllGames() },
                    writer = { (query, _), posts -> database.cacheGames(posts) },
                    delete = { (query, _) -> database.clearGame(0) },
                    deleteAll = { database.clearAllGames() }
                )
            )
            .build().get("" to "")

    }

    companion object {
        val TAG = RawgSDK::class.simpleName
    }
}