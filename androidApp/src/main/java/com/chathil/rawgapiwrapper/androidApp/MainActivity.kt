package com.chathil.rawgapiwrapper.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.chathil.rawgapiwrapper.rawgSdk.RawgSDK
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import com.chathil.rawgapiwrapper.rawgSdk.network.GameRequestConfig
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
            sdk.getGames(search = "GTA", config = GameRequestConfig(order = GameRequestConfig.Order.NAME_ASC)).collect{
                Log.d(TAG, "onCreate: $it")
            }
//            val res = sdk.getGames(true, mapOf())
//            Log.d(TAG, "onCreate: $res")
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
