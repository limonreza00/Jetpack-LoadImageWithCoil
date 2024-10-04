package com.coderscastle.jetpack_loadimagewithcoil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.coderscastle.jetpack_loadimagewithcoil.ui.theme.JetpackLoadImageWithCoilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackLoadImageWithCoilTheme {

                Column (
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    LoadImage()
                }

            }
        }
    }
}

@Composable
fun LoadImage (){

    val imageUrl = "https://i.pinimg.com/736x/f3/53/ca/f353ca6dc3a99679a1ea6e3c06ebf8a2.jpg"
    Card (
        modifier = Modifier
            .padding(16.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(10.dp)
    ){

        val model = ImageRequest
            .Builder(LocalContext.current)
            .data(imageUrl)
            .size(Size.ORIGINAL)
            .crossfade(1000)
            .build()




        val imageState = rememberAsyncImagePainter(model=model).state

        if (imageState is AsyncImagePainter.State.Success){

            AsyncImage(
                modifier = Modifier
                    .padding(25.dp)
                    .clip(RoundedCornerShape(15.dp)),
                model = model,
                contentDescription = null
            )
        }

        if (imageState is AsyncImagePainter.State.Loading){
            Image(
                painter = painterResource(R.drawable.placeholder_image),
                contentDescription = null
            )
        }

        if (imageState is AsyncImagePainter.State.Error){

            Image(
                painter = painterResource(R.drawable.image_not_found),
                contentDescription = null
            )
        }

        }

}