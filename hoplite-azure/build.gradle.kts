plugins {
   id("common")
   id("publish")
}

dependencies {
   api(projects.hopliteCore)
   api(libs.azure.security.keyvault.secrets)
   api(libs.azure.identity)
   testApi(libs.kotest.extensions.testcontainers)
}


