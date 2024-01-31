package ru.vagavagusdev.compose.ui.ios_item

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class IosListItemColors(
    val iconColor: Color,
    val textColor: Color,
    val containerColor: Color
)

object IosListItemColorsDefaults {

    @Composable
    fun colors(
        iconColor: Color = MaterialTheme.colorScheme.primary,
        textColor: Color = MaterialTheme.colorScheme.primary,
        containerColor: Color = MaterialTheme.colorScheme.primaryContainer
    ) = IosListItemColors(
        iconColor = iconColor,
        textColor = textColor,
        containerColor = containerColor
    )
}
