plugins {
    id("org.springframework.boot") version "3.0.1"
    id("com.github.ben-manes.versions") version "0.44.0"
}

dependencies {
    val springBootVersion = "3.0.1"
    val openApiVersion = "1.6.14"

    implementation("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-actuator:${springBootVersion}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${springBootVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.junit}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.junit}")
    implementation("org.springdoc:springdoc-openapi-ui:${openApiVersion}")
}