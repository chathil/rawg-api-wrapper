package com.chathil.rawgapiwrapper.rawgSdk.cache.rawgSdk

import com.chathil.rawgapiwrapper.rawgSdk.cache.Creator
import com.chathil.rawgapiwrapper.rawgSdk.cache.Developer
import com.chathil.rawgapiwrapper.rawgSdk.cache.Game
import com.chathil.rawgapiwrapper.rawgSdk.cache.GameDetail
import com.chathil.rawgapiwrapper.rawgSdk.cache.Game_Screenshot
import com.chathil.rawgapiwrapper.rawgSdk.cache.Genre
import com.chathil.rawgapiwrapper.rawgSdk.cache.Job
import com.chathil.rawgapiwrapper.rawgSdk.cache.LoadGameGenres
import com.chathil.rawgapiwrapper.rawgSdk.cache.LoadGameParentPlatforms
import com.chathil.rawgapiwrapper.rawgSdk.cache.LoadGamePlatforms
import com.chathil.rawgapiwrapper.rawgSdk.cache.LoadGameStores
import com.chathil.rawgapiwrapper.rawgSdk.cache.LoadGameTags
import com.chathil.rawgapiwrapper.rawgSdk.cache.Platform
import com.chathil.rawgapiwrapper.rawgSdk.cache.Publisher
import com.chathil.rawgapiwrapper.rawgSdk.cache.Rating
import com.chathil.rawgapiwrapper.rawgSdk.cache.RawgDatabase
import com.chathil.rawgapiwrapper.rawgSdk.cache.RawgDatabaseQueries
import com.chathil.rawgapiwrapper.rawgSdk.cache.Store
import com.chathil.rawgapiwrapper.rawgSdk.cache.Tag
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.db.SqlCursor
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.internal.copyOnWriteList
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Collection
import kotlin.collections.MutableList
import kotlin.jvm.JvmField
import kotlin.reflect.KClass

internal val KClass<RawgDatabase>.schema: SqlDriver.Schema
  get() = RawgDatabaseImpl.Schema

internal fun KClass<RawgDatabase>.newInstance(driver: SqlDriver): RawgDatabase =
    RawgDatabaseImpl(driver)

private class RawgDatabaseImpl(
  driver: SqlDriver
) : TransacterImpl(driver), RawgDatabase {
  override val rawgDatabaseQueries: RawgDatabaseQueriesImpl = RawgDatabaseQueriesImpl(this, driver)

  object Schema : SqlDriver.Schema {
    override val version: Int
      get() = 1

    override fun create(driver: SqlDriver) {
      driver.execute(null, """
          |CREATE TABLE Job (
          |    id INTEGER PRIMARY KEY,
          |    name TEXT NOT NULL,
          |    slug TEXT
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Creator (
          |    id INTEGER PRIMARY KEY,
          |    nextPage TEXT,
          |    prevPage TEXT,
          |    name TEXT NOT NULL,
          |    slug TEXT,
          |    image TEXT,
          |    imageBackground TEXT,
          |    gamesCount INTEGER NOT NULL DEFAULT 0
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Creator_Job (
          |    creatorId INTEGER NOT NULL,
          |    jobId INTEGER NOT NULL,
          |    PRIMARY KEY (creatorId, jobId),
          |    FOREIGN KEY (creatorId) REFERENCES Creator(id),
          |    FOREIGN KEY (jobId) REFERENCES Job(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Rating (
          |    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
          |    gameId INTEGER NOT NULL,
          |    title TEXT NOT NULL,
          |    count INTEGER NOT NULL DEFAULT 0,
          |    percent REAL NOT NULL DEFAULT 0.0,
          |    FOREIGN KEY (gameId) REFERENCES Rating(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Platform (
          |    id INTEGER PRIMARY KEY,
          |    nextPage TEXT,
          |    prevPage TEXT,
          |    name TEXT NOT NULL,
          |    slug TEXT,
          |    gamesCount INTEGER NOT NULL DEFAULT 0,
          |    imageBackground TEXT,
          |    image TEXT,
          |    yearStart INTEGER,
          |    yearEnd INTEGER,
          |    following INTEGER NOT NULL DEFAULT 0
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Game_Platform (
          |    gameId INTEGER NOT NULL,
          |    platformId INTEGER NOT NULL,
          |    releasedAt TEXT,
          |    minimumRequirement TEXT,
          |    recommendedRequirement TEXT,
          |    PRIMARY KEY (gameId, platformId),
          |    FOREIGN KEY (gameId) REFERENCES Game(id),
          |    FOREIGN KEY (platformId) REFERENCES Platform(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Game_ParentPlatform (
          |    gameId INTEGER NOT NULL,
          |    platformId INTEGER NOT NULL,
          |    PRIMARY KEY (gameId, platformId),
          |    FOREIGN KEY (gameId) REFERENCES Game(id),
          |    FOREIGN KEY (platformId) REFERENCES Platform(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Store (
          |    id INTEGER PRIMARY KEY,
          |    name TEXT NOT NULL,
          |    slug TEXT,
          |    domain TEXT,
          |    gamesCount INTEGER NOT NULL DEFAULT 0,
          |    imageBackground TEXT,
          |    following INTEGER NOT NULL DEFAULT 0
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Game_Store (
          |    gameId INTEGER NOT NULL,
          |    storeId INTEGER NOT NULL,
          |    url TEXT,
          |    PRIMARY KEY (gameId, storeId),
          |    FOREIGN KEY (gameId) REFERENCES Game(id),
          |    FOREIGN KEY (storeId) REFERENCES Store(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Genre (
          |    id INTEGER PRIMARY KEY,
          |    name TEXT NOT NULL,
          |    slug TEXT,
          |    gamesCount INTEGER NOT NULL DEFAULT 0,
          |    imageBackground TEXT
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Game_Genre (
          |    gameId INTEGER NOT NULL,
          |    genreId INTEGER NOT NULL,
          |    PRIMARY KEY (gameId, genreId),
          |    FOREIGN KEY (gameId) REFERENCES Game(id),
          |    FOREIGN KEY (genreId) REFERENCES Genre(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Developer (
          |    id INTEGER PRIMARY KEY,
          |    name TEXT NOT NULL,
          |    slug TEXT,
          |    gameCount INTEGER NOT NULL DEFAULT 0,
          |    imageBackground TEXT,
          |    description TEXT
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Game_Developer (
          |    gameId INTEGER NOT NULL,
          |    developerId INTEGER NOT NULL,
          |    PRIMARY KEY (gameId, developerId),
          |    FOREIGN KEY (gameId) REFERENCES Game(id),
          |    FOREIGN KEY (developerId) REFERENCES Developer(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Tag (
          |    id INTEGER PRIMARY KEY,
          |    nextPage TEXT,
          |    prevPage TEXT,
          |    name TEXT NOT NULL,
          |    slug TEXT,
          |    gamesCount INTEGER NOT NULL DEFAULT 0,
          |    language TEXT,
          |    imageBackground TEXT
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Game_Tag (
          |    gameId INTEGER NOT NULL,
          |    tagId INTEGER NOT NULL,
          |    PRIMARY KEY (gameId, tagId),
          |    FOREIGN KEY (gameId) REFERENCES Game(id),
          |    FOREIGN KEY (tagId) REFERENCES Tag(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Publisher (
          |    id INTEGER PRIMARY KEY,
          |    nextPage TEXT,
          |    prevPage TEXT,
          |    name TEXT NOT NULL,
          |    slug TEXT,
          |    gamesCount INTEGER NOT NULL DEFAULT 0,
          |    imageBackground TEXT
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Game_Publisher (
          |    gameId INTEGER NOT NULL,
          |    publisherId INTEGER NOT NULL,
          |    PRIMARY KEY (gameId, publisherId),
          |    FOREIGN KEY (gameId) REFERENCES Game(id),
          |    FOREIGN KEY (publisherId) REFERENCES Publisher(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Game_Screenshot (
          |    id INTEGER PRIMARY KEY AUTOINCREMENT,
          |    gameId INTEGER NOT NULL,
          |    url TEXT,
          |    FOREIGN KEY (gameId) REFERENCES Game(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE GameDetail(
          |    id INTEGER PRIMARY KEY,
          |    backgroundImageAddtional TEXT,
          |    description TEXT,
          |    rawDescription TEXT,
          |    screenshotsCount INTEGER NOT NULL DEFAULT 0,
          |    moviesCount INTEGER NOT NULL DEFAULT 0,
          |    creatorsCount INTEGER NOT NULL DEFAULT 0,
          |    achievementsCount INTEGER NOT NULL DEFAULT 0,
          |    parentAchievementsCount INTEGER NOT NULL DEFAULT 0,
          |    redditUrl TEXT,
          |    redditName TEXT,
          |    redditDescription TEXT,
          |    redditLogo TEXT,
          |    redditCount INTEGER NOT NULL DEFAULT 0,
          |    twitchCount INTEGER NOT NULL DEFAULT 0,
          |    youtubeCount INTEGER NOT NULL DEFAULT 0,
          |    additionsCount INTEGER NOT NULL DEFAULT 0,
          |    seriesCount INTEGER NOT NULL DEFAULT 0,
          |    FOREIGN KEY (id) REFERENCES Game(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Game (
          |    id INTEGER PRIMARY KEY,
          |    nextPage TEXT,
          |    prevPage TEXT,
          |    name TEXT NOT NULL,
          |    slug TEXT,
          |    released TEXT,
          |    tba INTEGER NOT NULL DEFAULT 0,
          |    backgroundImage TEXT,
          |    rating REAL NOT NULL DEFAULT 0.0,
          |    ratingTop REAL NOT NULL DEFAULT 5.0,
          |    ratingsCount INTEGER NOT NULL DEFAULT 0,
          |    reviewTextCount INTEGER NOT NULL DEFAULT 0,
          |    added INTEGER NOT NULL DEFAULT 0,
          |    metacritic INTEGER NOT NULL DEFAULT 0,
          |    playtime INTEGER NOT NULL DEFAULT 0,
          |    suggestionCount INTEGER NOT NULL DEFAULT 0,
          |    reviewsCount INTEGER NOT NULL DEFAULT 0,
          |    saturatedColor TEXT,
          |    dominantColor TEXT,
          |    clip TEXT
          |)
          """.trimMargin(), 0)
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ) {
    }
  }
}

