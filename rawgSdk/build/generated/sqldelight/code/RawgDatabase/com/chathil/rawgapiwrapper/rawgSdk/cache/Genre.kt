package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Genre(
  val id: Int,
  val name: String,
  val slug: String?,
  val gamesCount: Int,
  val imageBackground: String?
) {
  override fun toString(): String = """
  |Genre [
  |  id: $id
  |  name: $name
  |  slug: $slug
  |  gamesCount: $gamesCount
  |  imageBackground: $imageBackground
  |]
  """.trimMargin()
}
