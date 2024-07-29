plugins {
   id("common")
   id("publish")
}

dependencies {
   api(projects.hopliteCore)
   implementation(libs.kotlinx.datetime)
}


