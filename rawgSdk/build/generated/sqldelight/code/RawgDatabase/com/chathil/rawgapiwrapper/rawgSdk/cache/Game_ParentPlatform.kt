package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Game_ParentPlatform(
  val gameId: Int,
  val platformId: Int
) {
  override fun toString(): String = """
  |Game_ParentPlatform [
  |  gameId: $gameId
  |  platformId: $platformId
  |]
  """.trimMargin()
}
