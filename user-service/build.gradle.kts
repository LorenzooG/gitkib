import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.3.1.RELEASE"
  id("io.spring.dependency-management") version "1.0.9.RELEASE"
  kotlin("jvm") version "1.3.72"
  kotlin("plugin.spring") version "1.3.72"
  kotlin("plugin.jpa") version "1.3.72"
}

group = "com.lorenzoog.gitkib"
version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-data-rest")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  implementation("org.hibernate:hibernate-validator:5.1.0.Final")

  implementation("com.zaxxer:HikariCP:3.4.5")

  developmentOnly("org.springframework.boot:spring-boot-devtools")

  runtimeOnly("com.h2database:h2")
  runtimeOnly("org.postgresql:postgresql")

  testImplementation("com.ninja-squad:springmockk:2.0.2")
  testImplementation("io.mockk:mockk:1.10.0")
  testImplementation("junit:junit")

  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    exclude(module = "mockito-core")
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "1.8"
  }
}
