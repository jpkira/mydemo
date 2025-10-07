plugins {
	java
	id("org.springframework.boot") version "3.5.6"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.abcb"
version = "0.0.1-SNAPSHOT"
description = "Demo project to investigate grype scanner report"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
	maven {
		url = uri("https://repository.jboss.org/")
	}
}

configurations.all {
	resolutionStrategy.eachDependency {
		if (requested.group == "commons-io" && requested.name == "commons-io") {
			useVersion("2.14.0")
			because("Force latest commons-io to avoid security vulnerability GHSA-78wr-2p64-hpwj")
		}
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
	implementation("org.springframework.security:spring-security-saml2-service-provider")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootJar {
    archiveFileName.set("mydemo.jar")
}
