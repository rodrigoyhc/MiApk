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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material.icons.filled.MoodBad
import androidx.compose.material.icons.filled.Recommend
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
import androidx.compose.ui.graphics.vector.ImageVector
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

data class Serie(
    val texto: String,
    val icono: ImageVector,
    val colorIcono: Color,
    val imagenRes: Int? = null,     // Para imágenes locales en res/drawable
    val imagenUrl: String? = null   // Para imágenes de internet
)

@Composable
fun Screen(modifier: Modifier = Modifier) {
    // 2. Listas de datos. Aquí puedes agregar más elementos fácilmente.
    val seriesArriba = listOf(
        Serie("Serie Favorita", Icons.Filled.Favorite, Color.Red, imagenRes = R.drawable.parkandrec),
        Serie("Mal Final", Icons.Filled.ThumbDown, Color.Black, imagenRes = R.drawable.himym),
        Serie("Nueva Serie", Icons.Filled.Check, Color.Blue, imagenRes = R.drawable.adults),
        Serie("Buena Favorita", Icons.Filled.Recommend, Color.Green, imagenRes = R.drawable.parkandrec),
        Serie("Buenos Cold Open", Icons.Filled.Mood, Color.Yellow, imagenUrl = "https://m.media-amazon.com/images/S/pv-target-images/61e2d0ea20f0c387a7f63409bccb70d43831d33d14e745c59e576a47b4556b18.jpg"),
        Serie("Gran Final", Icons.Filled.ThumbUp, Color.Magenta, imagenRes = R.drawable.tgp),
    )

    val seriesAbajo = listOf(
        Serie("Caricatura Favorita", Icons.Filled.Favorite, Color.Cyan, imagenRes = R.drawable.hda),
        Serie("Anime Favorita", Icons.Filled.Favorite, Color.LightGray, imagenRes = R.drawable.ttgl),
        Serie("Infancia", Icons.Filled.ChildCare, Color.Green, imagenRes = R.drawable.gumball),
        Serie("Cancelada", Icons.Filled.MoodBad, Color.Blue, imagenRes = R.drawable.avengers)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(45.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Series Favoritas",
                fontSize = 30.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(seriesArriba) { serie ->
                TarjetaSerie(serie = serie)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // LazyRow (Scroll Horizontal)
        LazyRow(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(seriesAbajo) { serie ->
                TarjetaSerie(serie = serie)
            }
        }
    }
}

@Composable
fun TarjetaSerie(serie: Serie) {
    Column(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black, shape = RectangleShape)
            .padding(bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (serie.imagenUrl != null) {
            AsyncImage(
                model = serie.imagenUrl,
                contentDescription = serie.texto,
                modifier = Modifier.size(180.dp),
                contentScale = ContentScale.Crop
            )
        } else if (serie.imagenRes != null) {
            Image(
                painter = painterResource(id = serie.imagenRes),
                contentDescription = serie.texto,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(180.dp)
            )
        }

        Spacer(modifier = Modifier.height(5.dp))
        Text(serie.texto, fontSize = 20.sp, color = Color.Black)
        Icon(
            imageVector = serie.icono,
            contentDescription = "Icono",
            tint = serie.colorIcono,
            modifier = Modifier.size(20.dp)
        )
    }
}