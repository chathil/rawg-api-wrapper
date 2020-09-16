package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Game_Genre(
  val gameId: Int,
  val genreId: Int
) {
  override fun toString(): String = """
  |Game_Genre [
  |  gameId: $gameId
  |  genreId: $genreId
  |]
  """.trimMargin()
}
