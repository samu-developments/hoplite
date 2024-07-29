plugins {
   id("common")
   id("publish")
}

dependencies {
   api(projects.hopliteCore)
   api(libs.google.cloud.secretmanager)
   testApi(libs.kotest.extensions.testcontainers)
}


