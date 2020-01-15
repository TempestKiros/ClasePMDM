package com.borja.dialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.borja.dialogos.dialogos.DialogoInformacion;
import com.borja.dialogos.dialogos.DialogoItems;
import com.borja.dialogos.dialogos.DialogoMultipleItem;
import com.borja.dialogos.dialogos.DialogoPerso;
import com.borja.dialogos.dialogos.DialogoSINOPerso;
import com.borja.dialogos.dialogos.DialogoSiNo;
import com.borja.dialogos.dialogos.DialogoSingleItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DialogoSiNo.OnDialogoSINOListener, DialogoItems.OnDialogoItemSelected,
        DialogoSingleItem.OnDialogoSingleItemSelected {

    Button btnDialogoInfo, btnDialogoSiNo, btnDialogoSiNoPerso, btnDialogoItems, btnDialogoSigle,
            btnDialogoMultiple, btnDialogoPerso;
    TextView respuestaSINO, respuestaSINOPerso, respuestaItems, respuestaSingle, respuestaMultiple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        btnDialogoInfo.setOnClickListener(this);
        btnDialogoSiNo.setOnClickListener(this);
        btnDialogoSiNoPerso.setOnClickListener(this);
        btnDialogoItems.setOnClickListener(this);
        btnDialogoSigle.setOnClickListener(this);
        btnDialogoMultiple.setOnClickListener(this);
        btnDialogoPerso.setOnClickListener(this);
    }

    private void instancias() {
        btnDialogoInfo = findViewById(R.id.boton_dialogo_informacion);
        btnDialogoSiNo = findViewById(R.id.boton_dialogo_sino);
        btnDialogoSiNoPerso = findViewById(R.id.boton_dialogo_perso_sino);
        btnDialogoItems = findViewById(R.id.boton_dialogo_item);
        btnDialogoSigle = findViewById(R.id.boton_dialogo_singleitem);
        btnDialogoMultiple = findViewById(R.id.boton_dialogo_multipleitem);
        btnDialogoPerso = findViewById(R.id.boton_dialogo_perso);
        respuestaSINO = findViewById(R.id.texto_sino_respuesta);
        respuestaSINOPerso = findViewById(R.id.texto_sino_perso_respuesta);
        respuestaItems = findViewById(R.id.texto_item_respuesta);
        respuestaSingle = findViewById(R.id.texto_singleitem_respuesta);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boton_dialogo_informacion:
                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(getSupportFragmentManager(), "ejemplo");
                break;
            case R.id.boton_dialogo_sino:
                DialogoSiNo dialogoSiNo = new DialogoSiNo();
                dialogoSiNo.show(getSupportFragmentManager(), "ejemplo");
                break;
            case R.id.boton_dialogo_perso_sino:
                DialogoSINOPerso dialogoSINOPerso = DialogoSINOPerso.newInstance("Borja");
                dialogoSINOPerso.show(getSupportFragmentManager(), "perso");
                break;
            case R.id.boton_dialogo_item:
                DialogoItems dialogoItems = new DialogoItems();
                dialogoItems.show(getSupportFragmentManager(), "items");
                break;
            case R.id.boton_dialogo_singleitem:
                DialogoSingleItem dialogoSingleItem = new DialogoSingleItem();
                dialogoSingleItem.show(getSupportFragmentManager(), "single");
                break;
            case R.id.boton_dialogo_multipleitem:
                DialogoMultipleItem dialogoMultipleItem = new DialogoMultipleItem();
                dialogoMultipleItem.show(getSupportFragmentManager(), "multi");
                break;

            case R.id.boton_dialogo_perso:
                DialogoPerso dialogoPerso = new DialogoPerso();
                dialogoPerso.show(getSupportFragmentManager(),"perso");
                break;
        }
    }

    @Override
    public void onDialogoSelected(String s) {
        //Toast.makeText(getApplicationContext(),
        //        "la opcion seleccionada es "+s,Toast.LENGTH_SHORT).show();
        respuestaSINO.setText(s);
    }

    @Override
    public void onItemSelected(String s) {
        respuestaItems.setText(s);
    }

    @Override
    public void onSingleItemSelected(String item) {
        respuestaSingle.setText(item);
    }
}