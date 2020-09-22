package com.chathil.rawgapiwrapper.rawgSdk.cache

import com.chathil.rawgapiwrapper.rawgSdk.models.Game
import com.chathil.rawgapiwrapper.rawgSdk.network.GameRequestConfig
import com.chathil.rawgapiwrapper.rawgSdk.network.GameListResponse
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = RawgDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.rawgDatabaseQueries

    internal fun getAllGames(): Flow<List<Game>> {
        return dbQuery.loadGames(::asDomainModel).asFlow().mapToList()
    }

    internal fun searchGames(keyword: String): Flow<List<Game>> {
        return dbQuery.searchGames("%$keyword%", ::asDomainModel).asFlow().mapToList()
    }

    internal fun gamesByPublisher(publisherId: Int): Flow<List<Game>> {
        return dbQuery.gamesByPublisher(publisherId, ::asDomainModel).asFlow().mapToList()
    }

    internal fun gamesByPlatform(platformIds: Set<Int>): Flow<List<Game>> {
        return dbQuery.gamesByPlatforms(platformIds, ::asDomainModel).asFlow().mapToList()
    }

    internal fun gamesByParentPlatforms(parentPlatformIds: Set<Int>): Flow<List<Game>> {
        return dbQuery.gamesByParentPlatforms(parentPlatformIds, ::asDomainModel).asFlow().mapToList()
    }

    internal fun gamesByDevelopers(developerIds: Set<Int>): Flow<List<Game>> {
        return dbQuery.gamesByDevelopers(developerIds, ::asDomainModel).asFlow().mapToList()
    }

    internal fun gamesByGenres(genreIds: Set<Int>): Flow<List<Game>> {
        return dbQuery.gamesByGenres(genreIds, ::asDomainModel).asFlow().mapToList()
    }
    internal fun gamesByTags(tagIds: Set<Int>) = dbQuery.gamesByTags(tagIds, ::asDomainModel).asFlow().mapToList()

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

    internal fun clearGame(id: Int) {
        dbQuery.clearGame(id)
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
            reviewsTextCount = reviewTextCount,
            added = added,
            metacritic = metacritic,
            playtime = playtime,
            suggestionsCount = suggestionCount,
            reviewsCount = reviewsCount,
            saturatedColor = saturatedColor,
            dominantColor = dominantColor,
            clip = clip,
            dbQuery = dbQuery
        )

}