plugins {
	java
	id("org.springframework.boot") version "4.0.3"
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

// allprojects {
//     configurations.configureEach {
//         resolutionStrategy.eachDependency { 
//             if (requested.group == "commons-io" && requested.name == "commons-io") {
//                 useVersion("2.14.0")
//                 because("Fix GHSA-78wr-2p64-hpwj vulnerability")
//             }
//         }

//         // Force override even for transitive dependencies
//         resolutionStrategy.force("commons-io:commons-io:2.14.0")
//     }
// }

 
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-security-saml2")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.hibernate.validator:hibernate-validator:9.1.0.Final")
    // ✅ Keep SAML dependency, but don’t exclude commons-io
    implementation("org.springframework.security:spring-security-saml2-service-provider")
    implementation("commons-io:commons-io:2.14.0")
    implementation("org.apache.velocity:velocity-engine-core:2.4.1")
    implementation("org.springframework.session:spring-session-jdbc")
    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
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
