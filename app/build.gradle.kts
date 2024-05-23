plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.ksp)
    alias(libs.plugins.junit5)
}

android {
    namespace = "com.example.versioncatlogdailyupdate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.versioncatlogdailyupdate"
        minSdk = 30
        targetSdk = 34
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

    packaging {

        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("kotlin/reflect/reflect.kotlin_builtins")
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.test.junit.api)
    implementation(libs.test.junit.engine)
    implementation(libs.test.junit.params)
    implementation(libs.test.core)
    implementation(libs.test.espresso)
    implementation(libs.test.junit.ext)
    implementation(libs.test.rules)
    implementation(libs.test.runner)
    implementation(libs.test.uiautomator)

    implementation(libs.accompanist.drawablepainter)
    implementation(libs.accompanist.placeholder)
    implementation(libs.accompanist.uicontroller)
    implementation(libs.accompanist.flowlayout)
    implementation(libs.accompanist.webview)

    implementation(libs.activity.core)
    implementation(libs.activity.compose)

    implementation(libs.annotation)

    implementation(libs.appcompat.core)
    implementation(libs.appcompat.resources)

    implementation(libs.core.ktx)
    implementation(libs.core.splash)

    implementation(libs.lifecycle.compose)
    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.viewmodel.savedstate)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.lifecycle.process)
    implementation(libs.lifecycle.service)

    implementation(libs.compose.runtime)
    implementation(libs.compose.material)
    implementation(libs.compose.material3)
    implementation(libs.compose.foundation)
    implementation(libs.compose.preview)
    implementation(libs.compose.ui)
    implementation(libs.compose.graphics)
    implementation(libs.compose.test.junit4)
    implementation(libs.compose.test.manifest)
    implementation(libs.compose.tooling)

    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.test)

    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.test)

    implementation(libs.ktlint)

    implementation(libs.lottie.compose)
    implementation(libs.lottie.view)

    implementation(libs.material)

    implementation(libs.okhttp.core)
    implementation(libs.okhttp.logging)
    implementation(libs.okhttp.mockwebserver)

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

    implementation(libs.bugly)

    implementation(libs.glide.core)
    implementation(libs.glide.okhttp)
    implementation(libs.glide.ksp)
    implementation(libs.glide.avif)

    implementation(libs.transformers.core)
    implementation(libs.transformers.glide)
    implementation(libs.transformers.gpu)

    implementation(libs.moshi.core)
    implementation(libs.moshi.ksp)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.moshi)
    implementation(libs.retrofit.scalars)

    implementation(libs.room.core)
    implementation(libs.room.ksp)

    implementation(libs.stetho.core)
    implementation(libs.stetho.okhttp)

    implementation(libs.landscapist.glide)
    implementation(libs.landscapist.placeholder)
    implementation(libs.landscapist.animation)
    implementation(libs.landscapist.transformation)
    implementation(libs.landscapist.palette)

    implementation(libs.selector.core)
    implementation(libs.selector.compress)
    implementation(libs.selector.crop)
    implementation(libs.selector.camerax)

    implementation(libs.flow.binding.core)
    implementation(libs.flow.binding.activity)
    implementation(libs.flow.binding.android)
    implementation(libs.flow.binding.appcompat)
    implementation(libs.flow.binding.drawerlayout)
    implementation(libs.flow.binding.lifecycle)
    implementation(libs.flow.binding.material)
    implementation(libs.flow.binding.navigation)
    implementation(libs.flow.binding.preference)
    implementation(libs.flow.binding.recyclerview)
    implementation(libs.flow.binding.swiperefreshlayout)
    implementation(libs.flow.binding.viewpager)
    implementation(libs.flow.binding.viewpager2)

    implementation(libs.immutable.collections)

    implementation(libs.update)

    implementation(libs.wechat)

    implementation(libs.alipay)

    implementation(libs.telephoto.zoomable)
    implementation(libs.telephoto.coil)
    implementation(libs.telephoto.glide)
    implementation(libs.telephoto.sampling)

    implementation(libs.slider)

    implementation(libs.richtext)

    implementation(libs.exif)

    implementation(libs.collapsing.scaffold)

    implementation(libs.shadows)

    implementation(libs.flowmvi.core)
    implementation(libs.flowmvi.compose)
    implementation(libs.flowmvi.android)
    implementation(libs.flowmvi.view)

    implementation(libs.fragment.core)
    implementation(libs.fragment.test)

    implementation(libs.android.utils)

    implementation(libs.chucker)

    implementation(libs.constraint.compose)
    implementation(libs.constraint.layout)

    implementation(libs.sampling.image)

    implementation(libs.work.core)
    implementation(libs.work.ktx)
    implementation(libs.work.process)

    implementation(libs.dolly)

    implementation(libs.player.video.core)
    implementation(libs.player.video.exo)
    implementation(libs.player.video.arm64)
    implementation(libs.player.video.armv7a)

    implementation(libs.okdownload.core)
    implementation(libs.okdownload.sqlite)
    implementation(libs.okdownload.okhttp)
    implementation(libs.okdownload.ktx)

    implementation(libs.fastjson)

    implementation(libs.swipebox)

    implementation(libs.drive.obs)
    implementation(libs.drive.oss)

    implementation(libs.bottomsheet)

    implementation(libs.haze)

    implementation(libs.voyager.core)
    implementation(libs.voyager.model)
    implementation(libs.voyager.bottom)
    implementation(libs.voyager.tab)
    implementation(libs.voyager.koin)
    implementation(libs.voyager.transition)

    implementation(libs.zoomimage)

    implementation(libs.webview.compose)
    implementation(libs.webview.agent)
    implementation(libs.webview.x5)
}