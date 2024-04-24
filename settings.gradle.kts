import java.net.URI

pluginManagement {
    repositories {
        maven(url = "https://repo1.maven.org/maven2")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven(url = "https://jitpack.io")
        maven(url = "https://repo1.maven.org/maven2")
        google()
        mavenCentral()
        maven(url = "https://mirrors.huaweicloud.com/repository/maven/")
        maven{
            name="Hero"
            url = URI.create(System.getenv("HERO_NEXUS_URL"))
            credentials {
                username= System.getenv("HERO_NEXUS_USERNAME")
                password =System.getenv("HERO_NEXUS_PASSWORD")
            }
        }
    }
}

rootProject.name = "VersionCatlogDailyUpdate"

include(":app")