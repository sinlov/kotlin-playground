## doc

- [https://plugins.gradle.org/plugin/io.gitlab.arturbosch.detekt](https://plugins.gradle.org/plugin/io.gitlab.arturbosch.detekt)
- [https://detekt.github.io/detekt](https://detekt.github.io/detekt)

## check style

```bash
./gradlew :[module]:detekt
```

## first config

```groovy
buildscript {
    // ...
    repositories {
        // ...
        jcenter()
        maven { url "https://plugins.gradle.org/m2/" }
    }
    dependencies {
        // ...
        classpath "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.15.0"
    }
}
```

in module

```groovy
apply plugin: 'io.gitlab.arturbosch.detekt'

...

detekt {
    parallel = false
    config = files "$rootDir/gradle/code_quality/${projectDir.name}/detekt.yml"
    reports {
        xml { enabled = true }
        html { enabled = true }
    }
    // other detekt configuration goes here
    baseline = file("$rootDir/gradle/code_quality/${projectDir.name}/baseline.xml")
}
tasks.detekt.jvmTarget = "1.8"
```

then run to gen config
```bash
./gradlew :[module]:detektGenerateConfig
./gradlew :[module]:detektBaseline
./gradlew :[module]:detektBaselineMain
./gradlew :[module]:detektBaselineTest
```