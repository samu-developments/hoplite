plugins {
   id("common")
}

dependencies {
   api(projects.hopliteCore)
   implementation(libs.micrometer.registry.prometheus)
}

apply("../publish.gradle.kts")
