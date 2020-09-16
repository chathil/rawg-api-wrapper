package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String

data class Game(
  val id: Int,
  val nextPage: String?,
  val prevPage: String?,
  val name: String,
  val slug: String?,
  val released: String?,
  val tba: Boolean,
  val backgroundImage: String?,
  val rating: Float,
  val ratingTop: Float,
  val ratingsCount: Int,
  val reviewTextCount: Int,
  val added: Int,
  val metacritic: Int,
  val playtime: Int,
  val suggestionCount: Int,
  val reviewsCount: Int,
  val saturatedColor: String?,
  val dominantColor: String?,
  val clip: String?
) {
  override fun toString(): String = """
  |Game [
  |  id: $id
  |  nextPage: $nextPage
  |  prevPage: $prevPage
  |  name: $name
  |  slug: $slug
  |  released: $released
  |  tba: $tba
  |  backgroundImage: $backgroundImage
  |  rating: $rating
  |  ratingTop: $ratingTop
  |  ratingsCount: $ratingsCount
  |  reviewTextCount: $reviewTextCount
  |  added: $added
  |  metacritic: $metacritic
  |  playtime: $playtime
  |  suggestionCount: $suggestionCount
  |  reviewsCount: $reviewsCount
  |  saturatedColor: $saturatedColor
  |  dominantColor: $dominantColor
  |  clip: $clip
  |]
  """.trimMargin()
}
