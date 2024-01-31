package ru.vagavagusdev.compose.ui.ios_item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role

@Composable
fun IosListItem(
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    shape: Shape = MaterialTheme.shapes.medium,
    enabled: Boolean = true,
    colors: IosListItemColors = IosListItemColorsDefaults.colors(),
    borderStroke: BorderStroke? = null,
    onClick: () -> Unit
) {
    ListItem(
        modifier = modifier
            .clip(shape)
            .then(
                if(borderStroke == null) Modifier else Modifier.border(borderStroke, shape)
            )
            .clickable(
                enabled = enabled,
                role = Role.Button,
                onClick = onClick
            ),
        headlineContent = text,
        trailingContent = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = "Arrow Forward"
            )
        },
        colors = ListItemDefaults.colors(
            containerColor = colors.containerColor,
            headlineColor = colors.textColor,
            trailingIconColor = colors.iconColor
        )
    )
}