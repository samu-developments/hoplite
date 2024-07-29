plugins {
   id("common")
}

dependencies {
   api(projects.hopliteCore)
   implementation(libs.typesafe.config)
}

apply("../publish.gradle.kts")
