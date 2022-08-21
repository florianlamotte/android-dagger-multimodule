// Enable feature preview
enableFeaturePreview("VERSION_CATALOGS") // Version catalogs

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

// Version catalogs
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    // dependency catalog
    versionCatalogs {
        create("core") {
            // DEPENDENCIES
            // Compose
            version("composeVersion", "1.2.1")
            alias("compose.ui").to("androidx.compose.ui", "ui").versionRef("composeVersion")
            alias("compose.material").to("androidx.compose.material", "material").versionRef("composeVersion")
            alias("compose.preview").to("androidx.compose.ui", "ui-tooling-preview").versionRef("composeVersion")
            alias("compose.viewbinding").to("androidx.compose.ui", "ui-viewbinding").versionRef("composeVersion")
            bundle(
                "compose",
                listOf(
                    "compose.ui",
                    "compose.material",
                    "compose.preview",
                    "compose.viewbinding"
                )
            )

            // Compose - debug tools
            alias("compose.debug.tooling").to("androidx.compose.ui", "ui-tooling").versionRef("composeVersion")
            alias("compose.debug.manifest").to("androidx.compose.ui", "ui-test-manifest").versionRef("composeVersion")
            bundle("compose.debug", listOf("compose.debug.tooling", "compose.debug.manifest"))

            // Coroutines
            version("coroutineVersion", "1.6.0")
            alias("coroutine.core").to("org.jetbrains.kotlinx","kotlinx-coroutines-core").versionRef("coroutineVersion")
            alias("coroutine.android").to("org.jetbrains.kotlinx","kotlinx-coroutines-android").versionRef("coroutineVersion")
            bundle("coroutine",
                listOf(
                    "coroutine.core",
                    "coroutine.android",
                    "lifecycle.viewmodel"
                )
            )

            // Dagger
            version("daggerVersion", "2.42")
            alias("dagger.core").to("com.google.dagger", "dagger").versionRef("daggerVersion")
            alias("dagger.android").to("com.google.dagger", "dagger-android").versionRef("daggerVersion")
            alias("dagger.android.support").to("com.google.dagger", "dagger-android-support").versionRef("daggerVersion")
            bundle("dagger", listOf("dagger.core", "dagger.android", "dagger.android.support"))

            alias("dagger.annotations.compiler").to("com.google.dagger", "dagger-compiler").versionRef("daggerVersion")
            bundle("dagger.annotations", listOf("dagger.annotations.compiler"))

            // Lifecycle
            version("androidLifecycleVersion", "2.2.0")
            alias("lifecycle.viewmodel").to("androidx.lifecycle", "lifecycle-viewmodel-ktx").versionRef("androidLifecycleVersion")
        }
    }
}
rootProject.name = "DaggerMultimodule"
include(":app")
include(":domain:user")
include(":data:userrepository")
include(":UserAgeDynamicModule")
include(":feature:usersex")
include(":feature:standard:theme")
