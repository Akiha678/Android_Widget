package com.seanchen.widget.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun AppRow(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    fillMaxWidth: Boolean = true,
    padding: Dp = 0.dp,
    content: @Composable RowScope.() -> Unit
) {
    val finalModifier = modifier
        .let { if (fillMaxWidth) it.fillMaxWidth() else it }
        .let { if (padding > 0.dp) it.padding(padding) else it }

    Row(
        modifier = finalModifier,
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment,
        content = content
    )
}

@Composable
fun CenterRow(
    modifier: Modifier = Modifier,
    fillMaxWidth: Boolean = true,
    padding: Dp = 0.dp,
    content: @Composable RowScope.() -> Unit
) {
    AppRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        fillMaxWidth = fillMaxWidth,
        padding = padding,
        content = content
    )
}