plugins {
   id("common")
   id("publish")
}

dependencies {
   api(projects.hopliteCore)
   implementation(libs.jackson.core)
   implementation(libs.jackson.databind)
}


