plugins {
    id("org.springframework.boot") version "3.1.5"
    id("com.github.ben-manes.versions") version "0.50.0"
}

dependencies {
    val springBootVersion = "3.1.5"

    implementation("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-actuator:${springBootVersion}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${springBootVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.junit}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.junit}")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
}