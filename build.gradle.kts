plugins {
    java
    id("com.diffplug.spotless") version "6.12.0"
}
subprojects {
    group = "de.gamue"
    version = "1.1-SNAPSHOT"

    apply {
        plugin("java")
        plugin("com.diffplug.spotless")
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

    spotless {
        java {
            importOrder()
            removeUnusedImports()
            googleJavaFormat("1.15.0")
        }
    }
}

tasks.wrapper {
    gradleVersion = "8.4"
    distributionType = Wrapper.DistributionType.ALL
}