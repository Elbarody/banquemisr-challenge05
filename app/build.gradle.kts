plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.kapt)

}

android {
    namespace = "com.banquemisr.challenge05"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.banquemisr.challenge05"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "TMDB_API_KEY",
                "\"${project.property("TMDB_API_KEY")}\""
            )
        }
        release {
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

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Dependency Injection
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    testImplementation(libs.koin.test)


    // retrofit
    implementation(libs.converter.gson)
    implementation(libs.retrofit2.retrofit)
    implementation(libs.grpc.okhttp)

    //OKHTTP
    implementation(libs.okhttp3.okhttp)
    implementation(libs.okhttp3.logging)

    //Compose ui
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.foundation)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.constraintlayout.compose)
    implementation(libs.coil.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)

    //paging
    implementation(libs.androidx.paging)
    implementation(libs.androidx.paging.compose)

    //room
    implementation(libs.androidx.room)
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    kapt(libs.androidx.room.compiler)
    implementation("androidx.room:room-paging:2.6.1")

    testImplementation("androidx.arch.core:core-testing:2.1.0")

    //mock
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mockk)
    androidTestImplementation(libs.mockito.core)
    androidTestImplementation(libs.mockito.kotlin)
    androidTestImplementation(libs.mockk)
}
