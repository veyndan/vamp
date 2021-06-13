import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.21"
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

tasks.withType<Test> {
    useJUnitPlatform {
        includeEngines = setOf("spek2")
    }
}

dependencies {
    compileOnly("io.gitlab.arturbosch.detekt:detekt-api:1.15.0")
    implementation("org.glassfish:jakarta.el:4.0.0")
    implementation("org.hibernate.validator:hibernate-validator:7.0.0.Final")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.30")

    testImplementation("io.gitlab.arturbosch.detekt:detekt-test:1.15.0")
    testImplementation("org.assertj:assertj-core:3.19.0")
    testImplementation(platform("org.junit:junit-bom:5.7.0"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.15")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:2.0.15")
}
