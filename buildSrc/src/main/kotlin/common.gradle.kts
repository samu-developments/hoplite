import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
   kotlin("jvm")
   `java-library`
}

repositories {
   mavenLocal()
   mavenCentral()
   maven {
      url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
   }
}

group = "com.sksamuel.hoplite"
version = Ci.version

val libs = versionCatalogs.named("libs")

dependencies {
   testImplementation(libs.findLibrary("kotest.assertions.core").get())
   testImplementation(libs.findLibrary("kotest.runner.junit5").get())
}

tasks.test {
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
