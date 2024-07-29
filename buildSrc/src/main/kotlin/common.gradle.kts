import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
   kotlin("jvm")
   `java-library`
   `maven-publish`
   signing
}

repositories {
   mavenLocal()
   mavenCentral()
   maven {
      url = uri("https://oss.sonatype.org/content/repositories/snapshots")
   }
}

group = "com.sksamuel.hoplite"
version = Ci.version

dependencies {
   testImplementation("io.kotest:kotest-assertions-core")
   testImplementation("io.kotest:kotest-runner-junit5")
}

tasks.named<Test>("test") {
   useJUnitPlatform()
   testLogging {
      showExceptions = true
      showStandardStreams = true
      exceptionFormat = TestExceptionFormat.FULL
   }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
   kotlinOptions.jvmTarget = "1.8"
}

java {
   toolchain {
      languageVersion.set(JavaLanguageVersion.of(11))
   }
}

tasks.compileJava {
   targetCompatibility = "1.8"
   sourceCompatibility = "1.8"
}
