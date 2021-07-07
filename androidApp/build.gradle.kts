plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    id ("androidx.navigation.safeargs.kotlin")
}

val composeVersion = "1.0.0-rc01"

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
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

//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
//    kotlinOptions {
//        jvmTarget = JavaVersion.VERSION_1_8.toString()
//        freeCompilerArgs = listOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check",
//            "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
//        )
//    }
//}
