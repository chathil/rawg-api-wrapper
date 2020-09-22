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

    internal fun cacheGames(gameListResponse: GameListResponse) {
        dbQuery.clearAllGames()
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
                    metacritic = it.metacritic ?: 0,
                    playtime = it.playtime,
                    suggestionCount = it.suggestionsCount,
                    reviewsCount = it.reviewsCount,
                    saturatedColor = it.saturatedColor,
                    dominantColor = it.dominantColor,
                    clip = it.clip?.clip
                )
                it.ratings?.forEach { rating ->
                    dbQuery.insertRating(
                        it.id,
                        rating.title,
                        rating.count,
                        rating.percent
                    )
                }
                it.platforms?.forEach { gamePlatform ->
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
                it.parentPlatforms?.forEach { pl ->
                    dbQuery.insertGameParentPlatform(it.id, pl.platform.id)
                }
                it.genres?.forEach { genre ->
                    dbQuery.insertGenre(
                        genre.id,
                        genre.name,
                        genre.slug,
                        genre.gamesCount ?: 0,
                        genre.imageBackground
                    )
                    dbQuery.insertGameGenre(it.id, genre.id)
                }
                it.stores?.forEach { store ->
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
                it.tags?.forEach { tag ->
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
                it.shortScreenshots?.forEach { screenshot ->
                    dbQuery.insertGameScreenshots(screenshot.id, it.id, screenshot.image)
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