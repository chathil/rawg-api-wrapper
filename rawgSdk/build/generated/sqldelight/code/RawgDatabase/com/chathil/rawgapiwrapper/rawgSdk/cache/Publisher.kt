package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Publisher(
  val id: Int,
  val nextPage: String?,
  val prevPage: String?,
  val name: String,
  val slug: String?,
  val gamesCount: Int,
  val imageBackground: String?
) {
  override fun toString(): String = """
  |Publisher [
  |  id: $id
  |  nextPage: $nextPage
  |  prevPage: $prevPage
  |  name: $name
  |  slug: $slug
  |  gamesCount: $gamesCount
  |  imageBackground: $imageBackground
  |]
  """.trimMargin()
}
