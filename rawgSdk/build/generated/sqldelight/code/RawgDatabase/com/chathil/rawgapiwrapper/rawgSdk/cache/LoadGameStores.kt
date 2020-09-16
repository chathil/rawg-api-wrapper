package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Boolean
import kotlin.Int
import kotlin.String

data class LoadGameStores(
  val gameId: Int,
  val storeId: Int,
  val url: String?,
  val id: Int,
  val name: String,
  val slug: String?,
  val domain: String?,
  val gamesCount: Int,
  val imageBackground: String?,
  val following: Boolean
) {
  override fun toString(): String = """
  |LoadGameStores [
  |  gameId: $gameId
  |  storeId: $storeId
  |  url: $url
  |  id: $id
  |  name: $name
  |  slug: $slug
  |  domain: $domain
  |  gamesCount: $gamesCount
  |  imageBackground: $imageBackground
  |  following: $following
  |]
  """.trimMargin()
}
