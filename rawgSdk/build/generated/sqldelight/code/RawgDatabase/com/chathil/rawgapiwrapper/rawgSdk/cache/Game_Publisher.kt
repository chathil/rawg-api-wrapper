package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Game_Publisher(
  val gameId: Int,
  val publisherId: Int
) {
  override fun toString(): String = """
  |Game_Publisher [
  |  gameId: $gameId
  |  publisherId: $publisherId
  |]
  """.trimMargin()
}
