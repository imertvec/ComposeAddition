package ru.vagavagusdev.compose.ui.counter_button

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object CounterColorsDefaults {

    @Composable
    fun buttonColors(
        contentColor: Color = MaterialTheme.colorScheme.surface,
        containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
        disabledContentColor: Color = MaterialTheme.colorScheme.surfaceVariant,
        disabledContainerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    ): CounterColors = CounterColors(
        contentColor = contentColor,
        containerColor = containerColor,
        disabledContentColor = disabledContentColor,
        disabledContainerColor = disabledContainerColor,
    )
}