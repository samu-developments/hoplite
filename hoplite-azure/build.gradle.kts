plugins {
   id("common")
   id("publish")
}

dependencies {
   api(projects.hopliteCore)
   api(libs.azure.security.keyvault.secrets)
   api(libs.azure.identity)
   testApi("io.kotest.extensions:kotest-extensions-testcontainers:2.0.2")
}


