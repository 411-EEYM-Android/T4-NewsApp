package com.example.tarea3.models

data class NewsSection(
    val id: Int,
    val title: String,
    val image: String,
)

val newsList = listOf(
    NewsSection(
        id = 1,
        title = "El presidente de EE.UU. no muestra signos de arrepentimiento...",
        image = "https://politicomx-politicomx-prod.web.arc-cdn.net/resizer/v2/2IAIERPW5JACDJNOHOI5FMRJFI.jpeg?auth=579656dfb27d1cfaa744adf6e475b2c3158b59e5dbda7d2a4ea8c3c528629874&quality=55&width=800&height=533"
    ),
    NewsSection(
        id = 2,
        title = "Mitos sobre Egipto",
        image = "https://res.cloudinary.com/aenetworks/image/upload/c_fill,ar_2,w_3840,h_1920,g_auto/dpr_auto/f_auto/q_auto:eco/v1/ancient-egypt-gettyimages-1380542442?_a=BAVAZGB00"
    ),
    NewsSection(
        id = 3,
        title = "Gigantes tecnológicos: La nueva era de la IA",
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSajqb1-jXv-oMQJYOA6Kb3Vhb9Nf7YIwkmCg&s"
    ),
    NewsSection(
        id = 4,
        title = "El rover de Marte envía nuevas imágenes del cráter",
        image = "https://images.unsplash.com/photo-1614728894747-a83421e2b9c9"
    ),
    NewsSection(
        id = 5,
        title = "Nuevos hallazgos arqueológicos en la selva de Yucatán",
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJhE2ymNd6gsSTRsO6mTcxj4TY84IjoIpnZw&s"),
    NewsSection(
        id = 6,
        title = "Criptomonedas: El mercado reacciona a las nuevas leyes",
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUMIl352_fVVHThrF-O6MHCx2TrDvqz9O8Pw&s"
    )
)