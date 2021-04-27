# ServerLib

A small library warning about unsafe [PaperMC](https://github.com/PaperMC/Paper) or [Tuinity](https://github.com/Spottedleaf/Tuinity) forks.

You can add the library to your project:

**Gradle**
```kotlin
repositories {
    maven { url = uri("https://mvn.intellectualsites.com/content/repositories/thirdparty") }
}

dependencies {
    implementation("org.incendo.serverlib:ServerLib:2.1.0")
}
```

**Maven**:
```xml
<repository>
 <id>serverlib</id>
 <url>https://mvn.intellectualsites.com/content/repositories/thirdparty</url>
</repository>

<dependency>  
 <groupId>org.incendo.serverlib</groupId>
 <artifactId>ServerLib</artifactId>
 <version>2.1.0</version>
</dependency>
``` 

You need to shade ServerLib into your software by either using maven shade or gradle shadow.
