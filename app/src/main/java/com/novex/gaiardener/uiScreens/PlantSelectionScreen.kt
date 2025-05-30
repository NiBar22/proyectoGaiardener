package com.novex.gaiardener.uiScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.novex.gaiardener.uiScreens.components.CircularIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import com.novex.gaiardener.R
@Composable
fun PlantSelectionScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF7BA05B))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal= 10.dp, vertical = 35.dp)
                .verticalScroll(rememberScrollState()) // Habilita el scroll
        ) {
            Spacer(modifier = Modifier.height(20.dp))


            Text(
                text = "¡EMPECEMOS!",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp, top = 20.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Barra de búsqueda con texto y lupa
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.weight(1f),
                        decorationBox = { innerTextField ->
                            if (searchQuery.text.isEmpty()) {
                                Text("Buscar una planta", color = Color.Gray)
                            }
                            innerTextField()
                        }
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Buscar",
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Texto de bienvenida
            Text(
                text = "Bienvenido a la selección de plantas!\nContamos con una base de datos con más de 500 plantas, para comenzar:\n\n" +
                        "- Busca la planta que desees testear\n- Selecciónala y sigue el paso a paso para obtener los mejores resultados",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 10.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Tarjetas de plantas con scroll
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                repeat(10) { index ->
                    val plantName = "Planta $index"
                    val scientificName = "Scientia $index"
                    val description = "Descripción de la planta $index. lorem ipsum..."
                    val imageRes = R.drawable.plantcard

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = RoundedCornerShape(12.dp),
                        onClick = {
                            navController.navigate(
                                "plant_detail/$plantName/$scientificName/$description/$imageRes"
                            )
                        }
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = imageRes),
                                contentDescription = "Imagen de la planta",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = plantName,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                            Text(
                                text = "Información base sobre la planta...",
                                fontSize = 14.sp,
                                color = Color.Gray,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
                            )
                        }
                    }
                }

            }
        }

        // Botón de regreso 
        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp, vertical=45.dp),
            contentAlignment = Alignment.TopEnd

        ) {
            CircularIcon(
                iconResId = R.drawable.ic_back,
                iconColor = Color.White,
                bubbleColor = Color(0xFFCFB53B),
                size = 50,
                iconSize = 24,
                onClick = { navController.popBackStack() }
            )

        }
    }
}
