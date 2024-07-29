plugins {
   id("common")
   id("publish")
}

dependencies {
   api(projects.hopliteCore)
   implementation(libs.spring.vault.core)
   testApi("io.kotest.extensions:kotest-extensions-testcontainers:2.0.2")
   testApi(libs.testcontainers.vault)
}


