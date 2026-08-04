package com.seanchen.widget.ui.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.seanchen.widget.ui.theme.SpacePaddingMedium
import com.seanchen.widget.ui.theme.TitleLarge
import com.seanchen.widget.ui.theme.TitleWithLine

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    title: Any? = null,
    lineTitle: Any? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SpacePaddingMedium)
        ) {
            when {
                // 带装饰线的标题
                lineTitle != null -> TitleWithLine(
                    text = when (lineTitle) {
                        is Int -> stringResource(id = lineTitle)
                        is String -> lineTitle
                        else -> ""
                    }
                )

                // 普通标题
                title != null -> Text(
                    text = when (title) {
                        is Int -> stringResource(id = title)
                        is String -> title
                        else -> ""
                    },
                    style = TitleLarge
                )
            }
            content()
        }
    }
}