plugins {
    java
    `maven-publish`
}

group = "org.incendo.serverlib"
version = "2.1.1-SNAPSHOT"

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = sourceCompatibility
}

repositories {
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("com.destroystokyo.paper", "paper-api", "1.16.5-R0.1-SNAPSHOT")
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
                    url.set("https://github.com/Incendo/ServerLib")
                    connection.set("scm:https://Incendo@github.com/Incendo/ServerLib.git")
                    developerConnection.set("scm:git://github.com/Incendo/ServerLib.git")
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
