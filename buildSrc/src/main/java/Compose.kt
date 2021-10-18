object Compose {
    const val composeVersion = "1.1.0-alpha06"
    private const val activityComposeVersion = "1.3.0-rc01"
    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val material = "androidx.compose.material:material:$composeVersion"
    const val tooling = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val runtime = "androidx.compose.runtime:runtime-livedata:$composeVersion"
    const val activity = "androidx.activity:activity-compose:${activityComposeVersion}"
    const val livedata = "androidx.compose.runtime:runtime-livedata:$composeVersion"
    private const val navigationVersion = "2.4.0-alpha04"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0-alpha03"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"
}

object ComposeTesting {
    const val testJunit = "androidx.compose.ui:ui-test-junit4:${Compose.composeVersion}"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Compose.composeVersion}"
}

