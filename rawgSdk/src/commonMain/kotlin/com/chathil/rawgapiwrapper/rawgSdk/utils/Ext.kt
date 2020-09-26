package com.chathil.rawgapiwrapper.rawgSdk.utils

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.db.use
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList


internal fun <T> Set<T>.toRequestParam() =
    this.toString().replace(" ", "").subSequence(1, this.toString().lastIndex - 1)

