package jc.dam.lectorasincronoapp

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow

object Datos {

    var archivo = 0

}


/**
 * Estados del proceso de carga de la aplicación
 */
enum class Estados(val boton_activo: Boolean) {
        INICIO(boton_activo = true),
        CARGANDO(boton_activo = false),
        FINALIZADO(boton_activo = true);

}

