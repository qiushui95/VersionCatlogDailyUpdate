package com.example.versioncatlogdailyupdate

import com.example.versioncatlogdailyupdate.ExampleUnitTest.InfoType.Library
import com.example.versioncatlogdailyupdate.ExampleUnitTest.InfoType.None
import com.example.versioncatlogdailyupdate.ExampleUnitTest.InfoType.Plugin
import com.example.versioncatlogdailyupdate.ExampleUnitTest.InfoType.Version
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.File

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@DisplayName("我的第一个测试用例")
class ExampleUnitTest {
    private val file = File(File("").absoluteFile.parentFile, "gradle/libs.versions.toml")

    private sealed class InfoType {
        object None : InfoType()
        object Version : InfoType()
        object Plugin : InfoType()
        object Library : InfoType()
    }

    private data class VersionGroup(
        val url: String,
        val list: MutableList<VersionInfo> = mutableListOf()
    )

    private data class VersionInfo(val name: String, val line: String)


    private data class PluginInfo(val name: String, val line: String)
    private data class LibraryGroup(
        val url: String,
        val list: MutableList<LibraryInfo> = mutableListOf()
    )

    private data class LibraryInfo(val name: String, val line: String)


    @Test
    fun testSortToml() {
        val lines = readLines()

        val versionList = mutableListOf<VersionGroup>()
        val pluginList = mutableListOf<PluginInfo>()
        val libraryList = mutableListOf<LibraryGroup>()

        var type: InfoType = InfoType.None

        var versionGroup: VersionGroup? = null
        var pluginInfo: PluginInfo? = null
        var libraryGroup: LibraryGroup? = null

        fun addVersionInfo() {
            versionGroup?.apply(versionList::add)
        }

        fun addPluginInfo() {
            pluginInfo?.apply(pluginList::add)
        }

        fun addLibraryInfo() {
            libraryGroup?.apply(libraryList::add)
        }

        for (line in lines) {
            when (line) {
                "[versions]" -> {
                    type = InfoType.Version
                    continue
                }

                "[plugins]" -> {
                    type = InfoType.Plugin
                    continue
                }

                "[libraries]" -> {
                    type = InfoType.Library
                    continue
                }

                "" -> continue
            }

            val isUrl = line.startsWith("#")

            val name by lazy {
                line.substring(0, line.indexOf("="))
            }

            when (type) {
                None -> continue
                Version -> {
                    if (isUrl) {
                        addVersionInfo()
                        versionGroup = VersionGroup(line)
                    } else {
                        val versionInfo = VersionInfo(name, line)
                        versionGroup?.list?.add(versionInfo)
                    }
                }

                Plugin -> {
                    addPluginInfo()
                    pluginInfo = PluginInfo(name, line)
                }

                Library -> {
                    if (isUrl) {
                        addLibraryInfo()
                        libraryGroup = LibraryGroup(line)
                    } else {
                        libraryGroup?.list?.add(LibraryInfo(name, line))
                    }
                }

            }
        }

        addVersionInfo()
        addPluginInfo()
        addLibraryInfo()

        versionList.forEach { group ->
            group.list.sortBy { it.name }
        }
        versionList.sortBy { it.list.first().name }
        pluginList.sortBy { it.name }
        libraryList.forEach { group ->
            group.list.sortBy { it.name }
        }
        libraryList.sortBy { it.list.first().name }

        val resultList = mutableListOf<String>()
        resultList.add("[versions]")

        versionList.forEachIndexed { index, group ->
            if (index > 0) resultList.addLine()

            resultList.add(group.url)

            for (versionInfo in group.list) {
                resultList.add(versionInfo.line)
            }
        }

        repeat(5) {
            resultList.addLine()
        }

        resultList.add("[plugins]")
        pluginList.map { it.line }.forEach(resultList::add)

        repeat(5) {
            resultList.addLine()
        }

        resultList.add("[libraries]")

        libraryList.forEachIndexed { index, group ->
            if (index > 0) resultList.addLine()

            resultList.add(group.url)

            group.list.map { it.line }.forEach(resultList::add)
        }

        file.writeText(resultList.joinToString("\n"))
    }

    private fun readLines(): List<String> {
        return file.readLines()
    }
}

private fun MutableList<String>.addLine() {
    this.add("")
}