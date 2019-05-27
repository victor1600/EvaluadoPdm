package com.example.p2ga13016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarPaisActivity extends AppCompatActivity {

    EditText idPais;
    ControlBDGA13016 controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_pais);
        controlhelper=new ControlBDGA13016(this);
        idPais = findViewById(R.id.PaisEliminarId);
    }

    public void eliminarpais(View v){
        String regEliminadas;
        pais pais=new pais();
        pais.setCodpais(idPais.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(pais);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }


}
