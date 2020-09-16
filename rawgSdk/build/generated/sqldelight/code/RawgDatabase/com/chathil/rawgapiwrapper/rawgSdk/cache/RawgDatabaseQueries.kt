package com.chathil.rawgapiwrapper.rawgSdk.cache

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Collection

interface RawgDatabaseQueries : Transacter {
  fun <T : Any> loadJobs(mapper: (
    id: Int,
    name: String,
    slug: String?
  ) -> T): Query<T>

  fun loadJobs(): Query<Job>

  fun <T : Any> loadJobById(id: Int, mapper: (
    id: Int,
    name: String,
    slug: String?
  ) -> T): Query<T>

  fun loadJobById(id: Int): Query<Job>

  fun <T : Any> loadCreators(mapper: (
    id: Int,
    nextPage: String?,
    prevPage: String?,
    name: String,
    slug: String?,
    image: String?,
    imageBackground: String?,
    gamesCount: Long
  ) -> T): Query<T>

  fun loadCreators(): Query<Creator>

  fun <T : Any> loadRatings(gameId: Collection<Int>, mapper: (
    id: Int,
    gameId: Int,
    title: String,
    count: Int,
    percent: Float
  ) -> T): Query<T>

  fun loadRatings(gameId: Collection<Int>): Query<Rating>

  fun <T : Any> loadPlatforms(mapper: (
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
  ) -> T): Query<T>

  fun loadPlatforms(): Query<Platform>

  fun <T : Any> loadGamePlatforms(gameId: Collection<Int>, mapper: (
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
  ) -> T): Query<T>

  fun loadGamePlatforms(gameId: Collection<Int>): Query<LoadGamePlatforms>

  fun <T : Any> loadGameParentPlatforms(gameId: Collection<Int>, mapper: (
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
  ) -> T): Query<T>

  fun loadGameParentPlatforms(gameId: Collection<Int>): Query<LoadGameParentPlatforms>

  fun <T : Any> loadStores(mapper: (
    id: Int,
    name: String,
    slug: String?,
    domain: String?,
    gamesCount: Int,
    imageBackground: String?,
    following: Boolean
  ) -> T): Query<T>

  fun loadStores(): Query<Store>

  fun <T : Any> loadGameStores(gameId: Collection<Int>, mapper: (
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
  ) -> T): Query<T>

  fun loadGameStores(gameId: Collection<Int>): Query<LoadGameStores>

  fun <T : Any> loadGenres(mapper: (
    id: Int,
    name: String,
    slug: String?,
    gamesCount: Int,
    imageBackground: String?
  ) -> T): Query<T>

  fun loadGenres(): Query<Genre>

  fun <T : Any> loadGameGenres(gameId: Collection<Int>, mapper: (
    gameId: Int,
    genreId: Int,
    id: Int,
    name: String,
    slug: String?,
    gamesCount: Int,
    imageBackground: String?
  ) -> T): Query<T>

  fun loadGameGenres(gameId: Collection<Int>): Query<LoadGameGenres>

  fun <T : Any> loadDevelopers(mapper: (
    id: Int,
    name: String,
    slug: String?,
    gameCount: Int,
    imageBackground: String?,
    description: String?
  ) -> T): Query<T>

  fun loadDevelopers(): Query<Developer>

  fun <T : Any> loadDevelopersByIds(id: Int, mapper: (
    id: Int,
    name: String,
    slug: String?,
    gameCount: Int,
    imageBackground: String?,
    description: String?
  ) -> T): Query<T>

  fun loadDevelopersByIds(id: Int): Query<Developer>

  fun <T : Any> loadTags(mapper: (
    id: Int,
    nextPage: String?,
    prevPage: String?,
    name: String,
    slug: String?,
    gamesCount: Int,
    language: String?,
    imageBackground: String?
  ) -> T): Query<T>

  fun loadTags(): Query<Tag>

  fun <T : Any> loadGameTags(gameId: Collection<Int>, mapper: (
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
  ) -> T): Query<T>

  fun loadGameTags(gameId: Collection<Int>): Query<LoadGameTags>

  fun <T : Any> loadPublishers(mapper: (
    id: Int,
    nextPage: String?,
    prevPage: String?,
    name: String,
    slug: String?,
    gamesCount: Int,
    imageBackground: String?
  ) -> T): Query<T>

  fun loadPublishers(): Query<Publisher>

  fun <T : Any> loadGameScreenshots(gameId: Collection<Int>, mapper: (
    id: Int,
    gameId: Int,
    url: String?
  ) -> T): Query<T>

  fun loadGameScreenshots(gameId: Collection<Int>): Query<Game_Screenshot>

