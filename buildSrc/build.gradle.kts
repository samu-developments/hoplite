repositories {
   mavenCentral()
   gradlePluginPortal()
}

plugins {
   `kotlin-dsl`
}

dependencies {
   implementation(libs.kotlin.gradle.plugin)
   implementation(libs.kotlin.plugin.serialization)

   testImplementation(libs.kotest.assertions.core)
   testImplementation(libs.kotest.runner.junit5)
}
