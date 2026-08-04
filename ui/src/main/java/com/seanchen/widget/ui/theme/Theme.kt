package com.seanchen.widget.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryDefault,
    secondary = ColorPurple,
    tertiary = ColorSuccess,
    background = BgGreyDark,
    surface = BgWhiteDark,
    error = ColorDanger,
    onPrimary = TextWhite,
    onSecondary = TextWhite,
    onTertiary = TextWhite,
    onBackground = TextPrimaryDark,
    onSurface = TextPrimaryDark,
    onError = TextWhite,
    outline = BorderDark,
    surfaceVariant = BgContentDark,
    surfaceTint = BgColorDark,
    surfaceContainer = BgWhiteDark,
    surfaceContainerHigh = BgWhiteDark,
    surfaceContainerHighest = BgWhiteDark
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryDefault,
    secondary = ColorPurple,
    tertiary = ColorSuccess,
    background = BgGreyLight,
    surface = BgWhiteLight,
    error = ColorDanger,
    onPrimary = TextWhite,
    onSecondary = TextWhite,
    onTertiary = TextWhite,
    onBackground = TextPrimaryLight,
    onSurface = TextPrimaryLight,
    onError = TextWhite,
    outline = BorderLight,
    surfaceVariant = BgContentLight,
    surfaceTint = PrimaryDefault,
    surfaceContainer = BgWhiteLight,
    surfaceContainerHigh = BgWhiteLight,
    surfaceContainerHighest = BgWhiteLight
)


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    themeColor: Color = PrimaryDefault,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
){
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme){
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DarkColorScheme.copy(
            primary = themeColor,
            surfaceTint = themeColor
        )

        else -> LightColorScheme.copy(
            primary = themeColor,
            surfaceTint = themeColor
        )
    }

    val textColors = if (darkTheme) {
        AppTextColors(
            primary = TextPrimaryDark,
            secondary = TextSecondaryDark,
            tertiary = TextTertiaryDark,
            quaternary = TextQuaternaryDark,
            white = TextWhite,
            link = colorScheme.primary,
        )
    } else {
        AppTextColors(
            primary = TextPrimaryLight,
            secondary = TextSecondaryLight,
            tertiary = TextTertiaryLight,
            quaternary = TextQuaternaryLight,
            white = TextWhite,
            link = colorScheme.primary,
        )
    }

    val semanticColors = AppSemanticColors(
        success = ColorSuccess,
        warning = ColorWarning,
        danger = colorScheme.error,
        info = colorScheme.primary,
        onStatus = TextWhite,
    )

    CompositionLocalProvider(
        LocalAppTextColors provides textColors,
        LocalAppSemanticColors provides semanticColors,
        LocalAppSpacing provides AppSpacing(),
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = AppShapes,
            content = content
        )
    }
}
