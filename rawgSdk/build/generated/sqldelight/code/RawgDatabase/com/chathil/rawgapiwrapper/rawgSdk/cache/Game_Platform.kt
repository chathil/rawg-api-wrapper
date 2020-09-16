package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Game_Platform(
  val gameId: Int,
  val platformId: Int,
  val releasedAt: String?,
  val minimumRequirement: String?,
  val recommendedRequirement: String?
) {
  override fun toString(): String = """
  |Game_Platform [
  |  gameId: $gameId
  |  platformId: $platformId
  |  releasedAt: $releasedAt
  |  minimumRequirement: $minimumRequirement
  |  recommendedRequirement: $recommendedRequirement
  |]
  """.trimMargin()
}
