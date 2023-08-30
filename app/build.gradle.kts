plugins {
    alias(libs.plugins.application)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.junit5)
}

android {
    namespace = "com.example.versioncatlogdailyupdate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.versioncatlogdailyupdate"
        minSdk = 24
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

    testImplementation(libs.test.junit.api)
    testRuntimeOnly(libs.test.junit.engine)
    testImplementation(libs.test.junit.params)
    androidTestImplementation(libs.test.core)
    androidTestImplementation(libs.test.espresso)
    androidTestImplementation(libs.test.junit.ext)
    androidTestImplementation(libs.test.rules)
    androidTestImplementation(libs.test.runner)
    androidTestImplementation(libs.test.uiautomator)

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

    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.viewmodel.savedstate)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.process)
    implementation(libs.lifecycle.service)

    implementation(libs.compose.runtime)
    implementation(libs.compose.material)
    implementation(libs.compose.foundation)
    implementation(libs.compose.preview)
    debugImplementation(libs.compose.tooling)

    implementation(libs.coroutines.android)

    implementation(libs.kotlin.stdlib)

    implementation(libs.material)

    implementation(libs.okhttp.core)
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

    implementation(libs.bugly)

    implementation(libs.glide.core)
    implementation(libs.glide.okhttp)
    ksp(libs.glide.ksp)

    implementation(libs.transformers.glide)
    implementation(libs.transformers.gpu)

    implementation(libs.moshi.core)
    ksp(libs.moshi.ksp)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.moshi)
    implementation(libs.retrofit.scalars)

    implementation(libs.room.core)
    ksp(libs.room.ksp)

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

    implementation(libs.collapsing)

    implementation(libs.shadows)
}