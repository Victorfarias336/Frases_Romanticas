package com.frasesromanticas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frasesromanticas.provider.FrasesProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}

@Composable
fun Home(){

    val frasesProvider = FrasesProvider()
    val frases = frasesProvider.frases

    var selecionada by remember { mutableStateOf<List<String>>(emptyList()) }

    fun sorteio(){
        val sorteio = frases.shuffled().take(1)
        selecionada = sorteio
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if (selecionada.isNotEmpty()) {
            Text(
                text = selecionada.joinToString(separator = ""),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(50.dp)
            )
        }
        Button(
            onClick = {
                sorteio()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF9400D3)
            ),
            modifier = Modifier.padding(0.dp,0.dp,0.dp,20.dp)
        ){
            Text(
                text = "clique aqui",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}
