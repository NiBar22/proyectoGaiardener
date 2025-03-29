package com.novex.gaiardener.uiScreens.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

@Composable
fun CircularIcon(
    iconResId: Int,
    iconColor: Color = Color.White,
    bubbleColor: Color = Color.Gray,
    size: Int = 60,
    iconSize: Int = 40,
    isPngIcon: Boolean = false,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size.dp)
            .background(bubbleColor, shape = CircleShape)
            .clickable(enabled = onClick != null) { onClick?.invoke() }
    ) {
        if (isPngIcon) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(iconSize.dp)
            )
        } else {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(iconSize.dp)
            )
        }
    }
}

