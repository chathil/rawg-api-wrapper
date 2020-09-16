package com.chathil.rawgapiwrapper.rawgSdk.network

import kotlinx.serialization.SerialInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GameListResponse(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String?,
    @SerialName("previous")
    val prev: String?,
    @SerialName("results")
    val results: List<GameResponse>
)

@Serializable
internal data class GameResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("slug")
    val slug: String?,
    @SerialName("name")
    val name: String,
    @SerialName("released")
    val released: String,
    @SerialName("tba")
    val tba: Boolean,
    @SerialName("background_image")
    val backgroundImage: String?,
    @SerialName("rating")
    val rating: Float,
    @SerialName("rating_top")
    val ratingTop: Float,
    @SerialName("ratings")
    val ratings: List<RatingResponse>,
    @SerialName("ratings_count")
    val ratingsCount: Int,
    @SerialName("reviews_text_count")
    val reviewsTextCount: Int,
    @SerialName("added")
    val added: Int,
    @SerialName("metacritic")
    val metacritic: Int,
    @SerialName("playtime")
    val playtime: Int,
    @SerialName("suggestions_count")
    val suggestionsCount: Int,
    @SerialName("reviews_count")
    val reviewsCount: Int,
    @SerialName("saturated_color")
    val saturatedColor: String,
    @SerialName("dominant_color")
    val dominantColor: String,
    @SerialName("platforms")
    val platforms: List<GamePlatformResponse>,
    @SerialName("parent_platforms")
    val parentPlatforms: List<GameParentPlatformResponse>,
    @SerialName("genres")
    val genres: List<GenreResponse>,
    @SerialName("stores")
    val stores: List<GameStoreResponse>,
    @SerialName("clip")
    val clip: ClipResponse,
    @SerialName("tags")
    val tags: List<TagResponse>,
    @SerialName("short_screenshots")
    val shortScreenshots: List<ShortScreenshotResponse>
)

@Serializable
internal data class RatingResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("count")
    val count: Int,
    @SerialName("percent")
    val percent: Float
)

@Serializable
internal data class PlatformResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String?,
    @SerialName("image")
    val image: String?,
    @SerialName("year_end")
    val yearEnd: Int?,
    @SerialName("year_start")
    val yearStart: Int?,
    @SerialName("games_count")
    val gamesCount: Int? = 0,
    @SerialName("image_background")
    val imageBackground: String?,
)

@Serializable
internal data class RequirementResponse(
    @SerialName("minimum")
    val minimum: String? = null,
    @SerialName("recommended")
    val recommended: String? = null
)

@Serializable
internal data class GamePlatformResponse(
    @SerialName("platform")
    val platform: PlatformResponse?,
    @SerialName("released_at")
    val releasedAt: String,
    @SerialName("requirements_en")
    val requirementsEn: RequirementResponse?
)

@Serializable
internal data class ParentPlatformResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String?
)

@Serializable
internal data class GameParentPlatformResponse(
    @SerialName("platform")
    val platform: ParentPlatformResponse
)

@Serializable
internal data class GenreResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String?,
    @SerialName("games_count")
    val gamesCount: Int? = 0,
    @SerialName("image_background")
    val imageBackground: String?
)

@Serializable
internal data class StoreResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String?,
    @SerialName("domain")
    val domain: String?,
    @SerialName("games_count")
    val gamesCount: Int? = 0,
    @SerialName("image_background")
    val imageBackground: String?
)

@Serializable
internal data class GameStoreResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("store")
    val store: StoreResponse,
    @SerialName("url_en")
    val urlEn: String?
)

@Serializable
internal data class ClipResponse(
    @SerialName("clip")
    val clip: String?
)

@Serializable
internal data class TagResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String?,
    @SerialName("language")
    val language: String?,
    @SerialName("games_count")
    val gamesCount: Int? = 0,
    @SerialName("image_background")
    val imageBackground: String?
)

@Serializable
internal data class ShortScreenshotResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String?
)
