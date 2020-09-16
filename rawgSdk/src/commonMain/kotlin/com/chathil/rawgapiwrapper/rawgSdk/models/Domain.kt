package com.chathil.rawgapiwrapper.rawgSdk.models

data class Game(
    val id: Int,
    val next: String?,
    val prev: String?,
    val slug: String?,
    val name: String,
    val released: String?,
    val tba: Boolean,
    val backgroundImage: String?,
    val rating: Float,
    val ratingTop: Float,
    var ratings: List<Rating>,
    val ratingsCount: Int,
    val reviewsTextCount: Int,
    val added: Int,
    val metacritic: Int,
    val playtime: Int,
    val suggestionsCount: Int,
    val reviewsCount: Int,
    val saturatedColor: String?,
    val dominantColor: String?,
    var platforms: List<GamePlatform>,
    var parentPlatforms: List<ParentPlatform>,
    var genres: List<Genre>,
    var stores: List<GameStore>,
    val clip: String?,
    var tags: List<Tag>,
    var shortScreenshots: List<ShortScreenshot>
)

data class Rating(
    val id: Int,
    val gameId: Int,
    val title: String,
    val count: Int,
    val percent: Float
)

data class Platform(
    val id: Int,
    val name: String,
    val slug: String?,
    val image: String?,
    val yearEnd: Int?,
    val yearStart: Int?,
    val gamesCount: Int? = 0,
    val imageBackground: String?,
)

data class Requirement(
    val minimum: String?,
    val recommended: String?
)

data class GamePlatform(
    val gameId: Int,
    val platform: Platform,
    val releasedAt: String?,
    val requirementsEn: Requirement?
)

data class ParentPlatform(
    val gameId: Int,
    val id: Int,
    val name: String,
    val slug: String?
)

data class Genre(
    val gameId: Int,
    val id: Int,
    val name: String,
    val slug: String?,
    val gamesCount: Int? = 0,
    val imageBackground: String?
)

data class Store(
    val id: Int,
    val name: String,
    val slug: String?,
    val domain: String?,
    val gamesCount: Int? = 0,
    val imageBackground: String?
)

data class GameStore(
    val gameId: Int,
    val id: Int,
    val store: Store,
    val urlEn: String?
)

data class Tag(
    val gameId: Int,
    val id: Int,
    val name: String,
    val slug: String?,
    val language: String?,
    val gamesCount: Int? = 0,
    val imageBackground: String?
)

data class ShortScreenshot(
    val gameId: Int,
    val id: Int,
    val image: String?
)