plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-common")
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
    modCompileOnlyApi(sharedLibs.puzzleslib.common)
    compileOnlyApi(sharedLibs.bundles.playeranimationlibrary.common)
}

multiloader {
    mixins {
        mixin("PlayerMixin")
    }
}
