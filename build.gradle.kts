plugins {
	java
	id("org.springframework.boot") version "4.0.0-RC1"
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

 
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
	implementation("org.springframework.security:spring-security-saml2-service-provider")
	 implementation("org.apache.velocity:velocity-engine-core:2.3") {
        exclude(group = "commons-io", module = "commons-io")
    }
	implementation("org.springframework.session:spring-session-jdbc")
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
