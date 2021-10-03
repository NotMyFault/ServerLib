# ServerLib

A small library warning about unsafe [PaperMC](https://github.com/PaperMC/Paper) or [Tuinity](https://github.com/Spottedleaf/Tuinity) forks.

You can add the library to your project:

Releases are published to the central repository, snapshots are published to S01 OSS Sonatype.

You can find Javadocs [here](https://javadoc.io/doc/dev.notmyfault.serverlib/ServerLib).

**Gradle**
```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.notmyfault.serverlib:ServerLib:2.3.1")
}
```

**Maven**:
```xml
<dependency>  
 <groupId>dev.notmyfault.serverlib</groupId>
 <artifactId>ServerLib</artifactId>
 <version>2.3.1</version>
</dependency>
``` 

You need to shade ServerLib into your software by either using maven shade or gradle shadow.
