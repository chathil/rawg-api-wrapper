package com.chathil.rawgapiwrapper.rawgSdk.cache

import com.chathil.rawgapiwrapper.rawgSdk.models.*
import com.chathil.rawgapiwrapper.rawgSdk.models.Game
import com.chathil.rawgapiwrapper.rawgSdk.models.Genre
import com.chathil.rawgapiwrapper.rawgSdk.models.Platform
import com.chathil.rawgapiwrapper.rawgSdk.models.Rating
import com.chathil.rawgapiwrapper.rawgSdk.models.Store
import com.chathil.rawgapiwrapper.rawgSdk.models.Tag
import com.chathil.rawgapiwrapper.rawgSdk.network.GameListResponse

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = RawgDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.rawgDatabaseQueries

    internal fun getAllGames(): List<Game> {
        val games =
            dbQuery.loadGames(::mapAsDomainModel).executeAsList().map { it.id to it }.toMap() // .asFlow

        val gameFlows =
            dbQuery.loadGames(::mapAsDomainModel).executeAsList().map { it.id to it }.toMap() // .asFlow

        dbQuery.loadRatings(games.keys, ::mapAsDomainModel).executeAsList().forEach {
            (games[it.gameId]
                ?: error("No rating found for game with id ${it.gameId}")).ratings += listOf(it)
        }
        dbQuery.loadGamePlatforms(games.keys, ::mapAsDomainModel).executeAsList().forEach {
            (games[it.gameId]
                ?: error("No platform found for game with id ${it.gameId}")).platforms += listOf(it)
        }
        dbQuery.loadGameParentPlatforms(games.keys, ::mapAsDomainModel).executeAsList().forEach {
            (games[it.gameId]
                ?: error("No platform found for game with id ${it.gameId}")).parentPlatforms += listOf(
                it
            )
        }
        dbQuery.loadGameGenres(games.keys, ::mapAsDomainModel).executeAsList().forEach {
            (games[it.gameId]
                ?: error("No genre found for game with id ${it.gameId}")).genres += listOf(it)
        }
        dbQuery.loadGameStores(games.keys, ::mapAsDomainModel).executeAsList().forEach {
            (games[it.gameId]
                ?: error("No store found for game with id ${it.gameId}")).stores
        }
        dbQuery.loadGameTags(games.keys, ::mapAsDomainModel).executeAsList().forEach {
            (games[it.gameId]
                ?: error("No tag found for game with id ${it.gameId}")).tags += listOf(it)
        }
        dbQuery.loadGameScreenshots(games.keys, ::mapAsDomainModel).executeAsList().forEach {
            (games[it.gameId]
                ?: error("No screenshot found for game with id ${it.gameId}")).shortScreenshots += listOf(
                it
            )
        }
        return games.values.toList()
    }

    internal fun cacheGames(gameListResponse: GameListResponse) {
        dbQuery.transaction {
            gameListResponse.results.forEach {
                dbQuery.insertGame(
                    id = it.id,
                    nextPage = gameListResponse.next,
                    prevPage = gameListResponse.prev,
                    name = it.name,
                    slug = it.slug,
                    released = it.released,
                    tba = it.tba,
                    backgroundImage = it.backgroundImage,
                    rating = it.rating,
                    ratingTop = it.ratingTop,
                    ratingsCount = it.ratingsCount,
                    reviewTextCount = it.reviewsCount,
                    added = it.added,
                    metacritic = it.metacritic,
                    playtime = it.playtime,
                    suggestionCount = it.suggestionsCount,
                    reviewsCount = it.reviewsCount,
                    saturatedColor = it.saturatedColor,
                    dominantColor = it.dominantColor,
                    clip = it.clip.clip
                )
                it.ratings.forEach { rating ->
                    dbQuery.insertRating(
                        it.id,
                        rating.title,
                        rating.count,
                        rating.percent
                    )
                }
                it.platforms.forEach { gamePlatform ->
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
                            it.id,
                            platform.id,
                            gamePlatform.releasedAt,
                            gamePlatform.requirementsEn?.minimum,
                            gamePlatform.requirementsEn?.minimum
                        )
                    }
                }
                it.parentPlatforms.forEach { pl ->
                    dbQuery.insertGameParentPlatform(it.id, pl.platform.id)
                }
                it.genres.forEach { genre ->
                    dbQuery.insertGenre(
                        genre.id,
                        genre.name,
                        genre.slug,
                        genre.gamesCount ?: 0,
                        genre.imageBackground
                    )
                    dbQuery.insertGameGenre(it.id, genre.id)
                }
                it.stores.forEach { store ->
                    dbQuery.insertStore(
                        store.store.id,
                        store.store.name,
                        store.store.slug,
                        store.store.domain,
                        store.store.gamesCount ?: 0,
                        store.store.imageBackground,
                        false
                    )
                    dbQuery.insertGameStore(it.id, store.store.id, store.urlEn)
                }
                it.tags.forEach { tag ->
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
                    dbQuery.insertGameTag(it.id, tag.id)
                }
                it.shortScreenshots.forEach { screenshot ->
                    dbQuery.insertGameScreenshots(screenshot.id, it.id, screenshot.image)
                }
            }
        }
    }

    internal fun clearAllGames() {
        dbQuery.clearAllGames()
    }

    internal fun clearGame(id: Int) {
        dbQuery.clearGame(id)
    }

    private fun mapAsDomainModel(
        id: Int,
        gameId: Int,
        title: String,
        count: Int,
        percent: Float
    ) = Rating(id, gameId, title, count, percent)

    private fun mapAsDomainModel(
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
    ) = Game(
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
        ratings = emptyList(),
        ratingsCount = ratingsCount,
        reviewsTextCount = reviewTextCount,
        added = added,
        metacritic = metacritic,
        playtime = playtime,
        suggestionsCount = suggestionCount,
        reviewsCount = reviewsCount,
        saturatedColor = saturatedColor,
        dominantColor = dominantColor,
        platforms = emptyList(),
        parentPlatforms = emptyList(),
        genres = emptyList(),
        stores = emptyList(),
        clip = clip,
        tags = emptyList(),
        shortScreenshots = emptyList()
    )

    private fun mapAsDomainModel(
        gameId: Int,
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
        following: Boolean
    ) = GamePlatform(
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

    private fun mapAsDomainModel(
        gameId: Int,
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
        following: Boolean
    ) = ParentPlatform(gameId, platformId, name, slug)

    private fun mapAsDomainModel(
        gameId: Int,
        genreId: Int,
        id: Int,
        name: String,
        slug: String?,
        gamesCount: Int,
        imageBackground: String?
    ) = Genre(gameId, genreId, name, slug, gamesCount, imageBackground)

    private fun mapAsDomainModel(
        gameId: Int,
        storeId: Int,
        url: String?,
        id: Int,
        name: String,
        slug: String?,
        domain: String?,
        gamesCount: Int,
        imageBackground: String?,
        following: Boolean
    ) = GameStore(gameId, id, Store(id, name, slug, domain, gamesCount, imageBackground), url)

    private fun mapAsDomainModel(
        gameId: Int,
        tagId: Int,
        id: Int,
        nextPage: String?,
        prevPage: String?,
        name: String,
        slug: String?,
        gamesCount: Int,
        language: String?,
        imageBackground: String?
    ) = Tag(gameId, id, name, slug, language, gamesCount, imageBackground)

    private fun mapAsDomainModel(
        id: Int,
        gameId: Int,
        url: String?
    ) = ShortScreenshot(gameId, id, url)

}