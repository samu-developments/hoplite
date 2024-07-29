plugins {
   id("common")
   id("publish")
}

dependencies {
    api(projects.hopliteCore)
    api(libs.hadoop.common)
}


