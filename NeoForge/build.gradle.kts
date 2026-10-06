plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-neoforge")
}

configurations.configureEach {
    resolutionStrategy {
        force("com.google.code.gson:gson:2.13.2")
        force("org.slf4j:slf4j-api:2.0.17")
        force("io.netty:netty-buffer:4.2.7.Final")
        force("org.joml:joml:1.10.8")
    }
}

dependencies {
    modApi(sharedLibs.puzzleslib.neoforge)
    api(sharedLibs.playeranimationlibrary.neoforge)
}
