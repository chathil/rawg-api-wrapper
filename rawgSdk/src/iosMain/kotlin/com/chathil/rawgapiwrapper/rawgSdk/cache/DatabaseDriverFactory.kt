package com.chathil.rawgapiwrapper.rawgSdk.cache

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(RawgDatabase.Schema, "rawg.db")
    }
}