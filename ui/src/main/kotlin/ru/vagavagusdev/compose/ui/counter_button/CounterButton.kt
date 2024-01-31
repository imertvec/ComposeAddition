package ru.vagavagusdev.compose.ui.counter_button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
private fun CounterButton(
    onValueChanged: (Int) -> Unit = {},
    value: Int = 0,
    step: Int = 10,
    min: Int = Int.MIN_VALUE,
    max: Int = Int.MAX_VALUE,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall,
    shape: Shape = CircleShape,
    decrementButton: (@Composable (enabled: Boolean, onClick: () -> Unit) -> Unit)? = null,
    incrementButton: (@Composable (enabled: Boolean, onClick: () -> Unit) -> Unit)? = null,
    colors: CounterColors = CounterColorsDefaults.buttonColors()
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

    val incrementCondition = value + step < max
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
            .clip(shape)
            .background(colors.containerColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        decrementButton?.invoke(decrementCondition) {
            onValueChanged(value - step)
        }
            ?: defaultDecrementButton()

        Text(text = value.toString(), style = textStyle)

        incrementButton?.invoke(incrementCondition) {
            onValueChanged(value + step)
        }
            ?: defaultIncrementButton()
    }
}

@Preview
@Composable
fun CustomCounterButton() {
    var value by remember { mutableIntStateOf(10) }

    CounterButton(
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        ),
        value = value,
        step = 10,
        min = 0,
        onValueChanged = { value = it },
        max = 109,
        shape = RoundedCornerShape(10.dp),
        colors = CounterColorsDefaults.buttonColors(
            contentColor = Color.Red,
            containerColor = Color.Green,
            disabledContentColor = Color.Gray,
            disabledContainerColor = Color.Gray

        ),
    )
}