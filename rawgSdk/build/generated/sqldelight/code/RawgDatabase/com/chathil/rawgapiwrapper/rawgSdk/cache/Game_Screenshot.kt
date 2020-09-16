package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Game_Screenshot(
  val id: Int,
  val gameId: Int,
  val url: String?
) {
  override fun toString(): String = """
  |Game_Screenshot [
  |  id: $id
  |  gameId: $gameId
  |  url: $url
  |]
  """.trimMargin()
}
