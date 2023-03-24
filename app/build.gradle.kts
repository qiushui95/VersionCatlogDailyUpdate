plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.versioncatlogdailyupdate"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.versioncatlogdailyupdate"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.accompanist.drawablepainter)
    implementation(libs.accompanist.placeholder)
    implementation(libs.accompanist.uicontroller)

    implementation(libs.activity.core)
    implementation(libs.activity.compose)

    implementation(libs.annotation)

    implementation(libs.appcompat.core)
    implementation(libs.appcompat.resources)

    implementation(libs.core)
    implementation(libs.core.splash)

    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.viewmodel.savedstate)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.process)
    implementation(libs.lifecycle.service)

    implementation(libs.compose.material)
    implementation(libs.compose.foundation)
    implementation(libs.compose.tooling)

    implementation(libs.coroutines.android)

    implementation(libs.kotlin.stdlib)

    implementation(libs.material)

    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    implementation(libs.mvi.core)
    implementation(libs.mvi.vm)
    implementation(libs.mvi.compose)

    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)

    implementation(libs.initializer)

    implementation(libs.jodatime)

    implementation(libs.leakcanary)

    implementation(libs.mmkv)

    implementation(libs.xcrash)

    implementation(libs.xpopup)

    implementation(libs.permission)

    implementation(libs.zip4j)

    implementation(libs.bugly)

    implementation(libs.glide.core)
    implementation(libs.glide.compose)
    implementation(libs.glide.okhttp)
    implementation(libs.glide.svg)
    ksp(libs.glide.ksp)

    implementation(libs.moshi.core)
    ksp(libs.moshi.ksp)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.moshi)
    implementation(libs.retrofit.scalars)

    implementation(libs.room.core)
    ksp(libs.room.ksp)

    implementation(libs.stetho)
    implementation(libs.stetho.okhttp)

    implementation(libs.transformers.glide)
    implementation(libs.transformers.gpu)

    implementation(libs.landscapist.glide)
    implementation(libs.landscapist.placeholder)
    implementation(libs.landscapist.animation)
    implementation(libs.landscapist.transformation)
    implementation(libs.landscapist.palette)

    implementation(libs.compose.destinations.core)
    ksp(libs.compose.destinations.ksp)
}