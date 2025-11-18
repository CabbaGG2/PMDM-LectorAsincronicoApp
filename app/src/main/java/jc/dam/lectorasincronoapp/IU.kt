package jc.dam.lectorasincronoapp

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.collections.get
import androidx.compose.material3.Text
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.LocalLifecycleOwner
import kotlinx.coroutines.delay

@Composable
fun IU(miViewModel: MyViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "ESTADO: ${miViewModel.estadoLiveData.value}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Text(
            text = "CARGANDO...",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Boton(miViewModel)
    }
}

@Composable
fun Boton(miViewModel: MyViewModel) {

    //para buscar los el logcat
    val TAG_LOG = "miDebug"

    //Esta variable rastrea el estado del boton
    var _activo by remember { mutableStateOf(miViewModel.estadoLiveData.value!!.boton_activo) }

    miViewModel.estadoLiveData.observe(LocalLifecycleOwner.current) {
        _activo = miViewModel.estadoLiveData.value!!.boton_activo
    }

    Button(
        enabled = _activo,
        colors = ButtonDefaults.buttonColors(Color.Green),
        onClick = {
            miViewModel.crearArchivoRandom()
            Log.d(TAG_LOG, "Dentro del boton descargar - Estado: ${miViewModel.estadoLiveData.value!!.name}")
        }
    ) {
        Text(text = "DESCARGAR")
    }
}

@Preview
@Composable
fun IUPreview(){
    IU(MyViewModel())
}