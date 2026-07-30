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
            groupId = "com.seanchen.widget"
            artifactId = "ui"
            version = "0.1.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.runner)

    implementation(libs.androidx.compose)
    implementation(libs.androidx.material3)
}
