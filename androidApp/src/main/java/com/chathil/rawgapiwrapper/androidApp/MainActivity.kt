package com.chathil.rawgapiwrapper.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.chathil.rawgapiwrapper.rawgSdk.RawgSDK
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import com.chathil.rawgapiwrapper.rawgSdk.network.GameListRequestConfig
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()

    private val sdk = RawgSDK(DatabaseDriverFactory(this))

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainScope.launch {
            val res = sdk.getGames(true, GameListRequestConfig())
            Log.d(TAG, "onCreate: ${res.toString()}")
//            Log.d(TAG, "onCreate: Ratings :${res.rat} ")
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
