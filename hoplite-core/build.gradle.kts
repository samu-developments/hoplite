plugins {
   id("common")
   id("publish")
}

dependencies {
   api(libs.kotlin.reflect)
   api(libs.coroutines.core)
   api(libs.coroutines.jdk8)
   testImplementation(libs.postgresql)
   testImplementation(libs.kotest.extensions.testcontainers)
   testImplementation(libs.testcontainers)
   testImplementation(libs.testcontainers.postgresql)
}
