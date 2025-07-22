plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Rest Assured
    testImplementation("io.rest-assured:rest-assured:5.5.5")
    testImplementation("io.rest-assured:json-path:5.4.0")

    // JUnit 5
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Jackson
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    testImplementation("com.fasterxml.jackson.core:jackson-annotations:2.15.2")
    testImplementation("com.fasterxml.jackson.core:jackson-core:2.15.2")
}

tasks.test {
    useJUnitPlatform()

    systemProperty("token", System.getProperty("token"))
}