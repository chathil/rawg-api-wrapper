package com.chathil.rawgapiwrapper.androidApp

import android.os.Bundle
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import androidx.ui.tooling.preview.Preview
import com.chathil.rawgapiwrapper.androidApp.ui.RawgWrapperTheme

import com.chathil.rawgapiwrapper.rawgSdk.RawgSDK
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import com.chathil.rawgapiwrapper.rawgSdk.models.Game

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

// TODO this is just a bad example to find out if the sdk works.
// should be updated to show compose best practices.
class MainActivity : FragmentActivity() {
    private val mainScope = MainScope()
    private val sdk = RawgSDK(DatabaseDriverFactory(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RawgWrapperTheme {
                HomeScreen()
            }
        }
    }

    @Composable
    private fun HomeScreen() {
        var games: List<Game> by remember {
            mutableStateOf(
                listOf()
            )
        }
        onActive {
            mainScope.launch {
                sdk.paginatedGamesByParentPlatforms(setOf(1, 2)).init().collect {
                    if (games.isNullOrEmpty()) {
                        games = games + (it.data ?: emptyList())
                    }
                }
            }
        }
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumnForIndexed(items = games) { index, item ->
                if (index == games.size - 5) {
                    onActive {
                        item.next?.let { page ->
                            mainScope.launch {
                                sdk.paginatedGamesByParentPlatforms(setOf(1, 2)).next(page).collect {
                                    if (!games.containsAll(it.data ?: emptyList()))
                                        games = games + (it.data ?: emptyList())
                                }
                            }
                        }
                    }
                }
                Text("${item.next} ${item.id} ${item.name}", modifier = Modifier.padding(vertical = 16.dp))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RawgWrapperTheme {
        Greeting("Android")
    }
}
