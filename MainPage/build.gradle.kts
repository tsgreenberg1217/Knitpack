apply {
    from("$rootDir/${Android.androidLibrary}")
}

plugins {
    id("dagger.hilt.android.plugin")
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

dependencies {
    "implementation"(project(Modules.components))
    "implementation"(Google.material)
    "kapt"(Hilt.hiltCompliler)
    "implementation"(Hilt.hiltAndroid)
}