package com.example.cellularfilling

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cellularfilling.ui.theme.CellularFillingTheme

@Composable
fun MainScreen(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF24003D))
            .padding(24.dp)
    ) {
        Text(
            text = "Клеточное наполнение",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        val items = listOf(
            Pair(listOf("Мертвая", "или притворяется"), Color(0xFF90EE90)),
            Pair(listOf("Живая", "и шевелится!"), Color(0xFFFFD700)),
            Pair(listOf("Живая", "и шевелится!"), Color(0xFFFFD700)),
            Pair(listOf("Живая", "и шевелится!"), Color(0xFFFFD700)),
            Pair(listOf("Жизнь", "Ку-ку!"), Color(0xFFBA55D3))
        )

        items.forEach { (title, color) ->
            ItemCard(title[0], title[1], color)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8A2BE2)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "СОТВОРИТЬ", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun ItemCard(title: String, subtitle: String, color: Color) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(color, shape = CircleShape)
            ) {
                // Здесь можно добавить иконку, если необходимо
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = subtitle, color = Color.Gray, fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CellularFillingTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MainScreen(innerPadding)
        }
    }
}
