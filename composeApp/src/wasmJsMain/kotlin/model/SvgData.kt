package model

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SvgData(
    val width: Dp = DEFAULT_SIZE,
    val height: Dp = DEFAULT_SIZE,
    val viewportWidth: Float = DEFAULT_VIEWPORT_SIZE,
    val viewportHeight: Float = DEFAULT_VIEWPORT_SIZE,
    val isMaterialIcon: Boolean = width == 24.dp && height == 24.dp && viewportWidth == 24F && viewportHeight == 24F,
    //val paths: List<PathConverted> = emptyList(),
) {
    companion object {

        val DEFAULT_SIZE = 200.dp
        const val DEFAULT_VIEWPORT_SIZE = 200F
    }
}