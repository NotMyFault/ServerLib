plugins {
    java
    `maven-publish`
}

group = "de.notmyfault"
version = "1.0.1"

tasks {
    compileJava {
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = sourceCompatibility
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {

                developers {
                    developer {
                        id.set("NotMyFault")
                        name.set("NotMyFault")
                    }
                }

                scm {
                    url.set("https://github.com/NotMyFault/ServerLib")
                    connection.set("scm:https://NotMyFault@github.com/NotMyFault/ServerLib.git")
                    developerConnection.set("scm:git://github.com/NotMyFault/ServerLib.git")
                }
            }
        }
    }

    repositories {
        mavenLocal()
        val nexusUsername: String? by project
        val nexusPassword: String? by project
        if (nexusUsername != null && nexusPassword != null) {
            maven {
                val thirdParty =
                    "https://mvn.intellectualsites.com/content/repositories/thirdparty/"
                val snapshotRepositoryUrl =
                    "https://mvn.intellectualsites.com/content/repositories/snapshots/"
                url = uri(
                    if (version.toString().endsWith("-SNAPSHOT")) snapshotRepositoryUrl
                    else thirdParty
                )

                credentials {
                    username = nexusUsername
                    password = nexusPassword
                }
            }
        } else {
            logger.warn("No nexus repository is added; nexusUsername or nexusPassword is null.")
        }
    }
}
