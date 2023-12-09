# CumulusConfig

```kotlin
repositories {
    maven("https://repo.tabooproject.org/repository/releases/")
}

dependencies {
    implementation("com.mcstarrysky:CumulusConfig:{version}")
}
```

You must install Floodgate to use CumulusConfig.

```kotlin
repositories {
    maven("https://repo.opencollab.dev/maven-snapshots/")
}

dependencies {
    compileOnly("org.geysermc.floodgate:api:2.2.0-SNAPSHOT")
}
```

CumulusConfig requires **TabooLib** and **Floodgate**.
