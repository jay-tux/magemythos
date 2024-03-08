package ui

import DesktopCache
import LocalStorage
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.darkrockstudios.libraries.mpfilepicker.DirectoryPicker
import com.darkrockstudios.libraries.mpfilepicker.FilePicker
import kotlinx.coroutines.launch
import runtime.Runtime
import runtime.ast.AstBuilder
import runtime.ast.Provider
import java.io.File

@Composable
fun loader(local: LocalStorage) {
    var dialog by remember { mutableStateOf(false) }
    var path by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    val runLoad = {
        scope.launch {
            val base = path.split('/').dropLast(2).joinToString("/")
            try {
                AstBuilder.loadWithDeps(
                    source = path.split('/').dropLast(1).last(),
                    file = path.split('/').last().split('.')[0],
                    provider = DesktopCache.mkProvider(base)
                )
            } catch (e: Exception) {
                Runtime.getLogger()
                    .logError((e.message ?: "Unknown error") + "\n" + e.stackTraceToString())
            }
        }
    }

    Button({ dialog = true }) {
        Text("Load")
    }

    FilePicker(dialog, initialDirectory = local.lastLoaded(), fileExtensions = listOf("mm")) {
        dialog = false
        it?.let {
            local.onLoad(it.path)
            path = it.path
            runLoad()
        }
    }
}

@Composable
fun cacheLoader(cache: DesktopCache) {
    var dialog by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val actualLoad = { it: String ->
        scope.launch {
            try {
                cache.resetCache()
                cache.clearLog()
                AstBuilder.loadEntireCache(it, DesktopCache.mkLoader())
            } catch (e: Exception) {
                Runtime.getLogger()
                    .logError((e.message ?: "Unknown error") + "\n" + e.stackTraceToString())
            }
        }
    }

    val onClick = {
        scope.launch {
            cache.selectedCacheDir()?.let {
                actualLoad(it)
            } ?: run {
                dialog = true
            }
        }.let {}
    }

    Button(onClick) {
        Text("Load Entire Cache")
    }

    DirectoryPicker(dialog, initialDirectory = cache.lastLoaded()) {
        dialog = false
        it?.let {
            cache.onSetCacheDir(it)
            actualLoad(it)
        }
    }
}
