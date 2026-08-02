plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    `maven-publish`
}

android {
    namespace = "com.seanchen.widget.ui"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"

            url = uri(
                "https://maven.pkg.github.com/Akiha678/Android_Widget"
            )

            credentials {
                /**
                 * 这里进行了`export GITHUB_USERNAME`，请检查本机
                 */
                username = System.getenv("GITHUB_USERNAME")

                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }


    publications {
        register<MavenPublication>("release") {
            groupId = project.group.toString()
            artifactId = "ui"
            version = project.version.toString()

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set("XinComponent UI")
                description.set("Enterprise-ready Jetpack Compose design system and UI components.")
                url.set("https://github.com/Akiha678/Android_Widget")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                scm {
                    url.set("https://github.com/Akiha678/Android_Widget")
                    connection.set("scm:git:git://github.com/Akiha678/Android_Widget.git")
                }
            }
        }
    }
}

dependencies {
    testImplementation(libs.junit)

    // Public component signatures expose Compose and Material 3 types.
    api(libs.androidx.compose)
    api(libs.androidx.material3)
}
