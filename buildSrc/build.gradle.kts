plugins {
   `kotlin-dsl`
}

repositories {
   mavenCentral()
   gradlePluginPortal()
}

dependencies {
   implementation(libs.kotlin.gradle.plugin)
   implementation(libs.kotlin.plugin.serialization)
}
