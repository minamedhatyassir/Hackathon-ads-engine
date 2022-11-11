package com.yassir.internal.android.hackthone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yassir.internal.android.hackthone.ui.theme.HackthoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HackthoneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    Column() {
        Image(
            painter = painterResource(R.drawable.dashboard),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth().padding(0.dp,0.dp,0.dp,8.dp)

        )
        BannersHorizontalList()
    }
}

data class banner(val img: Int, val title: String, val isAds: Boolean)

private val banners = listOf(
    banner(R.drawable.img_1, "test", true),
    banner(R.drawable.banner2, "test", true),
    banner(R.drawable.banner3, "test", true),
)

@Composable
fun BannersHorizontalList(
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(120.dp)
    ) {

        items(banners) { it ->
            bannerCard(it, Modifier.height(56.dp))
        }
    }
}

@Composable
fun bannerCard(
    item: banner,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Box(modifier = Modifier.width(192.dp).padding(horizontal = 8.dp)) {

            Text(
                text = "ADS", color= Color.Blue,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(horizontal = 16.dp).align(Alignment.TopEnd)
            )
            Column(
            ) {
                Image(
                    painter = painterResource(item.img),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HackthoneTheme {
        Greeting("Android")
    }
}