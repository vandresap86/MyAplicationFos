package com.example.myapplication.helper

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExampleHelper {
    companion object {
        @Volatile
        private var INSTANCE: ExampleHelper? = null
        private val TAG = ExampleHelper::class.java.simpleName

        @Synchronized
        fun getInstance(): ExampleHelper = INSTANCE ?: ExampleHelper().also {
            INSTANCE = it
        }
    }
    private var volumetricListener: ((String?, Boolean) -> Unit)? = null

    fun getResponseExample(num: Int, listener: (String?, Boolean) -> Unit){
        Log.d(TAG, "getResponseExample")
        volumetricListener = listener

        if (num < 10){
            volumetricListener?.invoke("SUCCES", true)
        }else{
            volumetricListener?.invoke("ERROR", false)
        }
    }

}