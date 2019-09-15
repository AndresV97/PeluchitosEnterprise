package com.example.peluchitosenterprise.ui

interface Comunicador {
    fun enviarDatos(id:String, nombre:String, cantidad:String, precio:String)
    fun enviarEliminar(nombre:String)
}