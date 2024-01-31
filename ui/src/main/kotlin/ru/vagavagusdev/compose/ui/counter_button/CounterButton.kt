package ru.vagavagusdev.compose.ui.counter_button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle

@Composable
fun CounterButton(
    value: Int,
    onValueChanged: (Int) -> Unit,
    step: Int = 1,
    min: Int = Int.MIN_VALUE,
    max: Int = Int.MAX_VALUE,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall,
    shape: Shape = CircleShape,
    decrementButton: (@Composable (enabled: Boolean, onClick: () -> Unit) -> Unit)? = null,
    incrementButton: (@Composable (enabled: Boolean, onClick: () -> Unit) -> Unit)? = null,
    colors: CounterColors = CounterColorsDefaults.colors()
) {
    val decrementCondition = value - step >= min
    val defaultDecrementButton = @Composable {
        IconButton(
            onClick = { onValueChanged(value - step) },
            enabled = decrementCondition
        ) {
            Icon(
                imageVector = Icons.Default.RemoveCircleOutline,
                contentDescription = null,
                tint = if(decrementCondition) colors.contentColor
                else colors.disabledContentColor
            )
        }
    }

    val incrementCondition = value + step <= max
    val defaultIncrementButton = @Composable {
        IconButton(
            onClick = { onValueChanged(value + step) },
            enabled = incrementCondition
        ) {
            Icon(
                imageVector = Icons.Default.AddCircleOutline,
                contentDescription = null,
                tint = if(incrementCondition) colors.contentColor
                    else colors.disabledContentColor
            )
        }
    }

    Row(
        modifier = Modifier
            .wrapContentSize()
            .clip(shape)
            .background(colors.containerColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CompositionLocalProvider(
            LocalContentColor provides colors.contentColor
        ) {
            decrementButton?.invoke(decrementCondition) {
                onValueChanged(value - step)
            }
                ?: defaultDecrementButton()

            Text(
                text = value.toString(),
                style = textStyle
            )

            incrementButton?.invoke(incrementCondition) {
                onValueChanged(value + step)
            }
                ?: defaultIncrementButton()
        }

    }
}