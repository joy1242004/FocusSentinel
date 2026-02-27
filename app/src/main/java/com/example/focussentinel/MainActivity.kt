package com.example.focussentinel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.focussentinel.ui.theme.FocusSentinelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FocusSentinelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        ModifierExperimentsPreview()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ColumnExample() {
    Column {
        Text(text = "Title")
        Text(text = "Subtitle")
        Button(onClick = {}) {
            Text("Start")
        }
    }
}

@Composable
fun RowExample() {
    Row {
        Text(text = "Back")
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "FocusSentinel")
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "Settings")
    }
}

@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .background(Color.LightGray)
    ) {
        Text(
            text = "Profile",
            modifier = Modifier.align(Alignment.Center)
        )

        Box(
            modifier = Modifier
                .size(20.dp)
                .background(Color.Red)
                .align(Alignment.TopEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MiniExperimentPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ColumnExample()
        RowExample()
        BoxExample()
    }
}

@Composable
fun ModifierOrderExample() {
    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Test A: Background → Padding",
            modifier = Modifier
                .background(Color.Yellow)
                .padding(24.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Test B: Padding → Background",
            modifier = Modifier
                .padding(24.dp)
                .background(Color.Cyan)
        )
    }
}

@Composable
fun WeightExample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red)
        )

        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxHeight()
                .background(Color.Blue)
        )
    }
}

@Composable
fun AlignmentExample() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Left Side")
            Text("Right Side")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Centered Text",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierExperimentsPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        ModifierOrderExample()
        WeightExample()
        AlignmentExample()
    }
}
@Composable
fun ImprovedNoteCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = "Shopping List",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "Milk, Bread, Eggs, Fruits",
                style = TextStyle(fontSize = 16.sp)
            )

            Text(
                text = "Updated: Today",
                style = TextStyle(fontSize = 14.sp, color = Color.Gray)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImprovedNoteCardPreview() {
    ImprovedNoteCard()
}