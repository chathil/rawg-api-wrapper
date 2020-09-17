package com.chathil.rawgapiwrapper.rawgSdk

import com.chathil.rawgapiwrapper.rawgSdk.cache.Database
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import com.chathil.rawgapiwrapper.rawgSdk.models.Game
import com.chathil.rawgapiwrapper.rawgSdk.network.RawgApi
import com.chathil.rawgapiwrapper.rawgSdk.utils.flattenToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList

actual class RawgSDK actual constructor(databaseDriverFactory: DatabaseDriverFactory) {
    internal actual val database = Database(databaseDriverFactory)
    internal actual val api = RawgApi()

    @Throws(Exception::class) actual suspend fun getLaunches(forceReload: Boolean): List<Game> {
        val cachedLaunches = database.getAllGames().flattenToList()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getGames().also {
                database.clearAllGames()
                database.cacheGames(it)
            }
            val dbResponse = database.getAllGames()
            return dbResponse.flattenToList()
        }
    }
    companion object {
        val TAG = RawgSDK::class.simpleName
    }
}