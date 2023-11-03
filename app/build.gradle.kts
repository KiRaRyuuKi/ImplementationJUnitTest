plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.orkestra.junittest"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.orkestra.junittest"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation ("com.google.android.material:material:1.8.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    testImplementation (kotlin("test"))
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.mockito:mockito-core:4.1.0")
    testImplementation ("org.jetbrains.kotlin:kotlin-test")
    testImplementation ("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.8.1")

    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
}
