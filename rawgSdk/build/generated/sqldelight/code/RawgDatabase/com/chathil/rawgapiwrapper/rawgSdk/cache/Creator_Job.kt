package com.chathil.rawgapiwrapper.rawgSdk.cache

import kotlin.Int
import kotlin.String

data class Creator_Job(
  val creatorId: Int,
  val jobId: Int
) {
  override fun toString(): String = """
  |Creator_Job [
  |  creatorId: $creatorId
  |  jobId: $jobId
  |]
  """.trimMargin()
}
