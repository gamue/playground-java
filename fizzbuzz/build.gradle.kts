plugins {
    id("org.springframework.boot") version "2.7.5"
    id("com.github.ben-manes.versions") version "0.44.0"
}

dependencies {
    val springBootVersion = "2.7.5"
    val openApiVersion = "1.6.14"

    implementation("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-actuator:${springBootVersion}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${springBootVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.junit}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.junit}")
    implementation("org.springdoc:springdoc-openapi-ui:${openApiVersion}")
}