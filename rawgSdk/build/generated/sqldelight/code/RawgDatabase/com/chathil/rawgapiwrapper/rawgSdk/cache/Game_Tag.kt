package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Game_Tag(
  val gameId: Int,
  val tagId: Int
) {
  override fun toString(): String = """
  |Game_Tag [
  |  gameId: $gameId
  |  tagId: $tagId
  |]
  """.trimMargin()
}
