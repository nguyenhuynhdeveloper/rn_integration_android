package com.rn_view

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import android.app.Activity

class NavigationModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName(): String {
        return "NavigationModule"
    }

    @ReactMethod
    fun goBack() {
        val activity = currentActivity
        activity?.finish()
    }
} 