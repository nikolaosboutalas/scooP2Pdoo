plugins {
  kotlin("jvm") version "1.9.23"
  application
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(project(":common"))
}

application {
  mainClass = "MainKt"
}
