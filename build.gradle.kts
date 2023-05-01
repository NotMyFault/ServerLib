import java.net.URI

plugins {
    java
    `maven-publish`
    signing

    alias(libs.plugins.nexus)
}

group = "dev.notmyfault.serverlib"
version = "2.3.4-SNAPSHOT"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.compileJava.configure {
    options.release.set(8)
}

configurations.all {
    attributes.attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 17)
}

repositories {
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
}

dependencies {
    compileOnly(libs.paper)
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
        opt.addBooleanOption("html5", true)
    }
}


signing {
    if (!version.toString().endsWith("-SNAPSHOT")) {
        val signingKey: String? by project
        val signingPassword: String? by project
        useInMemoryPgpKeys(signingKey, signingPassword)
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
                        email.set("contact(at)notmyfault.dev")
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
}

nexusPublishing {
    this.repositories {
        sonatype {
            nexusUrl.set(URI.create("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(URI.create("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
        }
    }
}
