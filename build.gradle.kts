
plugins {
    alias(libs.plugins.catalogUpdate)
    alias(libs.plugins.gradleVersions)
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
