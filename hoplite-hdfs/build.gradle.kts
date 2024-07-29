plugins {
   id("common")
}

dependencies {
    api(projects.hopliteCore)
    api(libs.hadoop.common)
}

apply("../publish.gradle.kts")
