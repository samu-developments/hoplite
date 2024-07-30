plugins {
   id("common")
   id("publish")
}

dependencies {
   api(projects.hopliteCore)
   api(libs.cron.utils)
}
