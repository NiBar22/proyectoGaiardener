package com.novex.gaiardener.uiScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.novex.gaiardener.R
import com.novex.gaiardener.uiScreens.components.CircularIcon

@Composable
fun PlantDetailScreen(
    navController: NavController,
    plantName: String,
    scientificName: String,
    description: String,
    imageRes: Int
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF7BA05B))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Botón de regreso
            Box(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 30.dp),
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

            Spacer(modifier = Modifier.height(10.dp))

            // Nombre de la planta (fuera de la tarjeta)
            Text(
                text = plantName.uppercase(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tarjeta con la información de la planta
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
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

                    Spacer(modifier = Modifier.height(12.dp))

                    Column(modifier = Modifier.padding(16.dp)) {
                        // Nombre científico
                        Text(
                            text = scientificName,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Descripción de la planta
                        Text(
                            text = description,
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón ESCANEAR
            Button(
                onClick = { /* funcionalidad con el Arduino */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCFB53B)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(50.dp)
            ) {
                Text(text = "ESCANEAR", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}
