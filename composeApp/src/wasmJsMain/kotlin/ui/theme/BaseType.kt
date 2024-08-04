package ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp




fun getBaseType(isDark: Boolean) = Typography(
    body1 = TextStyle(
        color = BaseColor.Tertiary.toColor(isDark),
        fontSize = 12.sp
    ),
    body2 = TextStyle(
        color = BaseColor.Blue02.toColor(isDark),
        fontSize = 12.sp
    )
)