package com.chathil.rawgapiwrapper.rawgSdk.utils

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.db.use
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList

suspend fun <T> Flow<List<T>>.flattenToList() =
    flatMapConcat { it.asFlow() }.toList()

//@JvmOverloads
//fun <T : Any> Flow<Query<T>>.mapToList(
//    context: CoroutineContext = Dispatchers.Default
//): Flow<List<T>> = map {
//    withContext(context) {
//        it.executeAsList()
//    }
//}
/**
 * @return The result set of the underlying SQL statement as a list of [RowType].
 */
//fun Query.executeAsList(): List<RowType> {
//    val result = mutableListOf<RowType>()
//    execute().use {
//        while (it.next()) result.add(mapper(it))
//    }
//    return result
//}
