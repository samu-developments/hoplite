plugins {
   id("common")
}

dependencies {
   api(projects.hopliteCore)
   api(libs.consul.client)
}

apply("../publish.gradle.kts")
