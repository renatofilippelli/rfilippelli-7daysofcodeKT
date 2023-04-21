import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import extensions.loadImageBitmap

@Composable
fun App() {

    val imageUrl = "https://br.web.img3.acsta.net/r_1920_1080/medias/nmedia/18/63/93/01/18948378.jpg"

    MaterialTheme (
        colors = darkColors()
    ){
        Surface {
            Box() {
                Column(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(10.dp)
                ) {
                    Image(
                        bitmap = imageUrl.loadImageBitmap(),
                        contentDescription = "WALL-E",
                        modifier = Modifier
                            .width(200.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(
                                top = 8.dp,
                                start = 8.dp,
                                end = 8.dp
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.Star,
                                "ícone de estrela para nota",
                                tint = Color.Yellow,
                                modifier = Modifier.height(16.dp)
                            )
                            Text(
                                text = "8.4",
                                modifier = Modifier
                                    .padding(start = 2.dp),
                                color = Color(0xffeeeeee),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Text(
                            text = "2008",
                            fontSize = 14.sp,
                            color = Color(0xffeeeeee),
                        )
                    }
                    Text(
                        text = "            WALL-E",
                        modifier = Modifier.padding(
                            start = 16.dp,
                            top = 8.dp,
                            end = 16.dp
                        ),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "IMDB") {
        App()
    }
}