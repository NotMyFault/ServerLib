plugins {
    java
}

group = "de.notmyfault"
version = "1.0.0"

tasks {
    compileJava {
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = sourceCompatibility
    }
}
