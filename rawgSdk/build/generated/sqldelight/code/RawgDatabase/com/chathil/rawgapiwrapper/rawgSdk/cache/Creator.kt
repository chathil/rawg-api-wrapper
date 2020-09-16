package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.Long
import kotlin.String

data class Creator(
  val id: Int,
  val nextPage: String?,
  val prevPage: String?,
  val name: String,
  val slug: String?,
  val image: String?,
  val imageBackground: String?,
  val gamesCount: Long
) {
  override fun toString(): String = """
  |Creator [
  |  id: $id
  |  nextPage: $nextPage
  |  prevPage: $prevPage
  |  name: $name
  |  slug: $slug
  |  image: $image
  |  imageBackground: $imageBackground
  |  gamesCount: $gamesCount
  |]
  """.trimMargin()
}
