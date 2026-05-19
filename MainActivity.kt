package com.meridian.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MeridianAppShell() }
    }
}

@Composable
fun MeridianAppShell() {
    val dark = Color(0xFF11100F)
    val paper = Color(0xFFFFF3D8)
    val gold = Color(0xFFD8AD3D)
    val green = Color(0xFF0F6F48)

    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = green,
            secondary = gold,
            background = dark,
            surface = paper
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(Color(0xFF070604), Color(0xFF14100C))))
                .padding(10.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                MeridianHeader()
                Spacer(Modifier.height(10.dp))
                MeridianBinderPlaceholder()
            }
        }
    }
}

@Composable
private fun MeridianHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
            .background(Color(0xFF1D1712), RoundedCornerShape(18.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF231A12), RoundedCornerShape(14.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("M", color = Color(0xFFF5D979), fontSize = 28.sp, fontWeight = FontWeight.Black, fontFamily = FontFamily.Serif)
        }
        Spacer(Modifier.width(12.dp))
        Column {
            Text("MERIDIAN", color = Color(0xFFFFF3D0), fontSize = 24.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
            Text("Creative Workflow OS", color = Color(0xFFCDBB8B), fontSize = 12.sp)
        }
    }
}

@Composable
private fun MeridianBinderPlaceholder() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F6F48), RoundedCornerShape(22.dp))
            .padding(10.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf("Schedule", "Clients", "Supplies").forEach { label ->
                Button(onClick = {}, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)) { Text(label) }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFF3D8), RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .padding(16.dp)
        ) {
            Text("Calendar + Agenda", fontSize = 24.sp, fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold, color = Color(0xFF2B1C0B))
            Spacer(Modifier.height(8.dp))
            Text("Blank first-run Android foundation. No demo data seeded.", color = Color(0xFF725D36))
        }
    }
}
