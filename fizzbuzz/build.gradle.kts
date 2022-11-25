plugins {
    id("org.springframework.boot") version "2.7.5"
    id("com.github.ben-manes.versions") version "0.44.0"
}

dependencies {
    val springBootVersion = "2.7.5"
    val swaggerVersion = "2.10.5"
    val junitVersion = "5.9.1"

    implementation("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-actuator:${springBootVersion}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${springBootVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
    implementation("io.springfox:springfox-swagger2:${swaggerVersion}")
    implementation("io.springfox:springfox-swagger-ui:${swaggerVersion}")
}