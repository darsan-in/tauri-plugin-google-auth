import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "app.tauri.googleauth"
    
    compileSdk = 37 // Android 17

    defaultConfig {
 
        minSdk = 26 // Android 8.0 and above
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin { compilerOptions { jvmTarget = JvmTarget.JVM_17 } }
}

dependencies {
    implementation("androidx.core:core-ktx:1.18.0") //updated at 24/jun/26 1.19.0 is breaking
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.14.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")

    // Google Identity Services for authorization flow
    implementation("com.google.android.gms:play-services-auth:21.6.0")

    // Credential Manager for native sign-in flow
    implementation("androidx.credentials:credentials:1.6.0")
    implementation("androidx.credentials:credentials-play-services-auth:1.6.0")
    implementation("com.google.android.libraries.identity.googleid:googleid:1.2.0")

    // Secure storage
    implementation("androidx.security:security-crypto:1.1.0")

    // HTTP client for token exchange
    implementation("com.squareup.okhttp3:okhttp:5.4.0")

    // JSON parsing
    implementation("com.google.code.gson:gson:2.14.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.11.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.11.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
    implementation(project(":tauri-android"))
}
