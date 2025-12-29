plugins {
    id("com.android.application")
}

android {
    namespace = "com.mugibow.watchface"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mugibow.watchface"
        // minSdk 33 = WFF v1, minSdk 34 = WFF v2
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        debug {
            isMinifyEnabled = true
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

// WFF is resource-only format, no dependencies required
