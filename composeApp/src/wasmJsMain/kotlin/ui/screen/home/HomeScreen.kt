package ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import ui.component.atom.ActionButton
import ui.component.atom.CodeEdit
import ui.component.atom.TabButton
import ui.component.molecule.ActionBar
import ui.component.molecule.ImageView
import ui.component.molecule.TopBar
import ui.theme.BaseColor
import ui.theme.getBaseType

@Composable
fun HomeScreen(
    controller: HomeController
) {
    LaunchedEffect(Unit) {
        window.addEventListener("resize") {
            controller.windowWidth.value = window.innerWidth
        }
    }
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BaseColor.Primary.toColor(controller.isDark))
                .blur((controller.blur).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            TopBar(controller.isDark) {
                controller.convertOptions.mapIndexed { index, item ->
                    TabButton(
                        text = item.label,
                        baseVector = item.icon,
                        isEnabled = controller.currentTabIndex == index,
                        onClick = { controller.clearValues(index) },
                        isDark = controller.isDark
                    )
                }
            }
            if (controller.isSmallWindow() ){
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = controller.getCurrentPlaceholder(),
                            modifier = Modifier.width(300.dp),
                            style = getBaseType(controller.isDark).body1
                        )
                        CodeEdit(
                            value = controller.textFieldValue,
                            onValueChange = { controller.textFieldValue = it },
                            isDark = controller.isDark,
                            isSmallSize = controller.isSmallWindow()
                        )
                        ActionButton(
                            text = "Convert",
                            onClick = { controller.generateSvgData() },
                            isDark = controller.isDark
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            "The Image Vector code:",
                            modifier = Modifier.width(300.dp),
                            style = getBaseType(controller.isDark).body2
                        )
                        CodeEdit(
                            value = TextFieldValue(controller.imageVectorCode),
                            selected = true,
                            onValueChange = { },
                            isDark = controller.isDark,
                            isSmallSize = controller.isSmallWindow()
                        )
                        ActionBar(
                            buttonText = "Copy",
                            onClick = { controller.copyImageVector() },
                            selected = true,
                            value = controller.iconName,
                            onValueChange = { controller.replaceImageVectorCode(it) },
                            isDark = controller.isDark
                        )
                    }
                }
            }else {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = controller.getCurrentPlaceholder(),
                            modifier = Modifier.width(300.dp),
                            style = getBaseType(controller.isDark).body1
                        )
                        CodeEdit(
                            value = controller.textFieldValue,
                            onValueChange = { controller.textFieldValue = it },
                            isDark = controller.isDark,
                            isSmallSize = controller.isSmallWindow()
                        )
                        ActionButton(
                            text = "Convert",
                            onClick = { controller.generateSvgData() },
                            isDark = controller.isDark
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            "The Image Vector code:",
                            modifier = Modifier.width(300.dp),
                            style = getBaseType(controller.isDark).body2
                        )
                        CodeEdit(
                            value = TextFieldValue(controller.imageVectorCode),
                            selected = true,
                            onValueChange = { },
                            isDark = controller.isDark,
                            isSmallSize = controller.isSmallWindow()
                        )
                        ActionBar(
                            buttonText = "Copy",
                            onClick = { controller.copyImageVector() },
                            selected = true,
                            value = controller.iconName,
                            onValueChange = { controller.replaceImageVectorCode(it) },
                            isDark = controller.isDark
                        )
                    }
                }

            }
            ImageView(
                isDark = controller.isDark,
                imageVector = controller.imageVector,
                onDarkClick = { controller.isDark = !controller.isDark }
            )
        }
    }
}