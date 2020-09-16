package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class GameDetail(
  val id: Int,
  val backgroundImageAddtional: String?,
  val description: String?,
  val rawDescription: String?,
  val screenshotsCount: Int,
  val moviesCount: Int,
  val creatorsCount: Int,
  val achievementsCount: Int,
  val parentAchievementsCount: Int,
  val redditUrl: String?,
  val redditName: String?,
  val redditDescription: String?,
  val redditLogo: String?,
  val redditCount: Int,
  val twitchCount: Int,
  val youtubeCount: Int,
  val additionsCount: Int,
  val seriesCount: Int
) {
  override fun toString(): String = """
  |GameDetail [
  |  id: $id
  |  backgroundImageAddtional: $backgroundImageAddtional
  |  description: $description
  |  rawDescription: $rawDescription
  |  screenshotsCount: $screenshotsCount
  |  moviesCount: $moviesCount
  |  creatorsCount: $creatorsCount
  |  achievementsCount: $achievementsCount
  |  parentAchievementsCount: $parentAchievementsCount
  |  redditUrl: $redditUrl
  |  redditName: $redditName
  |  redditDescription: $redditDescription
  |  redditLogo: $redditLogo
  |  redditCount: $redditCount
  |  twitchCount: $twitchCount
  |  youtubeCount: $youtubeCount
  |  additionsCount: $additionsCount
  |  seriesCount: $seriesCount
  |]
  """.trimMargin()
}
