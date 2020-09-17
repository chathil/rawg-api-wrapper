package com.chathil.rawgapiwrapper.rawgSdk.models

import com.chathil.rawgapiwrapper.rawgSdk.cache.RawgDatabaseQueries
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow

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
    val ratingsCount: Int,
    val reviewsTextCount: Int,
    val added: Int,
    val metacritic: Int,
    val playtime: Int,
    val suggestionsCount: Int,
    val reviewsCount: Int,
    val saturatedColor: String?,
    val dominantColor: String?,
    val clip: String?,
    val dbQuery: RawgDatabaseQueries
) {
    fun ratings() =
        dbQuery.loadRatingsForGame(id) { id: Int,
                                         gameId: Int,
                                         title: String,
                                         count: Int,
                                         percent: Float ->
            Rating(id, gameId, title, count, percent)
        }.executeAsList()


    fun platforms() =
        dbQuery.loadPlatformsForGame(id) { gameId: Int,
                                           platformId: Int,
                                           releasedAt: String?,
                                           minimumRequirement: String?,
                                           recommendedRequirement: String?,
                                           id: Int,
                                           nextPage: String?,
                                           prevPage: String?,
                                           name: String,
                                           slug: String?,
                                           gamesCount: Int,
                                           imageBackground: String?,
                                           image: String?,
                                           yearStart: Int?,
                                           yearEnd: Int?,
                                           following: Boolean ->
            GamePlatform(
                gameId,
                Platform(
                    platformId,
                    name,
                    slug,
                    image,
                    yearEnd,
                    yearStart,
                    gamesCount,
                    imageBackground
                ), releasedAt, Requirement(minimumRequirement, recommendedRequirement)
            )
        }.executeAsList()


    fun parentPlatforms() =
        dbQuery.loadParentPlatformsForGames(id) { gameId: Int,
                                                  platformId: Int,
                                                  id: Int,
                                                  nextPage: String?,
                                                  prevPage: String?,
                                                  name: String,
                                                  slug: String?,
                                                  gamesCount: Int,
                                                  imageBackground: String?,
                                                  image: String?,
                                                  yearStart: Int?,
                                                  yearEnd: Int?,
                                                  following: Boolean ->
            ParentPlatform(gameId, platformId, name, slug)
        }.executeAsList()


    fun genres() =
        dbQuery.loadGenreForGames(id) { gameId: Int,
                                        genreId: Int,
                                        id: Int,
                                        name: String,
                                        slug: String?,
                                        gamesCount: Int,
                                        imageBackground: String? ->
            Genre(gameId, genreId, name, slug, gamesCount, imageBackground)
        }.executeAsList()


    fun stores() =
        dbQuery.loadStoresForGame(id) { gameId: Int,
                                        storeId: Int,
                                        url: String?,
                                        id: Int,
                                        name: String,
                                        slug: String?,
                                        domain: String?,
                                        gamesCount: Int,
                                        imageBackground: String?,
                                        following: Boolean ->
            GameStore(gameId, id, Store(id, name, slug, domain, gamesCount, imageBackground), url)

        }.executeAsList()


    fun tags() =
        dbQuery.loadTagsForGame(id) { gameId: Int,
                                      tagId: Int,
                                      id: Int,
                                      nextPage: String?,
                                      prevPage: String?,
                                      name: String,
                                      slug: String?,
                                      gamesCount: Int,
                                      language: String?,
                                      imageBackground: String? ->
            Tag(gameId, id, name, slug, language, gamesCount, imageBackground)

        }.executeAsList()


    fun shortScreenshots() =
        dbQuery.loadScreenshotsForGame(id) { id: Int,
                                             gameId: Int,
                                             url: String? ->
            ShortScreenshot(gameId, id, url)
        }.executeAsList()

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