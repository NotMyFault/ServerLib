plugins {
    java
    `maven-publish`
}

group = "org.incendo.serverlib"
version = "2.2.2-SNAPSHOT"

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

java {
    withSourcesJar()
    withJavadocJar()
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

                    developer {
                        id.set("Citymonstret")
                        name.set("Alexander Söderberg")
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

val javadocDir = rootDir.resolve("docs").resolve("javadoc").resolve(project.name)
tasks {
    named<Delete>("clean") {
        doFirst {
            rootDir.resolve("target").deleteRecursively()
            javadocDir.deleteRecursively()
        }
    }

    compileJava {
        options.compilerArgs.addAll(arrayOf("-Xmaxerrs", "1000"))
        options.compilerArgs.add("-Xlint:all")
        for (disabledLint in arrayOf("processing", "path", "fallthrough", "serial"))
            options.compilerArgs.add("-Xlint:$disabledLint")
        options.isDeprecation = true
        options.encoding = "UTF-8"
    }

    javadoc {
        val opt = options as StandardJavadocDocletOptions
        opt.addStringOption("Xdoclint:none", "-quiet")
        opt.tags(
                "apiNote:a:API Note:",
                "implSpec:a:Implementation Requirements:",
                "implNote:a:Implementation Note:"
        )
        opt.destinationDirectory = javadocDir
    }
    named("build") {
        dependsOn(named("javadoc"))
    }
}

