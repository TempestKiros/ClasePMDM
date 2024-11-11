package com.example.concesionario.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.concesionario.R
import com.example.concesionario.model.Modelo

class AdaptadorModelos(private val listaModelo: ArrayList<Modelo>, private val context: Context) : BaseAdapter() {

    // Número de elementos en la lista
    override fun getCount(): Int {
        return listaModelo.size
    }

    // Obtener el elemento en una posición específica
    override fun getItem(position: Int): Modelo {
        return listaModelo[position]
    }

    // Obtener el ID del elemento en una posición específica
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // Definir la representación de cada fila
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_marca, parent, false)

        // Encontrar las vistas dentro del layout
        val imagen: ImageView = view.findViewById(R.id.imageModelo)
        val texto: TextView = view.findViewById(R.id.textoModelo)

        // Obtener el modelo en la posición actual
        val modelo = listaModelo[position]

        // Asignar los valores a las vistas
        imagen.setImageResource(modelo.imagen)
        texto.text = modelo.nombre

        return view
    }
}
