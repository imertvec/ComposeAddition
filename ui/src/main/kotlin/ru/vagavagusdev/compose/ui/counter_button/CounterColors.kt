package ru.vagavagusdev.compose.ui.counter_button

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class CounterColors(
    val containerColor: Color,
    val disabledContainerColor: Color,
    val contentColor: Color,
    val disabledContentColor: Color,
)