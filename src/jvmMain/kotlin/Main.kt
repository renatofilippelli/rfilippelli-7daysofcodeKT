import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.jetbrains.skia.Image
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.net.URL
import javax.imageio.ImageIO

@Composable
fun App() {
    MaterialTheme {
        val imageUrl = "https://br.web.img3.acsta.net/r_1920_1080/medias/nmedia/18/63/93/01/18948378.jpg"
        Column {
            Text("WALL-E")
            Image(
                bitmap = imageUrl.loadImageBitmap(),
                contentDescription = "WALL-E",
                modifier = Modifier.width(200.dp)
            )
            Text("Nota : 8.4 - Ano : 2008")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "IMDB") {
        App()
    }
}

fun String.loadImageBitmap(): ImageBitmap {
    val inputStream = BufferedInputStream(
        URL(this).openStream()
    )
    val bufferedImage = ImageIO.read(inputStream)

    val stream = ByteArrayOutputStream()
    ImageIO.write(bufferedImage, "png", stream)
    val byteArray = stream.toByteArray()

    return Image.makeFromEncoded(byteArray).toComposeImageBitmap()
}