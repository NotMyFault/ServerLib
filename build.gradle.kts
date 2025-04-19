import com.vanniktech.maven.publish.SonatypeHost
import java.net.URI

plugins {
    java
    signing

    alias(libs.plugins.publish)
}

group = "dev.notmyfault.serverlib"
version = "2.3.7"

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
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}

dependencies {
    compileOnly(libs.paper)
}

tasks {

    javadoc {
        val opt = options as StandardJavadocDocletOptions
        opt.noTimestamp()
    }

    withType<AbstractArchiveTask>().configureEach {
        isPreserveFileTimestamps = false
        isReproducibleFileOrder = true
    }
}

if (!project.hasProperty("skip.signing")) {
    signing {
        if (!version.toString().endsWith("-SNAPSHOT")) {
            val signingKey: String? by project
            val signingPassword: String? by project
            useInMemoryPgpKeys(signingKey, signingPassword)
            signing.isRequired
            sign(publishing.publications)
        }
    }
}

mavenPublishing {
    coordinates(
            groupId = "$group",
            artifactId = project.name,
            version = "${project.version}",
    )

    pom {
        name.set(project.name)
        description.set("ServerLib is a tool that attempts to detect unsafe implementations of the Bukkit API.")
        url.set("https://github.com/NotMyFault/ServerLib")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/mit")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                id.set("NotMyFault")
                name.set("NotMyFault")
                email.set("contact(at)notmyfault.dev")
                organization.set("IntellectualSites")
                organizationUrl.set("https://github.com/IntellectualSites/")
            }
        }

        scm {
            url.set("https://github.com/NotMyFault/ServerLib")
            connection.set("scm:git:https://github.com/NotMyFault/ServerLib.git")
            developerConnection.set("scm:git:git@github.com:NotMyFault/ServerLib.git")
            tag.set(project.version.toString())
        }

        issueManagement {
            system.set("GitHub")
            url.set("https://github.com/NotMyFault/ServerLib/issues")
        }

        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    }
}
