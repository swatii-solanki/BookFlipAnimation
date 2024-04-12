package com.bookflipanimation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun BookBack(angle: Float, cornerRadius: Float) {
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
            .width(150.dp)
            .height(200.dp)
            .background(Color.Transparent)
            .zIndex(if (angle < -90f) 1f else 0f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {

            Text(text = "200", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)

            Text(text = "Reviews", fontSize = 14.sp, fontWeight = FontWeight.Normal)

            Spacer(modifier = Modifier.height(6.dp))

            Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color.LightGray)

            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "4.79", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                Icon(imageVector = Icons.Rounded.Star, contentDescription = "star")
            }

            Text(text = "Rating", fontSize = 14.sp, fontWeight = FontWeight.Normal)

            Spacer(modifier = Modifier.height(6.dp))

            Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color.LightGray)

            Spacer(modifier = Modifier.height(6.dp))

            Text(text = "5", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)

            Text(text = "Years Hosting", fontSize = 14.sp, fontWeight = FontWeight.Normal)
        }
    }
}