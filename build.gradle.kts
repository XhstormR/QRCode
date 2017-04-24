import org.gradle.api.tasks.wrapper.Wrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

version = "1.0-SNAPSHOT"

task<Wrapper>("wrapper") {
    gradleVersion = "3.5"
    distributionUrl = "https://services.gradle.org/distributions/gradle-$gradleVersion-all.zip"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.1.1"

    repositories {
        maven { setUrl("http://maven.aliyun.com/nexus/content/groups/public/") }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

apply {
    plugin("java")
    plugin("kotlin")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val kotlin_version: String by extra

repositories {
    maven { setUrl("http://maven.aliyun.com/nexus/content/groups/public/") }
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlin_version")
    compile("com.google.zxing:javase:+")
}
