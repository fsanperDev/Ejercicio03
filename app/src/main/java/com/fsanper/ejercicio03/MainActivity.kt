package com.fsanper.ejercicio03

import android.graphics.ColorSpace
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fsanper.ejercicio03.ui.theme.Ejercicio03Theme
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejercicio03Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintExample()
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

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.NEXUS_5,
    fontScale = 1f
)
@Composable
fun GreetingPreview() {
    Ejercicio03Theme {
        ConstraintExample()
    }
}

fun RandomColor(): Color {
    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)
    return Color(red, green, blue)
}

@Composable
fun ConstraintExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        val (boxLeftTop, boxCenterTop, boxRightTop,
            boxLeftCenter, boxCenter, boxRightCenter,
            boxLeftBottom, boxCenterBottom,boxRightBottom) = createRefs()

        Box(
            modifier = Modifier
                .size(125.dp)
                .background(RandomColor())
                .constrainAs(boxLeftTop) {
                    end.linkTo(boxCenter.start)
                    bottom.linkTo(boxCenter.top)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(RandomColor())
                .constrainAs(boxCenterTop) {
                    end.linkTo(boxRightTop.start)
                    start.linkTo(boxLeftTop.end)
                    bottom.linkTo(boxCenter.top)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(RandomColor())
                .constrainAs(boxRightTop) {
                    start.linkTo(boxCenter.end)
                    bottom.linkTo(boxCenter.top)
                }
        )
        //-----------------------------------------------//
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(RandomColor())
                .constrainAs(boxLeftCenter) {
                    end.linkTo(boxCenter.start)
                    top.linkTo(boxCenter.top)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(RandomColor())
                .constrainAs(boxCenter) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(RandomColor())
                .constrainAs(boxRightCenter) {
                    start.linkTo(boxCenter.end)
                    top.linkTo(boxCenter.top)
                }
        )
        //-----------------------------------------------//
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(RandomColor())
                .constrainAs(boxLeftBottom) {
                    end.linkTo(boxCenter.start)
                    top.linkTo(boxCenter.bottom)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(RandomColor())
                .constrainAs(boxCenterBottom) {
                    end.linkTo(boxRightBottom.start)
                    start.linkTo(boxLeftBottom.end)
                    top.linkTo(boxCenter.bottom)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(RandomColor())
                .constrainAs(boxRightBottom) {
                    start.linkTo(boxCenter.end)
                    top.linkTo(boxCenter.bottom)
                }
        )
    }
}