import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
    id("com.vanniktech.maven.publish") version "0.11.1" apply false
}

allprojects {
    @Suppress("LocalVariableName") val GROUP: String by this
    @Suppress("LocalVariableName") val VERSION_NAME: String by this

    group = GROUP
    version = VERSION_NAME

    repositories {
        jcenter()
    }

    apply(plugin = "java")

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
