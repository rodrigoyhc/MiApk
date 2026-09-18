package com.example.miapk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.ThumbDown
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.miapk.ui.theme.MiApkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiApkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen()
                }
            }
        }
    }
}

@Composable
fun Screen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Series Favoritas", fontSize = 30.sp, color = Color.Black, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize(Alignment.Center)
                    .border(width = 1.dp, color = Color.Black, shape = RectangleShape),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.parkandrec),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text("Serie Favorita", fontSize = 20.sp, color = Color.Black)
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Mas",
                    tint = Color.Red,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(5.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize(Alignment.Center)
                    .border(width = 1.dp, color = Color.Black, shape = RectangleShape),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.himym),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text("Mal Final", fontSize = 20.sp, color = Color.Black)
                Icon(
                    imageVector = Icons.Filled.ThumbDown,
                    contentDescription = "Mas",
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize(Alignment.Center)
                    .border(width = 1.dp, color = Color.Black, shape = RectangleShape),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = "https://m.media-amazon.com/images/S/pv-target-images/61e2d0ea20f0c387a7f63409bccb70d43831d33d14e745c59e576a47b4556b18.jpg",
                    contentDescription = "Imagen Tom:",
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text("Buenos Cold Open", fontSize = 20.sp, color = Color.Black)
                Icon(
                    imageVector = Icons.Filled.Mood,
                    contentDescription = "Mas",
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize(Alignment.Center)
                    .border(width = 1.dp, color = Color.Black, shape = RectangleShape),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.tgp),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text("Gran Final", fontSize = 20.sp, color = Color.Black)
                Icon(
                    imageVector = Icons.Filled.ThumbUp,
                    contentDescription = "Mas",
                    tint = Color.Blue,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}