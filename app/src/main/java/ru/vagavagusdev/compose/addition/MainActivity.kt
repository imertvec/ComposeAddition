package ru.vagavagusdev.compose.addition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.vagavagusdev.compose.addition.ui.theme.ComposeAdditionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAdditionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Green
                ) {

                }
            }
        }
    }
}