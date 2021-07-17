buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
        classpath ("com.android.tools.build:gradle:7.1.0-alpha03")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.5.0")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.2")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.37")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}