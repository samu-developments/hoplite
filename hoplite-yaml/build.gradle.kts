plugins {
   id("common")
   id("publish")
   kotlin("plugin.serialization")
}

dependencies {
   api(projects.hopliteCore)
   implementation(libs.snakeyaml)
}
