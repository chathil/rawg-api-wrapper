package com.chathil.rawgapiwrapper.rawgSdk.models

data class Game(
    val index: Int,
    val id: Int,
    val next: Int?,
    val prev: Int?,
    val slug: String?,
    val name: String,
    val released: String?,
    val tba: Boolean,
    val backgroundImage: String?,
    val rating: Float,
    val ratingTop: Float,
    val ratings: () -> List<Rating>,
    val ratingsCount: Int,
    val reviewsTextCount: Int,
    val added: Int,
    val metacritic: Int,
    val playtime: Int,
    val suggestionsCount: Int,
    val reviewsCount: Int,
    val saturatedColor: String?,
    val dominantColor: String?,
    val platforms: () -> List<GamePlatform>,
    val parentPlatform: () -> List<ParentPlatform>,
    val genres: () -> List<Genre>,
    val stores: () -> List<GameStore>,
    val clip: String?,
    val tags: () -> List<Tag>,
    val shortScreenshots: () -> List<ShortScreenshot>
) {
    override fun equals(other: Any?): Boolean {
        return id == (other as Game).id
    }

    override fun hashCode(): Int {
        var result = index
        result = 31 * result + (next ?: 0)
        result = 31 * result + (prev ?: 0)
        result = 31 * result + (slug?.hashCode() ?: 0)
        result = 31 * result + name.hashCode()
        result = 31 * result + (released?.hashCode() ?: 0)
        result = 31 * result + tba.hashCode()
        result = 31 * result + (backgroundImage?.hashCode() ?: 0)
        result = 31 * result + rating.hashCode()
        result = 31 * result + ratingTop.hashCode()
        result = 31 * result + ratings.hashCode()
        result = 31 * result + ratingsCount
        result = 31 * result + reviewsTextCount
        result = 31 * result + added
        result = 31 * result + metacritic
        result = 31 * result + playtime
        result = 31 * result + suggestionsCount
        result = 31 * result + reviewsCount
        result = 31 * result + (saturatedColor?.hashCode() ?: 0)
        result = 31 * result + (dominantColor?.hashCode() ?: 0)
        result = 31 * result + platforms.hashCode()
        result = 31 * result + parentPlatform.hashCode()
        result = 31 * result + genres.hashCode()
        result = 31 * result + stores.hashCode()
        result = 31 * result + (clip?.hashCode() ?: 0)
        result = 31 * result + tags.hashCode()
        result = 31 * result + shortScreenshots.hashCode()
        return result
    }
}

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