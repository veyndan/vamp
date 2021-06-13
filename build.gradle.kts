plugins {
    kotlin("jvm") version "1.5.10"
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
}
