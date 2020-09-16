package com.chathil.rawgapiwrapper.rawgSdk

import com.chathil.rawgapiwrapper.rawgSdk.cache.Database
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import com.chathil.rawgapiwrapper.rawgSdk.models.Game
import com.chathil.rawgapiwrapper.rawgSdk.network.RawgApi

actual class RawgSDK actual constructor(databaseDriverFactory: DatabaseDriverFactory) {
    internal actual val database = Database(databaseDriverFactory)
    internal actual val api = RawgApi()

    @Throws(Exception::class) actual suspend fun getLaunches(forceReload: Boolean): List<Game> {
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