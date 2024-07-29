plugins {
   id("common")
   id("publish")
}

dependencies {
   api(projects.hopliteCore)
   testImplementation(projects.hopliteJson)
}
