package com.coderscastle.jetpack_loadimagewithcoil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.coderscastle.jetpack_loadimagewithcoil.ui.theme.JetpackLoadImageWithCoilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackLoadImageWithCoilTheme {

                val imageUrl = "https://logos-world.net/wp-content/uploads/2020/11/Deadpool-Logo.png"

                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                )
            }
        }
    }
}

