package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Float
import kotlin.Int
import kotlin.String

data class Rating(
  val id: Int,
  val gameId: Int,
  val title: String,
  val count: Int,
  val percent: Float
) {
  override fun toString(): String = """
  |Rating [
  |  id: $id
  |  gameId: $gameId
  |  title: $title
  |  count: $count
  |  percent: $percent
  |]
  """.trimMargin()
}
