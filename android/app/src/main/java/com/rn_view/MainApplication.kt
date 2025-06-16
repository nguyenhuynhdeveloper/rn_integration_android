package com.rn_view

import android.app.Application
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactHost
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.load
import com.facebook.react.defaults.DefaultReactHost.getDefaultReactHost
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.react.soloader.OpenSourceMergedSoMapping  // react 19.0.0 react-native: 0.78.0 cần bắt buộc phải mở bằng soloader
import com.facebook.soloader.SoLoader

class MainApplication : Application(), ReactApplication {

    override val reactNativeHost: ReactNativeHost =
        object : DefaultReactNativeHost(this) {
            override fun getPackages(): List<ReactPackage> =
                PackageList(this).packages.apply {
                    // Packages that cannot be autolinked yet can be added manually here, for example:
                    // add(MyReactNativePackage())
                    add(NavigationPackage())
                }

            override fun getJSMainModuleName(): String = "index"

            // override fun getJSBundleFile(): String {
            //     return "assets://index.android.bundle"
            // }

            // Load file bundle ở ngay Application luôn - chứ không load ở Activity
            override fun getJSBundleFile(): String {
                return "assets://index.android.bundle"
            }

            override fun getUseDeveloperSupport(): Boolean = false;

            override val isNewArchEnabled: Boolean = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
            override val isHermesEnabled: Boolean = BuildConfig.IS_HERMES_ENABLED
        }

//     fun isNewArchitectureEnabled(): Boolean {
//        return BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
//    }
//    override fun getReactNativeHost(): ReactNativeHost = reactNativeHost

    override val reactHost: ReactHost
        get() = getDefaultReactHost(applicationContext, reactNativeHost)

    override fun onCreate() {
        super.onCreate()
       SoLoader.init(this, OpenSourceMergedSoMapping)
//        SoLoader.init(this, false);
        if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
            // Bắt buộc: khởi tạo TurboModules
//            ReactNativeFlipper.initializeFlipper(this, reactNativeHost.reactInstanceManager);
            // If you opted-in for the New Architecture, we load the native entry point for this app.
            load()
        }
    }
}
