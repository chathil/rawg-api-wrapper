package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Game_Store(
  val gameId: Int,
  val storeId: Int,
  val url: String?
) {
  override fun toString(): String = """
  |Game_Store [
  |  gameId: $gameId
  |  storeId: $storeId
  |  url: $url
  |]
  """.trimMargin()
}
