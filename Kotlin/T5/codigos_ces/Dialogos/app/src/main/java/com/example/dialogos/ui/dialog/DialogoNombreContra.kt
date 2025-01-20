package com.example.dialogos.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

private lateinit var nombre: String
private lateinit var contraseña: String

class DialogoNombreContra: DialogFragment() {
s
    companion object{
        fun newInstance (nombre: String, contraseña: String): DialogoNombreContra {

            val dialog: DialogoNombreContra = DialogoNombreContra();
            val bundle: Bundle = Bundle()
            bundle.putString("nombre", nombre)
            bundle.putString("contraseña", contraseña)
            dialog.arguments = bundle

            return dialog

            }
        }
    override fun onAttach(context: Context){
        super.onAttach(context)
        // captura los datosxº
        nombre = this.arguments.getString("nombre") ?: "sin nombre"
        contraseña = this.arguments.getString("contraseña") ?: "sin contraseña"

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Confirmacion")
        builder.setMessage("Por favor XXX, confirmas que tu pass es XXX")
        return builder.create()
    }
}