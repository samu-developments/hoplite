plugins {
   id("common")
   id("publish")
}

dependencies {
   api(projects.hopliteCore)
//   implementation(KotlinX.coroutines.core)
   testImplementation(projects.hopliteJson)
}


