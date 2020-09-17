package com.chathil.rawgapiwrapper.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.chathil.rawgapiwrapper.rawgSdk.RawgSDK
import com.chathil.rawgapiwrapper.rawgSdk.cache.DatabaseDriverFactory
import com.chathil.rawgapiwrapper.rawgSdk.utils.flattenToList
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
            val res = sdk.getLaunches(false)
            Log.d(TAG, "onCreate: $res")
            Log.d(TAG, "onCreate: Ratings :${res[0].ratings()} ")
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
