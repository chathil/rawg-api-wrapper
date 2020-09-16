package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Job(
  val id: Int,
  val name: String,
  val slug: String?
) {
  override fun toString(): String = """
  |Job [
  |  id: $id
  |  name: $name
  |  slug: $slug
  |]
  """.trimMargin()
}
