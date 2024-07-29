plugins {
   id("common")
   id("publish")
}

dependencies {
   api(projects.hopliteCore)
   api(libs.hikaricp)

   testImplementation(projects.hopliteYaml)
   testImplementation(libs.postgresql)
}


