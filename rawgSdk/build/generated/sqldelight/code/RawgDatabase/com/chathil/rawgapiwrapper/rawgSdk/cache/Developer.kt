package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Developer(
  val id: Int,
  val name: String,
  val slug: String?,
  val gameCount: Int,
  val imageBackground: String?,
  val description: String?
) {
  override fun toString(): String = """
  |Developer [
  |  id: $id
  |  name: $name
  |  slug: $slug
  |  gameCount: $gameCount
  |  imageBackground: $imageBackground
  |  description: $description
  |]
  """.trimMargin()
}
