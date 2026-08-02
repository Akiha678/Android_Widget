package com.seanchen.widget.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/** Semantic colors that are not represented directly by Material 3's [androidx.compose.material3.ColorScheme]. */
@Immutable
data class AppSemanticColors(
    val success: Color,
    val warning: Color,
    val danger: Color,
    val info: Color,
    val onStatus: Color,
)

/** Shared spacing scale. Components should use these values instead of introducing one-off spacing. */
@Immutable
data class AppSpacing(
    val none: Dp = 0.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 12.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 24.dp,
    val huge: Dp = 32.dp,
)

internal val LocalAppSemanticColors = staticCompositionLocalOf<AppSemanticColors> {
    error("App semantic colors are unavailable. Wrap content in AppTheme.")
}

internal val LocalAppSpacing = staticCompositionLocalOf { AppSpacing() }

/** Entry point for XinComponent design tokens. */
object XinTheme {
    val colors: AppSemanticColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppSemanticColors.current

    val textColors: AppTextColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTextColors.current

    val spacing: AppSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalAppSpacing.current
}
