import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        maven("http://maven.aliyun.com/nexus/content/groups/public/")
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlin_version"]}")
    }
}

repositories {
    maven("http://maven.aliyun.com/nexus/content/groups/public/")
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile("com.google.zxing:javase:+")
}

version = "1.0-SNAPSHOT"

plugins {
    idea
    application
    kotlin("jvm") version "1.2.10"
}

tasks {
    withType<Wrapper> {
        gradleVersion = "4.4.1"
        distributionType = Wrapper.DistributionType.ALL
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
