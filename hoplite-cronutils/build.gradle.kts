plugins {
   id("common")
}

dependencies {
   api(projects.hopliteCore)
   api(libs.cron.utils)
}

apply("../publish.gradle.kts")
