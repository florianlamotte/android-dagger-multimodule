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
            bundle("compose", listOf("compose.ui", "compose.material", "compose.preview"))

            // Coroutines
            version("coroutineVersion", "1.6.0")
            alias("coroutine.core").to("org.jetbrains.kotlinx","kotlinx-coroutines-core").versionRef("coroutineVersion")
            alias("coroutine.android").to("org.jetbrains.kotlinx","kotlinx-coroutines-android").versionRef("coroutineVersion")
            bundle("coroutine", listOf("coroutine.core", "coroutine.android"))

            // Dagger
            version("daggerVersion", "2.40")
            alias("dagger.core").to("com.google.dagger", "dagger").versionRef("daggerVersion")
            alias("dagger.android").to("com.google.dagger", "dagger-android").versionRef("daggerVersion")
            alias("dagger.android.support").to("com.google.dagger", "dagger-android-support").versionRef("daggerVersion")
            bundle("dagger", listOf("dagger.core", "dagger.android", "dagger.android.support"))

            alias("dagger.annotations.compiler").to("com.google.dagger", "dagger-compiler").versionRef("daggerVersion")
            bundle("dagger.annotations", listOf("dagger.annotations.compiler"))
        }
    }
}
rootProject.name = "DaggerMultimodule"
include(":app")
include(":domain:user")
