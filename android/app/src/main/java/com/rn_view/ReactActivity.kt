

 // Cách 1: load file index ở Application
 package com.rn_view

 import android.os.Bundle
 import com.facebook.react.ReactActivity
 import com.facebook.react.ReactActivityDelegate
 import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.fabricEnabled
 import com.facebook.react.defaults.DefaultReactActivityDelegate
 //import com.zoontek.rnbootsplash.RNBootSplash

 class MyReactActivity : ReactActivity() {

     /**
      * Returns the name of the main component registered from JavaScript. This is used to schedule
      * rendering of the component.
      */
     override fun getMainComponentName(): String = "rn_view"

     override fun onCreate(savedInstanceState: Bundle?) {
 //        RNBootSplash.init(this, R.style.BootTheme) // ⬅️ initialize the splash screen
         super.onCreate(savedInstanceState) // super.onCreate(null) with react-native-screens
     }

     /**
      * Returns the instance of the [ReactActivityDelegate]. We use [DefaultReactActivityDelegate]
      * which allows you to enable New Architecture with a single boolean flags [fabricEnabled]
      */
     override fun createReactActivityDelegate(): ReactActivityDelegate =
         DefaultReactActivityDelegate(this, mainComponentName, fabricEnabled)
 }


// ////  Cách 2: Load file index ở Activity
////// Sẽ bị lỗi : com.facebook.react.uimanager.IllegalViewOperationException: No ViewManager found for class RNSVGPath
//// package <your-package-here>
// package com.rn_view
//
// import android.os.Bundle
// import com.facebook.react.ReactActivity
// import com.facebook.react.ReactActivityDelegate
// import com.facebook.react.ReactInstanceManager
// import com.facebook.react.ReactRootView
// import com.facebook.react.common.LifecycleState
// import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.fabricEnabled
// import com.facebook.react.defaults.DefaultReactActivityDelegate
// import com.facebook.react.shell.MainReactPackage
//
// class MyReactActivity : ReactActivity() {
//
//     // Thêm đoạn này để chạy được từ file bundle
//     private lateinit var mReactRootView: ReactRootView
//     private lateinit var mReactInstanceManager: ReactInstanceManager
//
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         // Enable loading from assets
////         reactNativeHost.useDeveloperSupport = false
//         mReactRootView = ReactRootView(this)
//
//         mReactInstanceManager = ReactInstanceManager.builder()
//             .setApplication(application)
//             .setCurrentActivity(this)
//             .setBundleAssetName("index.android.bundle") // file bundle tĩnh
//             .setJSMainModulePath("index") // không dùng nếu đã có bundle
//             .addPackage(MainReactPackage())
//             .setUseDeveloperSupport(false)
//             .setInitialLifecycleState(LifecycleState.RESUMED)
//
//             .build()
//
//         mReactRootView.startReactApplication(
//             mReactInstanceManager,
//             "rn_view", // tên app như đã đăng ký trong index.js
//             null
//         )
//
//         setContentView(mReactRootView)
//
//     }
//     // ----- end -----
//
//     // Nếu không có đoạn chỉ định file bundle trên chỉ có đoạn dứới thì sẽ chạy code js thường
//     override fun getMainComponentName(): String = "rn_view"
//
//     override fun createReactActivityDelegate(): ReactActivityDelegate =
//         DefaultReactActivityDelegate(this, mainComponentName, fabricEnabled)
// }