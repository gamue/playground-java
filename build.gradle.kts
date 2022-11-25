plugins {
    java
}
subprojects {
    group = "de.gamue"
    version = "1.1-SNAPSHOT"

    apply {
        plugin("java")
    }

    repositories {
        mavenCentral()
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType<Test>  {
        useJUnitPlatform()
    }
}

tasks.wrapper {
    gradleVersion = "7.5.1"
    distributionType = Wrapper.DistributionType.ALL
}