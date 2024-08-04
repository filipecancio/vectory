import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import ui.screen.home.HomeController
import ui.screen.home.HomeScreen

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        val clipboardManager = LocalClipboardManager.current
        val controller = HomeController(clipboardManager)
        HomeScreen(controller)
    }
}