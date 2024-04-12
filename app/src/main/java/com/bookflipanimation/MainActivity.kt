package com.bookflipanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bookflipanimation.ui.theme.BookFlipAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookFlipAnimationTheme {
                FlipBook()
            }
        }
    }
}

@Preview
@Composable
fun FlipBook() {
    var rotate by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (rotate) -180f else 0f,
        label = "rotation",
        animationSpec = tween(durationMillis = 1200, easing = EaseOut)
    )

    val offset by animateFloatAsState(
        targetValue = if (rotate) 165f else 0f,
        label = "offset",
        animationSpec = tween(durationMillis = 1200, easing = EaseOut)
    )

    val cornerRadius by animateFloatAsState(
        targetValue = if (rotation < -90f) 0f else 6f,
        label = "rotation",
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray.copy(alpha = 0.3f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Box {
            FlipCard(rotation, offset, cornerRadius)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Closed")

            Spacer(modifier = Modifier.width(10.dp))

            Switch(
                checked = rotate,
                onCheckedChange = { rotate = !rotate },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.Gray,
                )
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "Open")
        }
    }
}

@Composable
fun FlipCard(angle: Float, offset: Float, cornerRadius: Float) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .offset(x = offset.dp)
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(150.dp)
                .background(Color.Transparent)
                .shadow(
                    color = Color.Gray,
                    offsetX = 4.dp,
                    offsetY = 4.dp,
                    blurRadius = 20.dp,
                )
        ) {
            BookBack(angle, cornerRadius)
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .width(150.dp)
                    .graphicsLayer(
                        transformOrigin = TransformOrigin(
                            pivotFractionX = 0f, pivotFractionY = 0.5f
                        ),
                        rotationY = angle,
                        cameraDistance = 24f
                    )
            ) {
                BookCoverBack(angle, cornerRadius)
                BookCoverFront(angle, cornerRadius)
            }
        }
    }
}