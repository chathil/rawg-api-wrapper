package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class LoadGameTags(
  val gameId: Int,
  val tagId: Int,
  val id: Int,
  val nextPage: String?,
  val prevPage: String?,
  val name: String,
  val slug: String?,
  val gamesCount: Int,
  val language: String?,
  val imageBackground: String?
) {
  override fun toString(): String = """
  |LoadGameTags [
  |  gameId: $gameId
  |  tagId: $tagId
  |  id: $id
  |  nextPage: $nextPage
  |  prevPage: $prevPage
  |  name: $name
  |  slug: $slug
  |  gamesCount: $gamesCount
  |  language: $language
  |  imageBackground: $imageBackground
  |]
  """.trimMargin()
}
