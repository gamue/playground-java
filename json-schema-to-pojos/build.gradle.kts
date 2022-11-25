plugins {
    id("org.jsonschema2dataclass") version "4.5.0"
}

dependencies {
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.junit}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.junit}")
}

jsonSchema2Pojo {
    source.setFrom(files("${projectDir}/src/main/resources/de/gamue"))

    includeJsr303Annotations.set(true)
    includeAdditionalProperties.set(false)
    includeHashcodeAndEquals.set(true)
    includeToString.set(true)
}