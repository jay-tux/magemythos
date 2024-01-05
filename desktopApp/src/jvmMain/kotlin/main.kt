import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "MageMythos") {
        App(Cache(
            System.getProperty("user.home") + "/.mageMythos/",
            System.getProperty("user.home")
        ))
    }
}
