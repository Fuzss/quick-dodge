plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-common")
}

dependencies {
    modCompileOnlyApi(libs.puzzleslib.common)
    modCompileOnlyApi(libs.bundles.playeranimationlibrary.common)
}

multiloader {
    mixins {
        mixin("PlayerMixin")
    }
}
