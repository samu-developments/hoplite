plugins {
   id("common")
   kotlin("plugin.serialization")
}

dependencies {
   api(projects.hopliteCore)
   implementation(libs.snakeyaml)
}

apply("../publish.gradle.kts")
