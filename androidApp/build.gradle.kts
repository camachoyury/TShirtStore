plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    id ("kotlin-kapt")
    id ("androidx.navigation.safeargs.kotlin")
    kotlin("plugin.serialization")
    id ("dagger.hilt.android.plugin")
}

val composeVersion = "1.0.0-rc01"
val retrofitVersion = "2.9.0"
val kotlinCoroutineVersion = "1.4.2"
val  lifecycleVersion = "2.2.0"
val hiltVersion = "2.37"

dependencies {
    //Compose
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation ("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation ("androidx.compose.material:material:$composeVersion")
    implementation ("androidx.compose.ui:ui-tooling:$composeVersion")

    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutineVersion")
    implementation("androidx.compose.ui:ui:1.0.0-beta09")

    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinCoroutineVersion")

    implementation("io.ktor:ktor-client-okhttp:1.6.0")
    implementation("io.ktor:ktor-client-json:1.6.0")
    implementation("io.ktor:ktor-client-logging:1.6.0")
    implementation("io.ktor:ktor-client-serialization:1.6.0")

    // Kotlinx Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.2.1")

    //Hilt
    implementation ("com.google.dagger:hilt-android:$hiltVersion")
    kapt ("com.google.dagger:hilt-android-compiler:$hiltVersion")
    implementation ("androidx.hilt:hilt-common:1.0.0-alpha03")
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    // When using Kotlin.
    kapt ("androidx.hilt:hilt-compiler:1.0.0-alpha03")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.3.0")

    implementation ("androidx.fragment:fragment-ktx:1.3.0")

    implementation ("com.squareup.okhttp3:okhttp:4.9.0")

    implementation ("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation ("androidx.recyclerview:recyclerview:1.0.0")
    implementation ("com.google.android.material:material:1.0.0")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.0.0")
    implementation ("androidx.ui:ui-framework:0.1.0-dev03")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.camachoyury.tshirtstore.android"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
        kotlinCompilerVersion = "1.5.10"

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}
kapt {
    correctErrorTypes = true
}
//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
//    kotlinOptions {
//        jvmTarget = JavaVersion.VERSION_1_8.toString()
//        freeCompilerArgs = listOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check",
//            "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
//        )
//    }
//}
