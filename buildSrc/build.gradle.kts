apply{
    plugin("kotlin")
}

buildscript{
    repositories{
        gradlePluginPortal()
    }
    dependencies{
        //项目插件列表
        classpath(kotlin("gradle-plugin","1.6.10"))
    }
}

dependencies{
    //该插件用的三方库？
    implementation(gradleKotlinDsl())
    implementation(kotlin("stdlib","1.6.10"))

}

repositories{
    gradlePluginPortal()
}