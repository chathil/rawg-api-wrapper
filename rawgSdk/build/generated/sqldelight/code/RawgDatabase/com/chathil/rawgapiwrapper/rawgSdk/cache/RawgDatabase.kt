package com.chathil.rawgapiwrapper.rawgSdk.cache

import com.chathil.rawgapiwrapper.rawgSdk.cache.rawgSdk.newInstance
import com.chathil.rawgapiwrapper.rawgSdk.cache.rawgSdk.schema
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver

interface RawgDatabase : Transacter {
  val rawgDatabaseQueries: RawgDatabaseQueries

  companion object {
    val Schema: SqlDriver.Schema
      get() = RawgDatabase::class.schema

    operator fun invoke(driver: SqlDriver): RawgDatabase = RawgDatabase::class.newInstance(driver)}
}
