# ServerLib

A small library warning about unsafe [PaperMC](https://github.com/PaperMC/Paper) or [Tuinity](https://github.com/Spottedleaf/Tuinity) forks.

You can add the library to your project:

**Gradle**
```kotlin
repositories {
    maven { url = uri("https://mvn.intellectualsites.com/content/repositories/thirdparty") }
}

dependencies {
    implementation("de.notmyfault:serverlib:1.0.1")
}
```

**Maven**:
```xml
<repository>
 <id>serverlib</id>
 <url>https://mvn.intellectualsites.com/content/repositories/thirdparty</url>
</repository>

<dependency>  
 <groupId>de.notmyfault</groupId>
 <artifactId>serverlib</artifactId>
 <version>1.0.1</version>
</dependency>
``` 

You need to shade ServerLib into your software by either using maven shade or gradle shadow.
