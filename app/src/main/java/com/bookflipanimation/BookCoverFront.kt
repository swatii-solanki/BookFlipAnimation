package com.bookflipanimation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun BookCoverFront(angle: Float, cornerRadius: Float) {
    val shape = RoundedCornerShape(
        topEnd = 16.dp,
        bottomEnd = 16.dp,
        topStart = cornerRadius.dp,
        bottomStart = cornerRadius.dp
    )

    Card(
        shape = shape,
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .background(Color.Transparent)
            .zIndex(if (angle < -90f) 0f else 1f)
            .shadow(
                color = Color.Gray,
                offsetX = 4.dp,
                offsetY = 4.dp,
                blurRadius = 20.dp,
            )
    ) {

        Row {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(15.dp)
                    .innerShadow(
                        blur = 6.dp,
                        color = Color.Gray,
                        cornersRadius = 6.dp
                    )
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "ProfilePhoto",
                    modifier = Modifier
                        .size(100.dp)
                        .innerShadow(
                            blur = 20.dp,
                            color = Color.Gray,
                            cornersRadius = 50.dp
                        )
                        .clip(CircleShape)
                )
            }
        }
    }
}
