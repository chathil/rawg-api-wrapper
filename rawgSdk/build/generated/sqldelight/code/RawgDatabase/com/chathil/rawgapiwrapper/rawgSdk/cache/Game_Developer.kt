package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Game_Developer(
  val gameId: Int,
  val developerId: Int
) {
  override fun toString(): String = """
  |Game_Developer [
  |  gameId: $gameId
  |  developerId: $developerId
  |]
  """.trimMargin()
}
