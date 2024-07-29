import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

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
      url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
   }
   maven {
      url = uri("https://plugins.gradle.org/m2/")
   }
}

group = "com.sksamuel.hoplite"
version = Ci.version

dependencies {
   testImplementation("io.kotest:kotest-assertions-core:5.5.5")
   testImplementation("io.kotest:kotest-runner-junit5:5.5.5")
}

tasks.named<Test>("test") {
   useJUnitPlatform()
   testLogging {
      showExceptions = true
      showStandardStreams = true
      exceptionFormat = TestExceptionFormat.FULL
   }
}

kotlin {
   jvmToolchain(11)
   compilerOptions.jvmTarget = JvmTarget.JVM_1_8
}

tasks.compileJava {
   options.release = 8
}

tasks.compileTestKotlin {
   compilerOptions.jvmTarget = JvmTarget.JVM_11
}

tasks.compileTestJava {
   options.release = 11
}
