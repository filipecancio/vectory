package ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import ui.component.atom.TabButton
import ui.component.molecule.TopBar
import ui.theme.BaseColor

@Composable
fun HomeScreen(
    controller: HomeController
) {
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
            Text("Vectory")
        }
    }
}