  fun <T : Any> loadGameDetail(id: Int, mapper: (
    id: Int,
    backgroundImageAddtional: String?,
    description: String?,
    rawDescription: String?,
    screenshotsCount: Int,
    moviesCount: Int,
    creatorsCount: Int,
    achievementsCount: Int,
    parentAchievementsCount: Int,
    redditUrl: String?,
    redditName: String?,
    redditDescription: String?,
    redditLogo: String?,
    redditCount: Int,
    twitchCount: Int,
    youtubeCount: Int,
    additionsCount: Int,
    seriesCount: Int
  ) -> T): Query<T>

  fun loadGameDetail(id: Int): Query<GameDetail>

  fun <T : Any> loadGames(mapper: (
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
  ) -> T): Query<T>

  fun loadGames(): Query<Game>

  fun <T : Any> loadGame(id: Int, mapper: (
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
  ) -> T): Query<T>

  fun loadGame(id: Int): Query<Game>

  fun insertJob(
    id: Int?,
    name: String,
    slug: String?
  )

  fun clearAllJobs()

  fun insertCreator(
    id: Int?,
    nextPage: String?,
    prevPage: String?,
    name: String,
    slug: String?,
    image: String?,
    imageBackground: String?,
    gamesCount: Long
  )

  fun clearCreator(id: Int)

  fun clearAllCreators()

  fun insertCreator_CreatorPosition(creatorId: Int, jobId: Int)

  fun clearCreator_CreatorPosition(jobId: Int)

  fun clearCreator_CreatorPositions()

  fun insertRating(
    gameId: Int,
    title: String,
    count: Int,
    percent: Float
  )

  fun clearRating(id: Int)

  fun clearRatings()

  fun insertPlatform(
    id: Int?,
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
  )

  fun clearPlatform(id: Int)

  fun clearPlatforms()

  fun insertGamePlatform(
    gameId: Int,
    platformId: Int,
    releasedAt: String?,
    minimumRequirement: String?,
    recommendedRequirement: String?
  )

  fun clearGamePlatforms()

  fun insertGameParentPlatform(gameId: Int, platformId: Int)

  fun clearGameParentPlatforms()

  fun insertStore(
    id: Int?,
    name: String,
    slug: String?,
    domain: String?,
    gamesCount: Int,
    imageBackground: String?,
    following: Boolean
  )

  fun clearStore(id: Int)

  fun clearStores()

  fun insertGameStore(
    gameId: Int,
    storeId: Int,
    url: String?
  )

  fun clearGameStores()

  fun insertGenre(
    id: Int?,
    name: String,
    slug: String?,
    gamesCount: Int,
    imageBackground: String?
  )

  fun clearGenre(id: Int)

  fun clearAllGenres()

  fun insertGameGenre(gameId: Int, genreId: Int)

  fun clearAllGameGenres()

  fun insertDeveloper(
    id: Int?,
    name: String,
    slug: String?,
    gameCount: Int,
    imageBackground: String?,
    description: String?
  )

  fun clearAllDevelopers()

  fun clearDeveloper(id: Int)

  fun insertGameDeveloper(gameId: Int, developerId: Int)

  fun clearGameDevelopers()

  fun insertTag(
    id: Int?,
    nextPage: String?,
    prevPage: String?,
    name: String,
    slug: String?,
    gamesCount: Int,
    language: String?,
    imageBackground: String?
  )

  fun clearTag(id: Int)

  fun clearTags()

  fun insertGameTag(gameId: Int, tagId: Int)

  fun clearAllGameTags()

  fun insertPublisher(
    id: Int?,
    nextPage: String?,
    prevPage: String?,
    name: String,
    slug: String?,
    gamesCount: Int,
    imageBackground: String?
  )

  fun clearPublisher(id: Int)

  fun clearAllPublishers()

  fun insertGamePublisher(gameId: Int, publisherId: Int)

  fun clearAllGamePublishers()

  fun insertGameScreenshots(
    id: Int?,
    gameId: Int,
    url: String?
  )

  fun clearGameScreenshotsByGameId(gameId: Int)

  fun insertGameDetail(
    id: Int?,
    backgroundImageAddtional: String?,
    description: String?,
    rawDescription: String?,
    screenshotsCount: Int,
    moviesCount: Int,
    creatorsCount: Int,
    achievementsCount: Int,
    parentAchievementsCount: Int,
    redditUrl: String?,
    redditName: String?,
    redditDescription: String?,
    redditLogo: String?,
    redditCount: Int,
    twitchCount: Int,
    youtubeCount: Int,
    additionsCount: Int,
    seriesCount: Int
  )

  fun clearGameDetail(id: Int)

  fun clearGameDetails()

  fun insertGame(
    id: Int?,
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
  )

  fun clearGame(id: Int)

  fun clearAllGames()
}
