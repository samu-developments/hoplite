plugins {
   id("common")
   id("publish")
   kotlin("plugin.serialization")
}

dependencies {
   api(projects.hopliteCore)
   api(libs.regions)
   api(libs.secretsmanager)
   implementation(libs.kotlinx.serialization.json)
}


