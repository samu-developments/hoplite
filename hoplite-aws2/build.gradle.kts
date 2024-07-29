plugins {
   id("common")
   kotlin("plugin.serialization")
}

dependencies {
   api(projects.hopliteCore)
   api(libs.regions)
   api(libs.secretsmanager)
   implementation(libs.kotlinx.serialization.json)
}

apply("../publish.gradle.kts")
