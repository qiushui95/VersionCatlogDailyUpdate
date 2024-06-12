
plugins {
    alias(libs.plugins.catalogUpdate)
    alias(libs.plugins.gradleVersions)
    alias(libs.plugins.maven)
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.android.junit5) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.gradlePlugin.android)
        classpath(libs.gradlePlugin.kotlin)
    }
}
