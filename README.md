# ServerLib

A small library warning about unsafe [PaperMC](https://github.com/PaperMC/Paper) or [Tuinity](https://github.com/Spottedleaf/Tuinity) forks.

You can add the library to your project:

Releases are published to the central repository, snapshots are published to [S01 OSS Sonatype](https://s01.oss.sonatype.org/content/repositories/snapshots/).

You can find Javadocs [here](https://javadoc.io/doc/dev.notmyfault.serverlib/ServerLib).

Take a look at the release tab for versions available.

**Gradle**
```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.notmyfault.serverlib:ServerLib:VERSION")
}
```

**Maven**:
```xml
<dependency>  
 <groupId>dev.notmyfault.serverlib</groupId>
 <artifactId>ServerLib</artifactId>
 <version>VERSION</version>
</dependency>
``` 

You need to shade ServerLib into your software by either using maven shade or gradle shadow.
