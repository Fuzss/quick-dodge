plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-neoforge")
}

configurations.configureEach {
    resolutionStrategy {
        force("io.netty:netty-buffer:4.2.7.Final")
    }
}

repositories {
    maven {
        name = "RedlanceMinecraft"
        url = uri("https://repo.redlance.org/public")
    }
}

dependencies {
    modApi(sharedLibs.puzzleslib.neoforge)
    api(sharedLibs.playeranimationlibrary.neoforge)
}
