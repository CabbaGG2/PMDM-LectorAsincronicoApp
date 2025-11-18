package jc.dam.lectorasincronoapp

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
import jc.dam.lectorasincronoapp.ui.theme.LectorAsincronoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Inciamos el viewModel
        val miViewModel: MyViewModel = MyViewModel()

        setContent {
            IU(miViewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FunPreview() {
    val miViewModel: MyViewModel = MyViewModel()
    IU(miViewModel)

}