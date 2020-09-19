package com.chathil.rawgapiwrapper.rawgSdk

import com.chathil.rawgapiwrapper.rawgSdk.cache.Database
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import com.chathil.rawgapiwrapper.rawgSdk.models.Game
import com.chathil.rawgapiwrapper.rawgSdk.network.GameListRequestConfig
import com.chathil.rawgapiwrapper.rawgSdk.network.RawgApi

expect class RawgSDK (databaseDriverFactory: DatabaseDriverFactory) {
    internal val database: Database
    internal val api: RawgApi
    @Throws(Exception::class) suspend fun getGames(forceReload: Boolean, config: GameListRequestConfig): List<Game>
}