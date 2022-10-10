import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.7.3"
  id("io.spring.dependency-management") version "1.0.13.RELEASE"
  id("org.jetbrains.kotlin.plugin.allopen") version "1.7.10"
  id("org.jetbrains.kotlin.plugin.noarg") version "1.7.10"
  id("org.jetbrains.kotlin.plugin.jpa") version "1.7.10"
  kotlin("jvm") version "1.7.10"
  kotlin("plugin.spring") version "1.7.10"
}

group = "br.com.github.chcosta"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
  mavenCentral()
}

dependencies {
//  implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
//  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-cache")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("com.h2database:h2")
  implementation("org.flywaydb:flyway-core:9.4.0")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "17"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
