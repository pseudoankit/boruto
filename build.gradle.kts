buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.9.0")
    }
}
plugins {
    id("com.android.application") version "8.2.0-beta06" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}