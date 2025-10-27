plugins {
	java
	id("org.springframework.boot") version "3.5.7"
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
        if (requested.group == "org.apache.commons" && requested.name == "commons-lang3") {
            useVersion("3.18.0")
            because("Force fixed version due to GHSA-j288-q9x7-2f5v")
        }
    }
}

 
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
	implementation("org.springframework.security:spring-security-saml2-service-provider:7.0.0-RC1")
	implementation("org.springframework.session:spring-session-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	constraints {
        // Force a specific version for a transitive dependency
        implementation("org.bouncycastle:bcprov-jdk18on:1.78") {
            because("vulnerability: GHSA-v435-xc8x-wvr9 and  GHSA-4cx2-fc23-5wg6")
        }

		implementation("org.bouncycastle:bcpkix-jdk18on:1.79") {
			because("vulnerability:  GHSA-4cx2-fc23-5wg6")
		}
    }
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootJar {
    archiveFileName.set("mydemo.jar")
}
