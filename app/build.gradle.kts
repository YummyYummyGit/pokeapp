plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services") // Google Services plugin
    id("com.google.firebase.crashlytics")
    id ("kotlin-android")
    id ("kotlin-kapt")
}
apply(plugin = "com.android.application")

android {
    namespace = "com.example.pokeapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pokeapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth-ktx:22.3.1")
    implementation("com.google.firebase:firebase-firestore:24.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.8.0"))
    implementation("com.google.firebase:firebase-analytics:21.6.1")
    implementation("com.google.firebase:firebase-core:21.1.1")
    implementation("com.google.firebase:firebase-messaging:23.4.1")

    //Firebase SDK for Google Analytics
    implementation("com.google.firebase:firebase-analytics-ktx:21.6.1")

    //Firebase Crashlytics SDK
    implementation("com.google.firebase:firebase-crashlytics:18.6.3")

    //  Import Retrofit v2 to make API calls easier
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //  Import ConverterGson to understand JSON files
    implementation("com.squareup.retrofit2:converter-gson:2.4.0")

    implementation ("com.squareup.retrofit2:adapter-rxjava:2.7.1")
    // HttpRequest and converters
    // This is used for logging (Log) the responses of the WebServices
    implementation ("com.squareup.okhttp3:logging-interceptor:4.3.0")
    // These are HTTP clients
    implementation ("com.squareup.okhttp3:okhttp-urlconnection:4.3.0")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    kapt("com.github.bumptech.glide:compiler:4.12.0")
}

apply(plugin = "com.google.gms.google-services")