private class RawgDatabaseQueriesImpl(
  private val database: RawgDatabaseImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), RawgDatabaseQueries {
  internal val loadJobs: MutableList<Query<*>> = copyOnWriteList()

  internal val loadJobById: MutableList<Query<*>> = copyOnWriteList()

  internal val loadCreators: MutableList<Query<*>> = copyOnWriteList()

  internal val loadRatings: MutableList<Query<*>> = copyOnWriteList()

  internal val loadPlatforms: MutableList<Query<*>> = copyOnWriteList()

  internal val loadGamePlatforms: MutableList<Query<*>> = copyOnWriteList()

  internal val loadGameParentPlatforms: MutableList<Query<*>> = copyOnWriteList()

  internal val loadStores: MutableList<Query<*>> = copyOnWriteList()

  internal val loadGameStores: MutableList<Query<*>> = copyOnWriteList()

  internal val loadGenres: MutableList<Query<*>> = copyOnWriteList()

  internal val loadGameGenres: MutableList<Query<*>> = copyOnWriteList()

  internal val loadDevelopers: MutableList<Query<*>> = copyOnWriteList()

  internal val loadDevelopersByIds: MutableList<Query<*>> = copyOnWriteList()

  internal val loadTags: MutableList<Query<*>> = copyOnWriteList()

  internal val loadGameTags: MutableList<Query<*>> = copyOnWriteList()

  internal val loadPublishers: MutableList<Query<*>> = copyOnWriteList()

  internal val loadGameScreenshots: MutableList<Query<*>> = copyOnWriteList()

  internal val loadGameDetail: MutableList<Query<*>> = copyOnWriteList()

  internal val loadGames: MutableList<Query<*>> = copyOnWriteList()

  internal val loadGame: MutableList<Query<*>> = copyOnWriteList()

  override fun <T : Any> loadJobs(mapper: (
    id: Int,
    name: String,
    slug: String?
  ) -> T): Query<T> = Query(1476506525, loadJobs, driver, "RawgDatabase.sq", "loadJobs",
      "SELECT * FROM Job") { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1)!!,
      cursor.getString(2)
    )
  }

  override fun loadJobs(): Query<Job> = loadJobs { id, name, slug ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Job(
      id,
      name,
      slug
    )
  }

  override fun <T : Any> loadJobById(id: Int, mapper: (
    id: Int,
    name: String,
    slug: String?
  ) -> T): Query<T> = LoadJobByIdQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1)!!,
      cursor.getString(2)
    )
  }

  override fun loadJobById(id: Int): Query<Job> = loadJobById(id) { id, name, slug ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Job(
      id,
      name,
      slug
    )
  }

  override fun <T : Any> loadCreators(mapper: (
    id: Int,
    nextPage: String?,
    prevPage: String?,
    name: String,
    slug: String?,
    image: String?,
    imageBackground: String?,
    gamesCount: Long
  ) -> T): Query<T> = Query(511074702, loadCreators, driver, "RawgDatabase.sq", "loadCreators",
      "SELECT * FROM Creator") { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1),
      cursor.getString(2),
      cursor.getString(3)!!,
      cursor.getString(4),
      cursor.getString(5),
      cursor.getString(6),
      cursor.getLong(7)!!
    )
  }

  override fun loadCreators(): Query<Creator> = loadCreators { id, nextPage, prevPage, name, slug,
      image, imageBackground, gamesCount ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Creator(
      id,
      nextPage,
      prevPage,
      name,
      slug,
      image,
      imageBackground,
      gamesCount
    )
  }

  override fun <T : Any> loadRatings(gameId: Collection<Int>, mapper: (
    id: Int,
    gameId: Int,
    title: String,
    count: Int,
    percent: Float
  ) -> T): Query<T> = LoadRatingsQuery(gameId) { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getLong(1)!!.toInt(),
      cursor.getString(2)!!,
      cursor.getLong(3)!!.toInt(),
      cursor.getDouble(4)!!.toFloat()
    )
  }

  override fun loadRatings(gameId: Collection<Int>): Query<Rating> = loadRatings(gameId) { id,
      gameId, title, count, percent ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Rating(
      id,
      gameId,
      title,
      count,
      percent
    )
  }

  override fun <T : Any> loadPlatforms(mapper: (
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
  ) -> T): Query<T> = Query(345391993, loadPlatforms, driver, "RawgDatabase.sq", "loadPlatforms",
      "SELECT * FROM Platform") { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1),
      cursor.getString(2),
      cursor.getString(3)!!,
      cursor.getString(4),
      cursor.getLong(5)!!.toInt(),
      cursor.getString(6),
      cursor.getString(7),
      cursor.getLong(8)?.toInt(),
      cursor.getLong(9)?.toInt(),
      cursor.getLong(10)!! == 1L
    )
  }

  override fun loadPlatforms(): Query<Platform> = loadPlatforms { id, nextPage, prevPage, name,
      slug, gamesCount, imageBackground, image, yearStart, yearEnd, following ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Platform(
      id,
      nextPage,
      prevPage,
      name,
      slug,
      gamesCount,
      imageBackground,
      image,
      yearStart,
      yearEnd,
      following
    )
  }

  override fun <T : Any> loadGamePlatforms(gameId: Collection<Int>, mapper: (
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
  ) -> T): Query<T> = LoadGamePlatformsQuery(gameId) { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getLong(1)!!.toInt(),
      cursor.getString(2),
      cursor.getString(3),
      cursor.getString(4),
      cursor.getLong(5)!!.toInt(),
      cursor.getString(6),
      cursor.getString(7),
      cursor.getString(8)!!,
      cursor.getString(9),
      cursor.getLong(10)!!.toInt(),
      cursor.getString(11),
      cursor.getString(12),
      cursor.getLong(13)?.toInt(),
      cursor.getLong(14)?.toInt(),
      cursor.getLong(15)!! == 1L
    )
  }

  override fun loadGamePlatforms(gameId: Collection<Int>): Query<LoadGamePlatforms> =
      loadGamePlatforms(gameId) { gameId, platformId, releasedAt, minimumRequirement,
      recommendedRequirement, id, nextPage, prevPage, name, slug, gamesCount, imageBackground,
      image, yearStart, yearEnd, following ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.LoadGamePlatforms(
      gameId,
      platformId,
      releasedAt,
      minimumRequirement,
      recommendedRequirement,
      id,
      nextPage,
      prevPage,
      name,
      slug,
      gamesCount,
      imageBackground,
      image,
      yearStart,
      yearEnd,
      following
    )
  }

  override fun <T : Any> loadGameParentPlatforms(gameId: Collection<Int>, mapper: (
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
  ) -> T): Query<T> = LoadGameParentPlatformsQuery(gameId) { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getLong(1)!!.toInt(),
      cursor.getLong(2)!!.toInt(),
      cursor.getString(3),
      cursor.getString(4),
      cursor.getString(5)!!,
      cursor.getString(6),
      cursor.getLong(7)!!.toInt(),
      cursor.getString(8),
      cursor.getString(9),
      cursor.getLong(10)?.toInt(),
      cursor.getLong(11)?.toInt(),
      cursor.getLong(12)!! == 1L
    )
  }

  override fun loadGameParentPlatforms(gameId: Collection<Int>): Query<LoadGameParentPlatforms> =
      loadGameParentPlatforms(gameId) { gameId, platformId, id, nextPage, prevPage, name, slug,
      gamesCount, imageBackground, image, yearStart, yearEnd, following ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.LoadGameParentPlatforms(
      gameId,
      platformId,
      id,
      nextPage,
      prevPage,
      name,
      slug,
      gamesCount,
      imageBackground,
      image,
      yearStart,
      yearEnd,
      following
    )
  }

  override fun <T : Any> loadStores(mapper: (
    id: Int,
    name: String,
    slug: String?,
    domain: String?,
    gamesCount: Int,
    imageBackground: String?,
    following: Boolean
  ) -> T): Query<T> = Query(1846232377, loadStores, driver, "RawgDatabase.sq", "loadStores",
      "SELECT * FROM Store") { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1)!!,
      cursor.getString(2),
      cursor.getString(3),
      cursor.getLong(4)!!.toInt(),
      cursor.getString(5),
      cursor.getLong(6)!! == 1L
    )
  }

  override fun loadStores(): Query<Store> = loadStores { id, name, slug, domain, gamesCount,
      imageBackground, following ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Store(
      id,
      name,
      slug,
      domain,
      gamesCount,
      imageBackground,
      following
    )
  }

  override fun <T : Any> loadGameStores(gameId: Collection<Int>, mapper: (
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
  ) -> T): Query<T> = LoadGameStoresQuery(gameId) { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getLong(1)!!.toInt(),
      cursor.getString(2),
      cursor.getLong(3)!!.toInt(),
      cursor.getString(4)!!,
      cursor.getString(5),
      cursor.getString(6),
      cursor.getLong(7)!!.toInt(),
      cursor.getString(8),
      cursor.getLong(9)!! == 1L
    )
  }

  override fun loadGameStores(gameId: Collection<Int>): Query<LoadGameStores> =
      loadGameStores(gameId) { gameId, storeId, url, id, name, slug, domain, gamesCount,
      imageBackground, following ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.LoadGameStores(
      gameId,
      storeId,
      url,
      id,
      name,
      slug,
      domain,
      gamesCount,
      imageBackground,
      following
    )
  }

  override fun <T : Any> loadGenres(mapper: (
    id: Int,
    name: String,
    slug: String?,
    gamesCount: Int,
    imageBackground: String?
  ) -> T): Query<T> = Query(1488799959, loadGenres, driver, "RawgDatabase.sq", "loadGenres",
      "SELECT * FROM Genre") { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1)!!,
      cursor.getString(2),
      cursor.getLong(3)!!.toInt(),
      cursor.getString(4)
    )
  }

  override fun loadGenres(): Query<Genre> = loadGenres { id, name, slug, gamesCount,
      imageBackground ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Genre(
      id,
      name,
      slug,
      gamesCount,
      imageBackground
    )
  }

  override fun <T : Any> loadGameGenres(gameId: Collection<Int>, mapper: (
    gameId: Int,
    genreId: Int,
    id: Int,
    name: String,
    slug: String?,
    gamesCount: Int,
    imageBackground: String?
  ) -> T): Query<T> = LoadGameGenresQuery(gameId) { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getLong(1)!!.toInt(),
      cursor.getLong(2)!!.toInt(),
      cursor.getString(3)!!,
      cursor.getString(4),
      cursor.getLong(5)!!.toInt(),
      cursor.getString(6)
    )
  }

  override fun loadGameGenres(gameId: Collection<Int>): Query<LoadGameGenres> =
      loadGameGenres(gameId) { gameId, genreId, id, name, slug, gamesCount, imageBackground ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.LoadGameGenres(
      gameId,
      genreId,
      id,
      name,
      slug,
      gamesCount,
      imageBackground
    )
  }

  override fun <T : Any> loadDevelopers(mapper: (
    id: Int,
    name: String,
    slug: String?,
    gameCount: Int,
    imageBackground: String?,
    description: String?
  ) -> T): Query<T> = Query(1931024368, loadDevelopers, driver, "RawgDatabase.sq", "loadDevelopers",
      "SELECT * FROM Developer") { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1)!!,
      cursor.getString(2),
      cursor.getLong(3)!!.toInt(),
      cursor.getString(4),
      cursor.getString(5)
    )
  }

  override fun loadDevelopers(): Query<Developer> = loadDevelopers { id, name, slug, gameCount,
      imageBackground, description ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Developer(
      id,
      name,
      slug,
      gameCount,
      imageBackground,
      description
    )
  }

  override fun <T : Any> loadDevelopersByIds(id: Int, mapper: (
    id: Int,
    name: String,
    slug: String?,
    gameCount: Int,
    imageBackground: String?,
    description: String?
  ) -> T): Query<T> = LoadDevelopersByIdsQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1)!!,
      cursor.getString(2),
      cursor.getLong(3)!!.toInt(),
      cursor.getString(4),
      cursor.getString(5)
    )
  }

  override fun loadDevelopersByIds(id: Int): Query<Developer> = loadDevelopersByIds(id) { id, name,
      slug, gameCount, imageBackground, description ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Developer(
      id,
      name,
      slug,
      gameCount,
      imageBackground,
      description
    )
  }

  override fun <T : Any> loadTags(mapper: (
    id: Int,
    nextPage: String?,
    prevPage: String?,
    name: String,
    slug: String?,
    gamesCount: Int,
    language: String?,
    imageBackground: String?
  ) -> T): Query<T> = Query(1476791136, loadTags, driver, "RawgDatabase.sq", "loadTags",
      "SELECT * FROM Tag") { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1),
      cursor.getString(2),
      cursor.getString(3)!!,
      cursor.getString(4),
      cursor.getLong(5)!!.toInt(),
      cursor.getString(6),
      cursor.getString(7)
    )
  }

  override fun loadTags(): Query<Tag> = loadTags { id, nextPage, prevPage, name, slug, gamesCount,
      language, imageBackground ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Tag(
      id,
      nextPage,
      prevPage,
      name,
      slug,
      gamesCount,
      language,
      imageBackground
    )
  }

  override fun <T : Any> loadGameTags(gameId: Collection<Int>, mapper: (
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
  ) -> T): Query<T> = LoadGameTagsQuery(gameId) { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getLong(1)!!.toInt(),
      cursor.getLong(2)!!.toInt(),
      cursor.getString(3),
      cursor.getString(4),
      cursor.getString(5)!!,
      cursor.getString(6),
      cursor.getLong(7)!!.toInt(),
      cursor.getString(8),
      cursor.getString(9)
    )
  }

  override fun loadGameTags(gameId: Collection<Int>): Query<LoadGameTags> = loadGameTags(gameId) {
      gameId, tagId, id, nextPage, prevPage, name, slug, gamesCount, language, imageBackground ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.LoadGameTags(
      gameId,
      tagId,
      id,
      nextPage,
      prevPage,
      name,
      slug,
      gamesCount,
      language,
      imageBackground
    )
  }

  override fun <T : Any> loadPublishers(mapper: (
    id: Int,
    nextPage: String?,
    prevPage: String?,
    name: String,
    slug: String?,
    gamesCount: Int,
    imageBackground: String?
  ) -> T): Query<T> = Query(2057020414, loadPublishers, driver, "RawgDatabase.sq", "loadPublishers",
      "SELECT * FROM Publisher") { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1),
      cursor.getString(2),
      cursor.getString(3)!!,
      cursor.getString(4),
      cursor.getLong(5)!!.toInt(),
      cursor.getString(6)
    )
  }

  override fun loadPublishers(): Query<Publisher> = loadPublishers { id, nextPage, prevPage, name,
      slug, gamesCount, imageBackground ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Publisher(
      id,
      nextPage,
      prevPage,
      name,
      slug,
      gamesCount,
      imageBackground
    )
  }

  override fun <T : Any> loadGameScreenshots(gameId: Collection<Int>, mapper: (
    id: Int,
    gameId: Int,
    url: String?
  ) -> T): Query<T> = LoadGameScreenshotsQuery(gameId) { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getLong(1)!!.toInt(),
      cursor.getString(2)
    )
  }

  override fun loadGameScreenshots(gameId: Collection<Int>): Query<Game_Screenshot> =
      loadGameScreenshots(gameId) { id, gameId, url ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Game_Screenshot(
      id,
      gameId,
      url
    )
  }

  override fun <T : Any> loadGameDetail(id: Int, mapper: (
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
  ) -> T): Query<T> = LoadGameDetailQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1),
      cursor.getString(2),
      cursor.getString(3),
      cursor.getLong(4)!!.toInt(),
      cursor.getLong(5)!!.toInt(),
      cursor.getLong(6)!!.toInt(),
      cursor.getLong(7)!!.toInt(),
      cursor.getLong(8)!!.toInt(),
      cursor.getString(9),
      cursor.getString(10),
      cursor.getString(11),
      cursor.getString(12),
      cursor.getLong(13)!!.toInt(),
      cursor.getLong(14)!!.toInt(),
      cursor.getLong(15)!!.toInt(),
      cursor.getLong(16)!!.toInt(),
      cursor.getLong(17)!!.toInt()
    )
  }

  override fun loadGameDetail(id: Int): Query<GameDetail> = loadGameDetail(id) { id,
      backgroundImageAddtional, description, rawDescription, screenshotsCount, moviesCount,
      creatorsCount, achievementsCount, parentAchievementsCount, redditUrl, redditName,
      redditDescription, redditLogo, redditCount, twitchCount, youtubeCount, additionsCount,
      seriesCount ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.GameDetail(
      id,
      backgroundImageAddtional,
      description,
      rawDescription,
      screenshotsCount,
      moviesCount,
      creatorsCount,
      achievementsCount,
      parentAchievementsCount,
      redditUrl,
      redditName,
      redditDescription,
      redditLogo,
      redditCount,
      twitchCount,
      youtubeCount,
      additionsCount,
      seriesCount
    )
  }

  override fun <T : Any> loadGames(mapper: (
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
  ) -> T): Query<T> = Query(-1476115366, loadGames, driver, "RawgDatabase.sq", "loadGames", """
  |SELECT *
  |FROM Game
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1),
      cursor.getString(2),
      cursor.getString(3)!!,
      cursor.getString(4),
      cursor.getString(5),
      cursor.getLong(6)!! == 1L,
      cursor.getString(7),
      cursor.getDouble(8)!!.toFloat(),
      cursor.getDouble(9)!!.toFloat(),
      cursor.getLong(10)!!.toInt(),
      cursor.getLong(11)!!.toInt(),
      cursor.getLong(12)!!.toInt(),
      cursor.getLong(13)!!.toInt(),
      cursor.getLong(14)!!.toInt(),
      cursor.getLong(15)!!.toInt(),
      cursor.getLong(16)!!.toInt(),
      cursor.getString(17),
      cursor.getString(18),
      cursor.getString(19)
    )
  }

  override fun loadGames(): Query<Game> = loadGames { id, nextPage, prevPage, name, slug, released,
      tba, backgroundImage, rating, ratingTop, ratingsCount, reviewTextCount, added, metacritic,
      playtime, suggestionCount, reviewsCount, saturatedColor, dominantColor, clip ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Game(
      id,
      nextPage,
      prevPage,
      name,
      slug,
      released,
      tba,
      backgroundImage,
      rating,
      ratingTop,
      ratingsCount,
      reviewTextCount,
      added,
      metacritic,
      playtime,
      suggestionCount,
      reviewsCount,
      saturatedColor,
      dominantColor,
      clip
    )
  }

  override fun <T : Any> loadGame(id: Int, mapper: (
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
  ) -> T): Query<T> = LoadGameQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!.toInt(),
      cursor.getString(1),
      cursor.getString(2),
      cursor.getString(3)!!,
      cursor.getString(4),
      cursor.getString(5),
      cursor.getLong(6)!! == 1L,
      cursor.getString(7),
      cursor.getDouble(8)!!.toFloat(),
      cursor.getDouble(9)!!.toFloat(),
      cursor.getLong(10)!!.toInt(),
      cursor.getLong(11)!!.toInt(),
      cursor.getLong(12)!!.toInt(),
      cursor.getLong(13)!!.toInt(),
      cursor.getLong(14)!!.toInt(),
      cursor.getLong(15)!!.toInt(),
      cursor.getLong(16)!!.toInt(),
      cursor.getString(17),
      cursor.getString(18),
      cursor.getString(19)
    )
  }

  override fun loadGame(id: Int): Query<Game> = loadGame(id) { id, nextPage, prevPage, name, slug,
      released, tba, backgroundImage, rating, ratingTop, ratingsCount, reviewTextCount, added,
      metacritic, playtime, suggestionCount, reviewsCount, saturatedColor, dominantColor, clip ->
    com.chathil.rawgapiwrapper.rawgSdk.cache.Game(
      id,
      nextPage,
      prevPage,
      name,
      slug,
      released,
      tba,
      backgroundImage,
      rating,
      ratingTop,
      ratingsCount,
      reviewTextCount,
      added,
      metacritic,
      playtime,
      suggestionCount,
      reviewsCount,
      saturatedColor,
      dominantColor,
      clip
    )
  }

  override fun insertJob(
    id: Int?,
    name: String,
    slug: String?
  ) {
    driver.execute(1067508003, """
    |INSERT OR REPLACE INTO Job
    |VALUES(?, ?, ?)
    """.trimMargin(), 3) {
      bindLong(1, id?.let { it.toLong() })
      bindString(2, name)
      bindString(3, slug)
    }
    notifyQueries(1067508003, {database.rawgDatabaseQueries.loadJobs +
        database.rawgDatabaseQueries.loadJobById})
  }

  override fun clearAllJobs() {
    driver.execute(765569867, """DELETE FROM Job""", 0)
    notifyQueries(765569867, {database.rawgDatabaseQueries.loadJobs +
        database.rawgDatabaseQueries.loadJobById})
  }

  override fun insertCreator(
    id: Int?,
    nextPage: String?,
    prevPage: String?,
    name: String,
    slug: String?,
    image: String?,
    imageBackground: String?,
    gamesCount: Long
  ) {
    driver.execute(1734386322, """
    |INSERT OR REPLACE INTO Creator
    |VALUES(?, ?, ?, ?, ?, ?, ?, ?)
    """.trimMargin(), 8) {
      bindLong(1, id?.let { it.toLong() })
      bindString(2, nextPage)
      bindString(3, prevPage)
      bindString(4, name)
      bindString(5, slug)
      bindString(6, image)
      bindString(7, imageBackground)
      bindLong(8, gamesCount)
    }
    notifyQueries(1734386322, {database.rawgDatabaseQueries.loadCreators})
  }

  override fun clearCreator(id: Int) {
    driver.execute(-1588389408, """
    |DELETE FROM Creator
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }
    notifyQueries(-1588389408, {database.rawgDatabaseQueries.loadCreators})
  }

  override fun clearAllCreators() {
    driver.execute(-1361653188, """DELETE FROM Creator""", 0)
    notifyQueries(-1361653188, {database.rawgDatabaseQueries.loadCreators})
  }

  override fun insertCreator_CreatorPosition(creatorId: Int, jobId: Int) {
    driver.execute(-1821385304, """
    |INSERT OR REPLACE INTO Creator_Job
    |VALUES(?, ?)
    """.trimMargin(), 2) {
      bindLong(1, creatorId.toLong())
      bindLong(2, jobId.toLong())
    }
  }

  override fun clearCreator_CreatorPosition(jobId: Int) {
    driver.execute(861272310, """
    |DELETE FROM Creator_Job
    |WHERE jobId = ?
    """.trimMargin(), 1) {
      bindLong(1, jobId.toLong())
    }
  }

  override fun clearCreator_CreatorPositions() {
    driver.execute(929637949, """DELETE FROM Creator_Job""", 0)
  }

  override fun insertRating(
    gameId: Int,
    title: String,
    count: Int,
    percent: Float
  ) {
    driver.execute(-1885164937, """
    |INSERT OR REPLACE INTO Rating(gameId, title, count, percent)
    |VALUES (?, ?, ?, ?)
    """.trimMargin(), 4) {
      bindLong(1, gameId.toLong())
      bindString(2, title)
      bindLong(3, count.toLong())
      bindDouble(4, percent.toDouble())
    }
    notifyQueries(-1885164937, {database.rawgDatabaseQueries.loadRatings})
  }

  override fun clearRating(id: Int) {
    driver.execute(-2130898583, """
    |DELETE FROM Rating
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }
    notifyQueries(-2130898583, {database.rawgDatabaseQueries.loadRatings})
  }

  override fun clearRatings() {
    driver.execute(-1633346518, """DELETE FROM Rating""", 0)
    notifyQueries(-1633346518, {database.rawgDatabaseQueries.loadRatings})
  }

  override fun insertPlatform(
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
  ) {
    driver.execute(-2014342451, """
    |INSERT OR REPLACE INTO Platform
    |VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """.trimMargin(), 11) {
      bindLong(1, id?.let { it.toLong() })
      bindString(2, nextPage)
      bindString(3, prevPage)
      bindString(4, name)
      bindString(5, slug)
      bindLong(6, gamesCount.toLong())
      bindString(7, imageBackground)
      bindString(8, image)
      bindLong(9, yearStart?.let { it.toLong() })
      bindLong(10, yearEnd?.let { it.toLong() })
      bindLong(11, if (following) 1L else 0L)
    }
    notifyQueries(-2014342451, {database.rawgDatabaseQueries.loadPlatforms +
        database.rawgDatabaseQueries.loadGamePlatforms +
        database.rawgDatabaseQueries.loadGameParentPlatforms})
  }

  override fun clearPlatform(id: Int) {
    driver.execute(-1941174977, """
    |DELETE FROM Platform
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }
    notifyQueries(-1941174977, {database.rawgDatabaseQueries.loadPlatforms +
        database.rawgDatabaseQueries.loadGamePlatforms +
        database.rawgDatabaseQueries.loadGameParentPlatforms})
  }

  override fun clearPlatforms() {
    driver.execute(-46882028, """DELETE FROM Platform""", 0)
    notifyQueries(-46882028, {database.rawgDatabaseQueries.loadPlatforms +
        database.rawgDatabaseQueries.loadGamePlatforms +
        database.rawgDatabaseQueries.loadGameParentPlatforms})
  }

  override fun insertGamePlatform(
    gameId: Int,
    platformId: Int,
    releasedAt: String?,
    minimumRequirement: String?,
    recommendedRequirement: String?
  ) {
    driver.execute(2097116127, """
    |INSERT OR REPLACE INTO Game_Platform
    |VALUES(?, ?, ?, ?, ?)
    """.trimMargin(), 5) {
      bindLong(1, gameId.toLong())
      bindLong(2, platformId.toLong())
      bindString(3, releasedAt)
      bindString(4, minimumRequirement)
      bindString(5, recommendedRequirement)
    }
    notifyQueries(2097116127, {database.rawgDatabaseQueries.loadGamePlatforms})
  }

  override fun clearGamePlatforms() {
    driver.execute(-1022210750, """DELETE FROM Game_Platform""", 0)
    notifyQueries(-1022210750, {database.rawgDatabaseQueries.loadGamePlatforms})
  }

  override fun insertGameParentPlatform(gameId: Int, platformId: Int) {
    driver.execute(-1080339031, """
    |INSERT OR REPLACE INTO Game_ParentPlatform
    |VALUES(?, ?)
    """.trimMargin(), 2) {
      bindLong(1, gameId.toLong())
      bindLong(2, platformId.toLong())
    }
    notifyQueries(-1080339031, {database.rawgDatabaseQueries.loadGameParentPlatforms})
  }

  override fun clearGameParentPlatforms() {
    driver.execute(-1498197448, """DELETE FROM Game_ParentPlatform""", 0)
    notifyQueries(-1498197448, {database.rawgDatabaseQueries.loadGameParentPlatforms})
  }

  override fun insertStore(
    id: Int?,
    name: String,
    slug: String?,
    domain: String?,
    gamesCount: Int,
    imageBackground: String?,
    following: Boolean
  ) {
    driver.execute(-613516089, """
    |INSERT OR REPLACE INTO Store
    |VALUES(?, ?, ?, ?, ?, ?, ?)
    """.trimMargin(), 7) {
      bindLong(1, id?.let { it.toLong() })
      bindString(2, name)
      bindString(3, slug)
      bindString(4, domain)
      bindLong(5, gamesCount.toLong())
      bindString(6, imageBackground)
      bindLong(7, if (following) 1L else 0L)
    }
    notifyQueries(-613516089, {database.rawgDatabaseQueries.loadStores +
        database.rawgDatabaseQueries.loadGameStores})
  }

  override fun clearStore(id: Int) {
    driver.execute(1318219669, """
    |DELETE FROM Store
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }
    notifyQueries(1318219669, {database.rawgDatabaseQueries.loadStores +
        database.rawgDatabaseQueries.loadGameStores})
  }

  override fun clearStores() {
    driver.execute(-2084863106, """DELETE FROM Store""", 0)
    notifyQueries(-2084863106, {database.rawgDatabaseQueries.loadStores +
        database.rawgDatabaseQueries.loadGameStores})
  }

  override fun insertGameStore(
    gameId: Int,
    storeId: Int,
    url: String?
  ) {
    driver.execute(689341685, """
    |INSERT OR REPLACE INTO Game_Store
    |VALUES (?, ?, ?)
    """.trimMargin(), 3) {
      bindLong(1, gameId.toLong())
      bindLong(2, storeId.toLong())
      bindString(3, url)
    }
    notifyQueries(689341685, {database.rawgDatabaseQueries.loadGameStores})
  }

  override fun clearGameStores() {
    driver.execute(1489221648, """DELETE FROM Game_Store""", 0)
    notifyQueries(1489221648, {database.rawgDatabaseQueries.loadGameStores})
  }

  override fun insertGenre(
    id: Int?,
    name: String,
    slug: String?,
    gamesCount: Int,
    imageBackground: String?
  ) {
    driver.execute(-625046167, """
    |INSERT OR REPLACE INTO Genre
    |VALUES (?, ?, ?, ?, ?)
    """.trimMargin(), 5) {
      bindLong(1, id?.let { it.toLong() })
      bindString(2, name)
      bindString(3, slug)
      bindLong(4, gamesCount.toLong())
      bindString(5, imageBackground)
    }
    notifyQueries(-625046167, {database.rawgDatabaseQueries.loadGenres +
        database.rawgDatabaseQueries.loadGameGenres})
  }

  override fun clearGenre(id: Int) {
    driver.execute(1306689591, """
    |DELETE FROM Genre
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }
    notifyQueries(1306689591, {database.rawgDatabaseQueries.loadGenres +
        database.rawgDatabaseQueries.loadGameGenres})
  }

  override fun clearAllGenres() {
    driver.execute(1178471685, """DELETE FROM Genre""", 0)
    notifyQueries(1178471685, {database.rawgDatabaseQueries.loadGenres +
        database.rawgDatabaseQueries.loadGameGenres})
  }

  override fun insertGameGenre(gameId: Int, genreId: Int) {
    driver.execute(677811607, """
    |INSERT OR REPLACE INTO Game_Genre
    |VALUES (?, ?)
    """.trimMargin(), 2) {
      bindLong(1, gameId.toLong())
      bindLong(2, genreId.toLong())
    }
    notifyQueries(677811607, {database.rawgDatabaseQueries.loadGameGenres})
  }

  override fun clearAllGameGenres() {
    driver.execute(307176727, """DELETE FROM Game_Genre""", 0)
    notifyQueries(307176727, {database.rawgDatabaseQueries.loadGameGenres})
  }

  override fun insertDeveloper(
    id: Int?,
    name: String,
    slug: String?,
    gameCount: Int,
    imageBackground: String?,
    description: String?
  ) {
    driver.execute(-381417296, """
    |INSERT OR REPLACE INTO Developer(id, name, slug, gameCount, imageBackground, description)
    |VALUES(?, ?, ?, ?, ?, ?)
    """.trimMargin(), 6) {
      bindLong(1, id?.let { it.toLong() })
      bindString(2, name)
      bindString(3, slug)
      bindLong(4, gameCount.toLong())
      bindString(5, imageBackground)
      bindString(6, description)
    }
    notifyQueries(-381417296, {database.rawgDatabaseQueries.loadDevelopers +
        database.rawgDatabaseQueries.loadDevelopersByIds})
  }

  override fun clearAllDevelopers() {
    driver.execute(1830819102, """DELETE FROM Developer""", 0)
    notifyQueries(1830819102, {database.rawgDatabaseQueries.loadDevelopers +
        database.rawgDatabaseQueries.loadDevelopersByIds})
  }

  override fun clearDeveloper(id: Int) {
    driver.execute(1886774398, """
    |DELETE FROM Developer
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }
    notifyQueries(1886774398, {database.rawgDatabaseQueries.loadDevelopers +
        database.rawgDatabaseQueries.loadDevelopersByIds})
  }

  override fun insertGameDeveloper(gameId: Int, developerId: Int) {
    driver.execute(-1775220258, """
    |INSERT OR REPLACE INTO Game_Developer
    |VALUES (?, ?)
    """.trimMargin(), 2) {
      bindLong(1, gameId.toLong())
      bindLong(2, developerId.toLong())
    }
  }

  override fun clearGameDevelopers() {
    driver.execute(-1809955001, """DELETE FROM Game_Developer""", 0)
  }

  override fun insertTag(
    id: Int?,
    nextPage: String?,
    prevPage: String?,
    name: String,
    slug: String?,
    gamesCount: Int,
    language: String?,
    imageBackground: String?
  ) {
    driver.execute(1067517184, """
    |INSERT OR REPLACE INTO Tag
    |VALUES (?, ?, ?, ?, ?, ?, ?, ?)
    """.trimMargin(), 8) {
      bindLong(1, id?.let { it.toLong() })
      bindString(2, nextPage)
      bindString(3, prevPage)
      bindString(4, name)
      bindString(5, slug)
      bindLong(6, gamesCount.toLong())
      bindString(7, language)
      bindString(8, imageBackground)
    }
    notifyQueries(1067517184, {database.rawgDatabaseQueries.loadTags +
        database.rawgDatabaseQueries.loadGameTags})
  }

  override fun clearTag(id: Int) {
    driver.execute(421483342, """
    |DELETE FROM Tag
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }
    notifyQueries(421483342, {database.rawgDatabaseQueries.loadTags +
        database.rawgDatabaseQueries.loadGameTags})
  }

  override fun clearTags() {
    driver.execute(181081829, """DELETE FROM Tag""", 0)
    notifyQueries(181081829, {database.rawgDatabaseQueries.loadTags +
        database.rawgDatabaseQueries.loadGameTags})
  }

  override fun insertGameTag(gameId: Int, tagId: Int) {
    driver.execute(510214318, """
    |INSERT OR REPLACE INTO Game_Tag
    |VALUES(?, ?)
    """.trimMargin(), 2) {
      bindLong(1, gameId.toLong())
      bindLong(2, tagId.toLong())
    }
    notifyQueries(510214318, {database.rawgDatabaseQueries.loadGameTags})
  }

  override fun clearAllGameTags() {
    driver.execute(-656279648, """DELETE FROM Tag""", 0)
    notifyQueries(-656279648, {database.rawgDatabaseQueries.loadTags +
        database.rawgDatabaseQueries.loadGameTags})
  }

  override fun insertPublisher(
    id: Int?,
    nextPage: String?,
    prevPage: String?,
    name: String,
    slug: String?,
    gamesCount: Int,
    imageBackground: String?
  ) {
    driver.execute(1146667746, """
    |INSERT OR REPLACE INTO Publisher
    |VALUES (?, ?, ?, ?, ?, ?, ?)
    """.trimMargin(), 7) {
      bindLong(1, id?.let { it.toLong() })
      bindString(2, nextPage)
      bindString(3, prevPage)
      bindString(4, name)
      bindString(5, slug)
      bindLong(6, gamesCount.toLong())
      bindString(7, imageBackground)
    }
    notifyQueries(1146667746, {database.rawgDatabaseQueries.loadPublishers})
  }

  override fun clearPublisher(id: Int) {
    driver.execute(-880107856, """
    |DELETE FROM Publisher
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }
    notifyQueries(-880107856, {database.rawgDatabaseQueries.loadPublishers})
  }

  override fun clearAllPublishers() {
    driver.execute(1956815148, """DELETE FROM Publisher""", 0)
    notifyQueries(1956815148, {database.rawgDatabaseQueries.loadPublishers})
  }

  override fun insertGamePublisher(gameId: Int, publisherId: Int) {
    driver.execute(-247135216, """
    |INSERT OR REPLACE INTO Game_Publisher
    |VALUES(?, ?)
    """.trimMargin(), 2) {
      bindLong(1, gameId.toLong())
      bindLong(2, publisherId.toLong())
    }
  }

  override fun clearAllGamePublishers() {
    driver.execute(593846334, """DELETE FROM Game_Publisher""", 0)
  }

  override fun insertGameScreenshots(
    id: Int?,
    gameId: Int,
    url: String?
  ) {
    driver.execute(-684567327, """
    |INSERT OR REPLACE INTO Game_Screenshot
    |VALUES (?, ?, ?)
    """.trimMargin(), 3) {
      bindLong(1, id?.let { it.toLong() })
      bindLong(2, gameId.toLong())
      bindString(3, url)
    }
    notifyQueries(-684567327, {database.rawgDatabaseQueries.loadGameScreenshots})
  }

  override fun clearGameScreenshotsByGameId(gameId: Int) {
    driver.execute(825990963, """
    |DELETE FROM Game_Screenshot
    |WHERE gameId = ?
    """.trimMargin(), 1) {
      bindLong(1, gameId.toLong())
    }
    notifyQueries(825990963, {database.rawgDatabaseQueries.loadGameScreenshots})
  }

  override fun insertGameDetail(
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
  ) {
    driver.execute(-548401475, """
    |INSERT OR REPLACE INTO GameDetail
    |VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """.trimMargin(), 18) {
      bindLong(1, id?.let { it.toLong() })
      bindString(2, backgroundImageAddtional)
      bindString(3, description)
      bindString(4, rawDescription)
      bindLong(5, screenshotsCount.toLong())
      bindLong(6, moviesCount.toLong())
      bindLong(7, creatorsCount.toLong())
      bindLong(8, achievementsCount.toLong())
      bindLong(9, parentAchievementsCount.toLong())
      bindString(10, redditUrl)
      bindString(11, redditName)
      bindString(12, redditDescription)
      bindString(13, redditLogo)
      bindLong(14, redditCount.toLong())
      bindLong(15, twitchCount.toLong())
      bindLong(16, youtubeCount.toLong())
      bindLong(17, additionsCount.toLong())
      bindLong(18, seriesCount.toLong())
    }
    notifyQueries(-548401475, {database.rawgDatabaseQueries.loadGameDetail})
  }

  override fun clearGameDetail(id: Int) {
    driver.execute(1046064303, """
    |DELETE FROM GameDetail
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }
    notifyQueries(1046064303, {database.rawgDatabaseQueries.loadGameDetail})
  }

  override fun clearGameDetails() {
    driver.execute(-1931744860, """DELETE FROM GameDetail""", 0)
    notifyQueries(-1931744860, {database.rawgDatabaseQueries.loadGameDetail})
  }

  override fun insertGame(
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
  ) {
    driver.execute(-1267092660, """
    |INSERT OR REPLACE INTO Game
    |VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """.trimMargin(), 20) {
      bindLong(1, id?.let { it.toLong() })
      bindString(2, nextPage)
      bindString(3, prevPage)
      bindString(4, name)
      bindString(5, slug)
      bindString(6, released)
      bindLong(7, if (tba) 1L else 0L)
      bindString(8, backgroundImage)
      bindDouble(9, rating.toDouble())
      bindDouble(10, ratingTop.toDouble())
      bindLong(11, ratingsCount.toLong())
      bindLong(12, reviewTextCount.toLong())
      bindLong(13, added.toLong())
      bindLong(14, metacritic.toLong())
      bindLong(15, playtime.toLong())
      bindLong(16, suggestionCount.toLong())
      bindLong(17, reviewsCount.toLong())
      bindString(18, saturatedColor)
      bindString(19, dominantColor)
      bindString(20, clip)
    }
    notifyQueries(-1267092660, {database.rawgDatabaseQueries.loadGames +
        database.rawgDatabaseQueries.loadGame})
  }

  override fun clearGame(id: Int) {
    driver.execute(180694718, """
    |DELETE FROM Game
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }
    notifyQueries(180694718, {database.rawgDatabaseQueries.loadGames +
        database.rawgDatabaseQueries.loadGame})
  }

  override fun clearAllGames() {
    driver.execute(-2040315284, """DELETE FROM Game""", 0)
    notifyQueries(-2040315284, {database.rawgDatabaseQueries.loadGames +
        database.rawgDatabaseQueries.loadGame})
  }

  private inner class LoadJobByIdQuery<out T : Any>(
    @JvmField
    val id: Int,
    mapper: (SqlCursor) -> T
  ) : Query<T>(loadJobById, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(1844466824, """
    |SELECT * FROM Job
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }

    override fun toString(): String = "RawgDatabase.sq:loadJobById"
  }

  private inner class LoadRatingsQuery<out T : Any>(
    @JvmField
    val gameId: Collection<Int>,
    mapper: (SqlCursor) -> T
  ) : Query<T>(loadRatings, mapper) {
    override fun execute(): SqlCursor {
      val gameIdIndexes = createArguments(count = gameId.size)
      return driver.executeQuery(null, """
      |SELECT * FROM Rating
      |WHERE gameId IN $gameIdIndexes
      """.trimMargin(), gameId.size) {
        gameId.forEachIndexed { index, gameId_ ->
            bindLong(index + 1, gameId_.toLong())
            }
      }
    }

    override fun toString(): String = "RawgDatabase.sq:loadRatings"
  }

  private inner class LoadGamePlatformsQuery<out T : Any>(
    @JvmField
    val gameId: Collection<Int>,
    mapper: (SqlCursor) -> T
  ) : Query<T>(loadGamePlatforms, mapper) {
    override fun execute(): SqlCursor {
      val gameIdIndexes = createArguments(count = gameId.size)
      return driver.executeQuery(null, """
      |SELECT * FROM Game_Platform
      |JOIN Platform
      |ON Game_Platform.platformId = Platform.id
      |WHERE Game_Platform.gameId IN $gameIdIndexes
      """.trimMargin(), gameId.size) {
        gameId.forEachIndexed { index, gameId_ ->
            bindLong(index + 1, gameId_.toLong())
            }
      }
    }

    override fun toString(): String = "RawgDatabase.sq:loadGamePlatforms"
  }

  private inner class LoadGameParentPlatformsQuery<out T : Any>(
    @JvmField
    val gameId: Collection<Int>,
    mapper: (SqlCursor) -> T
  ) : Query<T>(loadGameParentPlatforms, mapper) {
    override fun execute(): SqlCursor {
      val gameIdIndexes = createArguments(count = gameId.size)
      return driver.executeQuery(null, """
      |SELECT * FROM Game_ParentPlatform
      |JOIN Platform
      |ON Game_ParentPlatform.platformId = Platform.id
      |WHERE Game_ParentPlatform.gameId IN $gameIdIndexes
      """.trimMargin(), gameId.size) {
        gameId.forEachIndexed { index, gameId_ ->
            bindLong(index + 1, gameId_.toLong())
            }
      }
    }

    override fun toString(): String = "RawgDatabase.sq:loadGameParentPlatforms"
  }

  private inner class LoadGameStoresQuery<out T : Any>(
    @JvmField
    val gameId: Collection<Int>,
    mapper: (SqlCursor) -> T
  ) : Query<T>(loadGameStores, mapper) {
    override fun execute(): SqlCursor {
      val gameIdIndexes = createArguments(count = gameId.size)
      return driver.executeQuery(null, """
      |SELECT * FROM Game_Store
      |JOIN Store
      |ON Game_Store.storeId = Store.id
      |WHERE Game_Store.gameId IN $gameIdIndexes
      """.trimMargin(), gameId.size) {
        gameId.forEachIndexed { index, gameId_ ->
            bindLong(index + 1, gameId_.toLong())
            }
      }
    }

    override fun toString(): String = "RawgDatabase.sq:loadGameStores"
  }

  private inner class LoadGameGenresQuery<out T : Any>(
    @JvmField
    val gameId: Collection<Int>,
    mapper: (SqlCursor) -> T
  ) : Query<T>(loadGameGenres, mapper) {
    override fun execute(): SqlCursor {
      val gameIdIndexes = createArguments(count = gameId.size)
      return driver.executeQuery(null, """
      |SELECT * FROM Game_Genre
      |JOIN Genre
      |ON Game_Genre.genreId = Genre.id
      |WHERE Game_Genre.gameId IN $gameIdIndexes
      """.trimMargin(), gameId.size) {
        gameId.forEachIndexed { index, gameId_ ->
            bindLong(index + 1, gameId_.toLong())
            }
      }
    }

    override fun toString(): String = "RawgDatabase.sq:loadGameGenres"
  }

  private inner class LoadDevelopersByIdsQuery<out T : Any>(
    @JvmField
    val id: Int,
    mapper: (SqlCursor) -> T
  ) : Query<T>(loadDevelopersByIds, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(1902283985, """
    |SELECT * FROM Developer
    |WHERE id IN (?)
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }

    override fun toString(): String = "RawgDatabase.sq:loadDevelopersByIds"
  }

  private inner class LoadGameTagsQuery<out T : Any>(
    @JvmField
    val gameId: Collection<Int>,
    mapper: (SqlCursor) -> T
  ) : Query<T>(loadGameTags, mapper) {
    override fun execute(): SqlCursor {
      val gameIdIndexes = createArguments(count = gameId.size)
      return driver.executeQuery(null, """
      |SELECT * FROM Game_Tag
      |JOIN Tag
      |ON Game_Tag.tagId = Tag.id
      |WHERE Game_Tag.gameId IN $gameIdIndexes
      """.trimMargin(), gameId.size) {
        gameId.forEachIndexed { index, gameId_ ->
            bindLong(index + 1, gameId_.toLong())
            }
      }
    }

    override fun toString(): String = "RawgDatabase.sq:loadGameTags"
  }

  private inner class LoadGameScreenshotsQuery<out T : Any>(
    @JvmField
    val gameId: Collection<Int>,
    mapper: (SqlCursor) -> T
  ) : Query<T>(loadGameScreenshots, mapper) {
    override fun execute(): SqlCursor {
      val gameIdIndexes = createArguments(count = gameId.size)
      return driver.executeQuery(null, """
      |SELECT * FROM Game_Screenshot
      |WHERE Game_Screenshot.gameId IN $gameIdIndexes
      """.trimMargin(), gameId.size) {
        gameId.forEachIndexed { index, gameId_ ->
            bindLong(index + 1, gameId_.toLong())
            }
      }
    }

    override fun toString(): String = "RawgDatabase.sq:loadGameScreenshots"
  }

  private inner class LoadGameDetailQuery<out T : Any>(
    @JvmField
    val id: Int,
    mapper: (SqlCursor) -> T
  ) : Query<T>(loadGameDetail, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(321657066, """
    |SELECT * FROM GameDetail
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }

    override fun toString(): String = "RawgDatabase.sq:loadGameDetail"
  }

  private inner class LoadGameQuery<out T : Any>(
    @JvmField
    val id: Int,
    mapper: (SqlCursor) -> T
  ) : Query<T>(loadGame, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(1476404025, """
    |SELECT * FROM Game
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id.toLong())
    }

    override fun toString(): String = "RawgDatabase.sq:loadGame"
  }
}
