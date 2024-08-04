package ui.component.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import ui.theme.BaseColor
import ui.theme.getBaseType

@Composable
fun CodeEdit(
    value: TextFieldValue = TextFieldValue("Example"),
    onValueChange: (TextFieldValue) -> Unit,
    isDark: Boolean = false,
    selected: Boolean = false,
    textStyle: TextStyle = if(selected){ getBaseType(isDark).body2 }else{
        getBaseType(isDark).body1},
    isSmallSize: Boolean = false,
    modifier: Modifier = if(isSmallSize)  expandedModifier(isDark,selected) else defaultModifier(isDark,selected)
) = BasicTextField(
    value = value,
    onValueChange = onValueChange,
    modifier = modifier,
    textStyle = textStyle
)

fun defaultModifier(isDark: Boolean,selected: Boolean = false) = Modifier
    .size(
        width = 300.dp,
        height = 100.dp
    )
    .clip(RoundedCornerShape(10.dp))
    .background(if(selected){ BaseColor.Blue01.toColor(isDark) }else{ BaseColor.Secondary.toColor(isDark) })
    .padding(16.dp)

fun expandedModifier(isDark: Boolean,selected: Boolean = false) = Modifier
    .padding(16.dp)
    .fillMaxWidth()
    .height(100.dp)
    .clip(RoundedCornerShape(10.dp))
    .background(if(selected){ BaseColor.Blue01.toColor(isDark) }else{ BaseColor.Secondary.toColor(isDark) })
    .padding(16.dp)