package com.chathil.rawgapiwrapper.rawgSdk.cache

import com.chathil.rawgapiwrapper.rawgSdk.models.*
import com.chathil.rawgapiwrapper.rawgSdk.models.Game
import com.chathil.rawgapiwrapper.rawgSdk.models.Platform
import com.chathil.rawgapiwrapper.rawgSdk.network.GameListResponse
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.chathil.rawgapiwrapper.rawgSdk.models.Rating as RatingModel

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = RawgDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.rawgDatabaseQueries

    internal fun getAllGames() =
        dbQuery.loadGames(::asDomainModel).asFlow().mapToList()

    internal fun searchGames(keyword: String) =
        dbQuery.searchGames("%$keyword%", ::asDomainModel).asFlow().mapToList()

    internal fun gamesByPublisher(publisherId: Int) =
        dbQuery.gamesByPublisher(publisherId, ::asDomainModel).asFlow().mapToList()

    internal fun gamesByPlatform(platformIds: Set<Int>) =
        dbQuery.gamesByPlatforms(platformIds, ::asDomainModel).asFlow().mapToList()

    internal fun gamesByParentPlatforms(parentPlatformIds: Set<Int>) =
        dbQuery.gamesByParentPlatforms(parentPlatformIds, ::asDomainModel).asFlow().mapToList()

    internal fun gamesByDevelopers(developerIds: Set<Int>) =
        dbQuery.gamesByDevelopers(developerIds, ::asDomainModel).asFlow().mapToList()

    internal fun gamesByGenres(genreIds: Set<Int>) =
        dbQuery.gamesByGenres(genreIds, ::asDomainModel).asFlow().mapToList()

    internal fun gamesByTags(tagIds: Set<Int>) =
        dbQuery.gamesByTags(tagIds, ::asDomainModel).asFlow().mapToList()

    private fun gameRatings(forGame: Int) = dbQuery.loadRatingsForGame(forGame) { id: Int,
                                                                                  gameId: Int,
                                                                                  title: String,
                                                                                  count: Int,
                                                                                  percent: Float ->
        RatingModel(id, gameId, title, count, percent)
    }.executeAsList()

    private fun gamePlatforms(forGame: Int) = dbQuery.loadPlatformsForGame(forGame) { gameId: Int,
                                                                                      platformId: Int,
                                                                                      releasedAt: String?,
                                                                                      minimumRequirement: String?,
                                                                                      recommendedRequirement: String?,
                                                                                      _: Int,
                                                                                      _: String?,
                                                                                      _: String?,
                                                                                      name: String,
                                                                                      slug: String?,
                                                                                      gamesCount: Int,
                                                                                      imageBackground: String?,
                                                                                      image: String?,
                                                                                      yearStart: Int?,
                                                                                      yearEnd: Int?,
                                                                                      _: Boolean ->
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

    private fun gameParentPlatforms(forGame: Int) =
        dbQuery.loadParentPlatformsForGame(forGame) { gameId: Int,
                                                      platformId: Int,
                                                      _: Int,
                                                      _: String?,
                                                      _: String?,
                                                      name: String,
                                                      slug: String?,
                                                      _: Int,
                                                      _: String?,
                                                      _: String?,
                                                      _: Int?,
                                                      _: Int?,
                                                      _: Boolean ->
            ParentPlatform(gameId, platformId, name, slug)
        }.executeAsList()

    private fun gameGenres(forGame: Int) = dbQuery.loadGenreForGame(forGame) { gameId: Int,
                                                                               genreId: Int,
                                                                               _: Int,
                                                                               name: String,
                                                                               slug: String?,
                                                                               gamesCount: Int,
                                                                               imageBackground: String? ->
        Genre(gameId, genreId, name, slug, gamesCount, imageBackground)
    }.executeAsList()

    private fun gameStores(forGame: Int) = dbQuery.loadStoresForGame(forGame) { gameId: Int,
                                                                                _: Int,
                                                                                url: String?,
                                                                                id: Int,
                                                                                name: String,
                                                                                slug: String?,
                                                                                domain: String?,
                                                                                gamesCount: Int,
                                                                                imageBackground: String?,
                                                                                _: Boolean ->
        GameStore(gameId, id, Store(id, name, slug, domain, gamesCount, imageBackground), url)

    }.executeAsList()

    private fun gameTags(forGame: Int) = dbQuery.loadTagsForGame(forGame) { gameId: Int,
                                                                            _: Int,
                                                                            id: Int,
                                                                            _: String?,
                                                                            _: String?,
                                                                            name: String,
                                                                            slug: String?,
                                                                            gamesCount: Int,
                                                                            language: String?,
                                                                            imageBackground: String? ->
        Tag(gameId, id, name, slug, language, gamesCount, imageBackground)

    }.executeAsList()

    private fun gameShortScreenshots(forGame: Int) =
        dbQuery.loadScreenshotsForGame(forGame) { id: Int,
                                                  gameId: Int,
                                                  url: String? ->
            ShortScreenshot(gameId, id, url)
        }.executeAsList()


    internal fun cacheGames(gameListResponse: GameListResponse, publisherId: Int? = null) {
        dbQuery.clearAllGames()
        dbQuery.transaction {
            gameListResponse.results.forEach { game ->
                dbQuery.insertGame(
                    id = game.id,
                    nextPage = gameListResponse.next,
                    prevPage = gameListResponse.prev,
                    name = game.name,
                    slug = game.slug,
                    released = game.released,
                    tba = game.tba,
                    backgroundImage = game.backgroundImage,
                    rating = game.rating,
                    ratingTop = game.ratingTop,
                    ratingsCount = game.ratingsCount,
                    reviewTextCount = game.reviewsCount,
                    added = game.added,
                    metacritic = game.metacritic ?: 0,
                    playtime = game.playtime,
                    suggestionCount = game.suggestionsCount,
                    reviewsCount = game.reviewsCount,
                    saturatedColor = game.saturatedColor,
                    dominantColor = game.dominantColor,
                    clip = game.clip?.clip
                )
                game.ratings?.forEach { rating ->
                    dbQuery.insertRating(
                        game.id,
                        rating.title,
                        rating.count,
                        rating.percent
                    )
                }
                game.platforms?.forEach { gamePlatform ->
                    val platform = gamePlatform.platform
                    platform?.let { _ ->
                        dbQuery.insertPlatform(
                            id = platform.id,
                            nextPage = null,
                            prevPage = null,
                            name = platform.name,
                            slug = platform.slug,
                            gamesCount = platform.gamesCount ?: 0,
                            imageBackground = platform.imageBackground,
                            image = platform.image,
                            yearStart = platform.yearStart,
                            yearEnd = platform.yearEnd,
                            following = false
                        )
                        dbQuery.insertGamePlatform(
                            game.id,
                            platform.id,
                            gamePlatform.releasedAt,
                            gamePlatform.requirementsEn?.minimum,
                            gamePlatform.requirementsEn?.minimum
                        )
                    }
                }
                game.parentPlatforms?.forEach { pl ->
                    dbQuery.insertGameParentPlatform(game.id, pl.platform.id)
                }
                game.genres?.forEach { genre ->
                    dbQuery.insertGenre(
                        genre.id,
                        genre.name,
                        genre.slug,
                        genre.gamesCount ?: 0,
                        genre.imageBackground
                    )
                    dbQuery.insertGameGenre(game.id, genre.id)
                }
                game.stores?.forEach { store ->
                    dbQuery.insertStore(
                        store.store.id,
                        store.store.name,
                        store.store.slug,
                        store.store.domain,
                        store.store.gamesCount ?: 0,
                        store.store.imageBackground,
                        false
                    )
                    dbQuery.insertGameStore(game.id, store.store.id, store.urlEn)
                }
                game.tags?.forEach { tag ->
                    dbQuery.insertTag(
                        tag.id,
                        null,
                        null,
                        tag.name,
                        tag.slug,
                        tag.gamesCount ?: 0,
                        tag.language,
                        tag.imageBackground
                    )
                    dbQuery.insertGameTag(game.id, tag.id)
                }
                game.shortScreenshots?.forEach { screenshot ->
                    dbQuery.insertGameScreenshots(screenshot.id, game.id, screenshot.image)
                }
                publisherId?.let {
                    dbQuery.insertGamePublisher(game.id, it)
                }
            }
        }
    }

    private fun asDomainModel(
        id: Int,
        nextPage: String?,
        prevPage: String?,
        name: String,
        slug: String?,
        released: String?,
        tba: Boolean,
        backgroundImage: String?,
        rating: Float,
        ratingTop: Float,
        ratingsCount: Int,
        reviewTextCount: Int,
        added: Int,
        metacritic: Int,
        playtime: Int,
        suggestionCount: Int,
        reviewsCount: Int,
        saturatedColor: String?,
        dominantColor: String?,
        clip: String?
    ) =
        Game(
            id = id,
            next = nextPage,
            prev = prevPage,
            slug = slug,
            name = name,
            released = released,
            tba = tba,
            backgroundImage = backgroundImage,
            rating = rating,
            ratingTop = ratingTop,
            ratingsCount = ratingsCount,
            ratings = { gameRatings(id) },
            reviewsTextCount = reviewTextCount,
            added = added,
            metacritic = metacritic,
            playtime = playtime,
            suggestionsCount = suggestionCount,
            reviewsCount = reviewsCount,
            saturatedColor = saturatedColor,
            dominantColor = dominantColor,
            platforms = { gamePlatforms(id) },
            parentPlatform = { gameParentPlatforms(id) },
            genres = { gameGenres(id) },
            stores = { gameStores(id) },
            clip = clip,
            tags = { gameTags(id) },
            shortScreenshots = { gameShortScreenshots(id) }
        )

}