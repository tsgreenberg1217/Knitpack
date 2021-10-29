plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

android {
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {

        }

        release {
            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "$project.rootDir/tools/proguard-rules.pro"
//            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }
    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.theme))
    implementation(project(Modules.components))
    implementation(project(Modules.mainPage))
    implementation(project(Modules.createPage))

    implementation(Google.material)

    kapt(Hilt.hiltCompliler)
    implementation(Hilt.hiltAndroid)

    implementation(AndroidX.core)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.core)
    implementation(AndroidX.fragment)
    implementation(AndroidX.lifecycleExt)
    implementation(AndroidX.lifecycleRT)
    implementation(Compose.activity)

    implementation(Compose.hiltNavigation)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.preview)
    androidTestImplementation(ComposeTesting.testJunit)
    debugImplementation(Compose.tooling)
    implementation(Compose.livedata)
    implementation(Compose.viewModels)

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

}