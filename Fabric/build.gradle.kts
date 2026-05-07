plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-fabric")
}

repositories {
    maven {
        name = "RedlanceMinecraft"
        url = uri("https://repo.redlance.org/public")
    }
}

dependencies {
    modApi(sharedLibs.fabricapi.fabric)
    modApi(sharedLibs.puzzleslib.fabric)
    api(sharedLibs.playeranimationlibrary.fabric)
}
