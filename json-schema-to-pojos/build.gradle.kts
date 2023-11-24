plugins {
    id("org.jsonschema2dataclass") version "6.0.0"
}

dependencies {
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.0")
    testImplementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.junit}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.junit}")
}

jsonSchema2Pojo {
    executions {
        create("main") {
            io.source.setFrom(files("${projectDir}/src/main/resources/de/gamue"))
            methods.annotateJsr303Jakarta.set(true)
            methods.additionalProperties.set(false)
        }
    }
}

spotless {
    java {
        targetExclude( "build")
        target("src/**/*.java")
    }
}