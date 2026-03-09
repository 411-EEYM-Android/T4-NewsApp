package com.example.tarea3.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.tarea3.models.NewsSection
import com.example.tarea3.models.newsList
import com.example.tarea3.ui.theme.Tarea3Theme

@Preview(showBackground = true, showSystemUi = true) // Agregada la anotación
@Composable
fun NewsScreenPreview() {
    Tarea3Theme {
        NewsScreen()
    }
}

@Composable
fun NewsScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        // 1. Buscador
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = { Text("Buscar") },
            leadingIcon = { Icon(Icons.Default.Home, contentDescription = null) },
            trailingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            shape = RoundedCornerShape(30.dp) // Aplicado directamente al shape
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 2. Tabs
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Noticias", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
            Text("Eventos", fontSize = 18.sp, color = Color.LightGray)
            Text("Clima", fontSize = 18.sp, color = Color.LightGray)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 3. Últimas Noticias (Carrusel)
        Text("Ultimas noticias", fontWeight = FontWeight.Bold, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(newsList.take(3)) { news ->
                NewsLargeCard(news)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // 4. Alrededor del mundo (Grid)
        Text("Alrededor del mundo", fontWeight = FontWeight.Bold, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(10.dp))

        // Usamos una altura fija para el Grid dentro del scroll vertical
        Box(modifier = Modifier.height(600.dp)) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                userScrollEnabled = false
            ) {
                items(newsList) { news ->
                    NewsSmallCard(news = news)
                }
            }
        }
    }
}

@Composable
fun NewsLargeCard(news: NewsSection) {
    Box(
        modifier = Modifier
            .width(280.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color(0xFF635BFF))
            .padding(20.dp)
    ) {
        Text(
            text = news.title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.Center)
        )
        Text(
            text = "marzo 08 - 2026",
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}

@Composable
fun NewsSmallCard(news: NewsSection) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.LightGray)
    ) {
        AsyncImage(
            model = news.image,
            contentDescription = news.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.LightGray.copy(alpha = 0.85f))
                .padding(8.dp)
        ) {
            Text(
                text = news.title,
                maxLines = 2,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}