plugins {
    id("org.jsonschema2dataclass") version "4.5.0"
}

dependencies {
    val junitVersion = "5.9.1"

    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
}

jsonSchema2Pojo {
    source.setFrom(files("${projectDir}/src/main/resources/de/gamue"))

    includeJsr303Annotations.set(true)
    includeAdditionalProperties.set(false)
    includeHashcodeAndEquals.set(true)
    includeToString.set(true)
}