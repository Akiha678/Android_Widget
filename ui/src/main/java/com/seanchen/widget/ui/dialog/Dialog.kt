package com.seanchen.widget.ui.dialog

import android.app.Dialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun AppDialog(
    title: String,
    content: String? = null,
    okText: String = "确定",
    cancelText: String = "取消",
    okColor: Color = Color.Unspecified,
    onOk: () -> Unit,
    onCancel: (() -> Unit)? = null,
    onDismiss: () -> Unit
){
    val confirmColor = if (okColor == Color.Unspecified) {
        MaterialTheme.colorScheme.primary
    } else {
        okColor
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth(0.8f)
                .background(MaterialTheme.colorScheme.surface)
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 32.dp,
                            bottom = if (content != null) 16.dp else 0.dp,
                            start = 24.dp,
                            end = 24.dp
                        ),
                    fontSize = 17.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                if (content != null) {
                    Text(
                        text = content,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        fontSize = 17.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))

            }
        }
    }
}