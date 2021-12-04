plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    id ("kotlin-kapt")
    id ("androidx.navigation.safeargs.kotlin")
    kotlin("plugin.serialization")
    id ("dagger.hilt.android.plugin")
}

val composeVersion = "1.0.5"
val composeVersionBeta = "1.0.0-beta09"
val retrofitVersion = "2.9.0"
val kotlinCoroutineVersion = "1.4.2"
val  lifecycleVersion = "2.2.0"
val hiltVersion = "2.40"

dependencies {

    //Compose
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation ("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation ("androidx.compose.material:material:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    implementation ("androidx.compose.ui:ui-tooling:$composeVersionBeta")
    implementation("androidx.compose.ui:ui:1.0.5")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.0.5")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:1.0.5")
    // Material Design
    implementation("androidx.compose.material:material:1.0.5")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:1.0.5")
    implementation("androidx.compose.material:material-icons-extended:1.0.5")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:1.0.5")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.0.5")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.5")
   //preview
//    debugImplementation ("androidx.compose.ui:ui-tooling:$composeVersionBeta")
//    implementation ("androidx.compose.ui:ui-tooling-preview:$composeVersion")


    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutineVersion")
    implementation("androidx.compose.ui:ui:1.1.0-beta04")

    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinCoroutineVersion")

    implementation("io.ktor:ktor-client-okhttp:1.6.0")
    implementation("io.ktor:ktor-client-json:1.6.0")
    implementation("io.ktor:ktor-client-logging:1.6.0")
    implementation("io.ktor:ktor-client-serialization:1.6.0")

    // Kotlinx Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.2.1")

    //Hilt
    implementation ("com.google.dagger:hilt-android:2.40")
    kapt ("com.google.dagger:hilt-android-compiler:2.40")
    implementation ("androidx.hilt:hilt-common:1.0.0")
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    // When using Kotlin.
    kapt ("androidx.hilt:hilt-compiler:1.0.0")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.3.0")

    implementation ("androidx.fragment:fragment-ktx:1.3.0")

    implementation ("com.squareup.okhttp3:okhttp:4.9.2")


    implementation ("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation ("androidx.recyclerview:recyclerview:1.0.0")
    implementation ("com.google.android.material:material:1.0.0")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.0.0")
    implementation ("androidx.ui:ui-framework:0.1.0-dev03")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    // define a BOM and its version
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.0"))

    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")

}

android {
    compileSdk = 31
    buildToolsVersion = "30.0.3"
    defaultConfig {
        applicationId = "com.camachoyury.tshirtstore.android"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }

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
        useIR = true
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
kapt {
    correctErrorTypes = true
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = listOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check",
            "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
        )
    }
}


