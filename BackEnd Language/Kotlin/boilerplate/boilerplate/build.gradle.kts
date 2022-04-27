import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.testing.logging.TestExceptionFormat.*
import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
	id("org.springframework.boot") version "2.6.6" apply false
	id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	id("com.google.protobuf") version "0.8.18" apply false
	kotlin("kapt") version "1.6.21"
}

extra["springCloudVersion"] = "2021.0.1"
extra["kotlin-coroutines.version"] = "1.6.0"

buildscript {
	repositories {
		mavenCentral()
	}
}


allprojects {
	group = "com.mz.boilerplate"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}
	tasks.withType<JavaCompile> {
		sourceCompatibility = "11"
		targetCompatibility = "11"
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

var mapstructVersion = "1.5.0.RC1"
var kotestVersion = "5.2.3"
var grpcTestVersion = "1.45.1"
var grpcVersion = "1.42.2"
var javaxAnnotationApiVersion = "1.3.2"
var mockkVersion = "1.12.3"

subprojects {
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "kotlin")
	apply(plugin = "com.google.protobuf")
	apply(plugin= "idea")
	apply(plugin= "eclipse")
	apply(plugin= "kotlin-kapt")

	dependencies {
		implementation("org.mapstruct:mapstruct:$mapstructVersion")
		kapt("org.mapstruct:mapstruct-processor:$mapstructVersion")
		testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
		testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
		testImplementation("io.grpc:grpc-testing:$grpcTestVersion")
		testImplementation("io.mockk:mockk:$mockkVersion")
	}


}





