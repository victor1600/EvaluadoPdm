package com.example.p2ga13016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConsultarEquiposAdolfo extends AppCompatActivity {

    EditText consultar;
    ControlBDGA13016 controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_equipos_adolfo);
        consultar =findViewById(R.id.DuenoConsultar);
        controlhelper=new ControlBDGA13016(this);

    }

    public void consultarTaquilla(View view)
    {
        controlhelper.abrir();
        int numero =controlhelper.consultarEquipo(Float.parseFloat(consultar.getText().toString()));
        controlhelper.cerrar();
        Toast.makeText(this, String.valueOf(numero), Toast.LENGTH_SHORT).show();
    }
}
