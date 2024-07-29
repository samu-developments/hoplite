plugins {
   id("common")
   id("publish")
}

dependencies {
   api(projects.hopliteCore)
   testImplementation(projects.hopliteToml)
   testImplementation(projects.hopliteYaml)
   testImplementation(projects.hopliteJson)
   implementation(libs.vavr.kotlin)
}


