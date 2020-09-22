package com.chathil.rawgapiwrapper.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.chathil.rawgapiwrapper.rawgSdk.RawgSDK
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()

    private val sdk = RawgSDK(DatabaseDriverFactory(this))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainScope.launch {
            sdk.gamesByPlatform(setOf(4, 187)).collect {
                Log.d(TAG, "onCreate: $it")
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
