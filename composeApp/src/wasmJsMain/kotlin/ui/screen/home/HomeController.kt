package ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import model.SvgData
import ui.theme.BaseVector


class HomeController(
    private val clipboardManager: ClipboardManager
) {
    var isDark by mutableStateOf(false)
    var currentTabIndex by mutableStateOf(0)
    var textFieldValue by mutableStateOf(TextFieldValue(""))
    private var svgData: SvgData? by mutableStateOf(null)
    var imageVectorCode by mutableStateOf("")
    private var pathDecomposed by mutableStateOf("")
    var imageVector by mutableStateOf<ImageVector?>(null)
    var unknownColors by mutableStateOf(emptySet<String>())
    var iconName by mutableStateOf(TextFieldValue("untitled"))
    var blur by mutableStateOf(0.0F)

    val convertOptions = listOf(
        ConvertOptions.DrawablePath,
        ConvertOptions.SvgPath
    )

    fun clearValues(index: Int) {
        pathDecomposed = ""
        imageVectorCode = ""
        imageVector = null
        currentTabIndex = index
    }

    fun getCurrentPlaceholder() = convertOptions[currentTabIndex].placeholder

    fun copyImageVector() {
        clipboardManager.setText(AnnotatedString(imageVectorCode))
    }

    fun generateSvgData() {
        svgData = null
        //svgData = buildSvgData() ?: return
        //updateImageVectorCode()
    }

    fun replaceImageVectorCode(newName: TextFieldValue) {
        iconName = newName
        if(svgData != null){
            //updateImageVectorCode()
        }
    }


    enum class ConvertOptions(
        val label: String,
        val placeholder: String,
        val icon: BaseVector
    ) {
        DrawablePath(
            label = "Drawable",
            icon = BaseVector.FileXml,
            placeholder = "Insert Drawable path here:"
        ),
        SvgPath(
            label = "SVG Path",
            icon = BaseVector.FileSvg,
            placeholder = "Insert SVG path here:"
        ),
        SvgFile(
            label = "SVG File",
            icon = BaseVector.FileSvg,
            placeholder = "Insert SVG file here:"
        )
    }
}