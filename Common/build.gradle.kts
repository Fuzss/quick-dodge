plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-common")
}

configurations.configureEach {
    resolutionStrategy {
        force("io.netty:netty-buffer:4.2.16.Final")
        force("it.unimi.dsi:fastutil:8.5.18")
        force("org.joml:joml:1.10.9")
        force("org.slf4j:slf4j-api:2.0.17")
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
