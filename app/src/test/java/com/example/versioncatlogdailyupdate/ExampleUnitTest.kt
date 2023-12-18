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
        val descList: MutableList<String> = mutableListOf(),
        val versionList: MutableList<VersionInfo> = mutableListOf(),
    )

    private data class VersionInfo(val name: String, val line: String)


    private data class PluginInfo(val name: String, val line: String)
    private data class LibraryGroup(
        val url: String,
        val descList: MutableList<String> = mutableListOf(),
        val libraryList: MutableList<LibraryInfo> = mutableListOf()
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

            val isUrl = line.startsWith("#http")
            val isDesc = line.startsWith("#") && !isUrl

            val name by lazy {
                line.substring(0, line.indexOf("="))
            }

            when (type) {
                None -> continue
                Version -> {
                    if (isUrl) {
                        addVersionInfo()
                        versionGroup = VersionGroup(line)
                    } else if (isDesc) {
                        versionGroup?.descList?.add(line)
                    } else {
                        val versionInfo = VersionInfo(name, line)
                        versionGroup?.versionList?.add(versionInfo)
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
                    } else if (isDesc) {
                        libraryGroup?.descList?.add(line)
                    } else {
                        libraryGroup?.libraryList?.add(LibraryInfo(name, line))
                    }
                }

            }
        }

        addVersionInfo()
        addPluginInfo()
        addLibraryInfo()

        versionList.forEach { group ->
            group.versionList.sortBy { it.name }
        }
        versionList.sortBy { it.versionList.first().name }
        pluginList.sortBy { it.name }
        libraryList.forEach { group ->
            group.libraryList.sortBy { it.name }
        }
        libraryList.sortBy { it.libraryList.first().name }

        val resultList = mutableListOf<String>()
        resultList.add("[versions]")

        versionList.forEachIndexed { index, group ->
            if (index > 0) resultList.addLine()

            resultList.add(group.url)

            group.descList.forEach(resultList::add)
            group.versionList.map { it.line }.forEach(resultList::add)
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

            group.descList.forEach(resultList::add)
            group.libraryList.map { it.line }.forEach(resultList::add)
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