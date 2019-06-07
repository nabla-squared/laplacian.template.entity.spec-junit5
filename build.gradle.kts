group = "laplacian"
version = "1.0.0"

plugins {
    `maven-publish`
    kotlin("jvm") version "1.3.10"
    id("laplacian.generator") version "1.0.0"
}

repositories {
    maven(url = "../mvn-repo/")
    maven(url = "https://raw.github.com/nabla-squared/mvn-repo/master/")
    jcenter()
}




val templateModule by tasks.register<Jar>("templateModule") {
    from(laplacianGenerate.templateSources)
}

dependencies {
}

publishing {
    repositories {
        maven(url = "../mvn-repo/")
    }
    publications {
        create<MavenPublication>("mavenJava") {
            artifact(templateModule)
        }
    }
}