# Web Crawler

A multithreaded java web crawler using concurrency libs for more efficient crawling across multiple pages and "jsoup" for HTML parsing.



## Requirements

- **Java 8+** (JDK)
- **Maven / Gradle** (for dependency management)



## Dependencies

Add jsoup dependency                                                                                                                                                 
Maven -
```xml
<dependencies>
    <dependency>
        <groupId>org.jsoup</groupId>
        <artifactId>jsoup</artifactId>
        <version>1.21.1</version>
    </dependency>
</dependencies>
```
Gradle -

```gradle
dependencies {
    implementation("org.jsoup:jsoup:1.21.1")
}