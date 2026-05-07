plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-common")
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
    modCompileOnlyApi(sharedLibs.puzzleslib.common)
    compileOnlyApi(sharedLibs.bundles.playeranimationlibrary.common)
}

multiloader {
    mixins {
        mixin("PlayerMixin")
    }
}
