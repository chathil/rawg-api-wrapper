package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Boolean
import kotlin.Int
import kotlin.String

data class LoadGameParentPlatforms(
  val gameId: Int,
  val platformId: Int,
  val id: Int,
  val nextPage: String?,
  val prevPage: String?,
  val name: String,
  val slug: String?,
  val gamesCount: Int,
  val imageBackground: String?,
  val image: String?,
  val yearStart: Int?,
  val yearEnd: Int?,
  val following: Boolean
) {
  override fun toString(): String = """
  |LoadGameParentPlatforms [
  |  gameId: $gameId
  |  platformId: $platformId
  |  id: $id
  |  nextPage: $nextPage
  |  prevPage: $prevPage
  |  name: $name
  |  slug: $slug
  |  gamesCount: $gamesCount
  |  imageBackground: $imageBackground
  |  image: $image
  |  yearStart: $yearStart
  |  yearEnd: $yearEnd
  |  following: $following
  |]
  """.trimMargin()
}
