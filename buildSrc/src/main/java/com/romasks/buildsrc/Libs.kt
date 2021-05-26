package com.romasks.buildsrc

object Libs {

    object Android {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.Android.APP_COMPAT}"
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.Android.CORE_KTX}"
        const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Android.KOTLIN_VERSION}"
        const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Android.KOTLIN_VERSION}"
        const val LIFECYCLE_LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Android.LIFECYCLE_LIVE_DATA}"
        const val TOOLS_BUILD_GRADLE = "com.android.tools.build:gradle:${Versions.Android.TOOLS_BUILD_GRADLE}"
    }

    object DB {
        const val ROOM = "androidx.room:room-runtime:${Versions.Database.ROOM}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.Database.ROOM}"
        const val ROOM_EXTENSIONS = "androidx.room:room-ktx:${Versions.Database.ROOM}"
    }

    object DI {
        const val KOIN_ANDROID = "org.koin:koin-android:${Versions.DI.KOIN}"
        const val KOIN_ANDROID_SCOPE = "org.koin:koin-android-scope:${Versions.DI.KOIN}"
        const val KOIN_ANDROID_VIEWMODEL = "org.koin:koin-android-viewmodel:${Versions.DI.KOIN}"
        const val KOIN_GRADLE_PLUGIN = "org.koin:koin-gradle-plugin:${Versions.DI.KOIN}"
    }

    object Navigation {
        const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.Navigation.NAVIGATION}"
        const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.Navigation.NAVIGATION}"
        const val NAVIGATION_SAVE_ARGS = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Navigation.NAVIGATION}"
    }

    object Testing {
        const val CORE = "androidx.arch.core:core-testing:${Versions.Testing.CORE}"
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Android.KOTLIN_VERSION}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.Testing.ESPRESSO}"
        const val JUNIT = "junit:junit:${Versions.Testing.JUNIT}"
        const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.Testing.JUNIT_EXT}"
        const val MOCKITO = "org.mockito:mockito-core:${Versions.Testing.MOCKITO}"
        const val ROOM_TESTING = "androidx.room:room-testing:${Versions.Database.ROOM}"
        const val TRUTH = "com.google.truth:truth:${Versions.Testing.TRUTH}"
    }

    object UI {
        const val CARD_VIEW = "androidx.cardview:cardview:${Versions.UI.CARD_VIEW}"
        const val COIL = "io.coil-kt:coil:${Versions.UI.COIL}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.UI.CONSTRAINT_LAYOUT}"
        const val LOTTIE = "com.airbnb.android:lottie:${Versions.UI.LOTTIE}"
        const val MATERIAL = "com.google.android.material:material:${Versions.UI.MATERIAL}"
        const val ZXING = "com.journeyapps:zxing-android-embedded:${Versions.UI.ZXING}"
    }
}