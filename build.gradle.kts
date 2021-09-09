plugins {
    java
    `maven-publish`
    signing
}

group = "dev.notmyfault.serverlib"
version = "2.3.1"

var versuffix by extra("SNAPSHOT")
version = if (!project.hasProperty("release")) {
    String.format("%s-%s", project.version, versuffix)
} else {
    String.format(project.version as String)
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(16))
}

tasks.compileJava.configure {
    options.release.set(8)
}

configurations.all {
    attributes.attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 16)
}

repositories {
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks {

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
    }
}


signing {
    if (!version.toString().endsWith("-SNAPSHOT")) {
        signing.isRequired
        sign(publishing.publications)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {

                name.set(project.name + " " + project.version)
                description.set("ServerLib is a tool that attempts to detect unsafe implementations of the Bukkit API.")
                url.set("https://github.com/NotMyFault/ServerLib")

                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                        distribution.set("repo")
                    }
                }

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
                    url.set("https://github.com/NotMyFault/ServerLib")
                    connection.set("scm:https://NotMyFault@github.com/NotMyFault/ServerLib.git")
                    developerConnection.set("scm:git://github.com/NotMyFault/ServerLib.git")
                }

                issueManagement {
                    system.set("GitHub")
                    url.set("https://github.com/NotMyFault/ServerLib/issues")
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
                val releasesRepositoryUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
                val snapshotRepositoryUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
                url = uri(
                        if (version.toString().endsWith("-SNAPSHOT")) snapshotRepositoryUrl
                        else releasesRepositoryUrl
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
