package jc.dam.lectorasincronoapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel(): ViewModel() {

    //etiqueta del LogCat
    private val TAG_LOG = "miDebug"

    //estados de la app
    //Livedata es para actualizar la IU

    val estadoLiveData: MutableLiveData<Estados> = MutableLiveData(Estados.INICIO)

    //este va a ser nuestro archivo con peso aleatorio que se cargará
    //a distintas velocidades segun el peso del archivo.

    var _pesoArchivo = mutableStateOf(0)

    init {
        Log.d(TAG_LOG, "Inicializamos el ViewModel - Estado: ${estadoLiveData.value}")
    }

    /**
     * Simulamos cargar un archivo con un peso random
     */

    fun crearArchivoRandom() {
        //Cambio del estado
        estadoLiveData.value = Estados.CARGANDO
        _pesoArchivo.value = (0..100).random()
        Log.d(TAG_LOG,"creamos el archivo con peso random: ${_pesoArchivo.value} - Estado: ${estadoLiveData.value}")
        asignarPesoArchivo(_pesoArchivo.value)
    }

    /**
     * Asignamos el peso a una variable archivo
     */
    fun asignarPesoArchivo(peso: Int) {
        Log.d(TAG_LOG,"actualizamos archivo en Estados - Estado: ${estadoLiveData.value}")
        Datos.archivo = peso
        empezarDescarga(peso)
    }

    fun empezarDescarga(archivo: Int) {
        //velocidad_carga = archivo * 1000

        viewModelScope.launch {


            Log.d("corrutina", "empieza corrutina")
            delay(3000)
            Log.d("corrutina", ".... 3 sg")
            delay(1000)
        }
        Log.d("corrutina", "Hilo principal")

    }

}