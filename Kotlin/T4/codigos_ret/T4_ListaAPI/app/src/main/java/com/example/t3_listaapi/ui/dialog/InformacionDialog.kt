package com.example.t3_listaapi.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t3_listaapi.R

class InformacionDialog: DialogFragment() {

    private lateinit var context: Context
    private var listener: OnInformacionDialogListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        //listener = context as OnInformacionDialogListener
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(this.context)

        builder.setTitle("Selecciona la info que quieres")
        builder.setMultiChoiceItems(R.array.informacion,null){ _, which, isChecked ->  }
        builder.setPositiveButton("OK"){_,_->}

        return builder.create()

    }
    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    interface OnInformacionDialogListener{
        fun onInformacionSelected()
    }
}


// gender,name,cell