package com.example.eduardopalacios.sharedpreferencesejercicio;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView nombre,correo;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle bundle= getIntent().getExtras();

        btnReset=findViewById(R.id.btnResetear);

        nombre=findViewById(R.id.TvNombre);
        correo=findViewById(R.id.TvCorreo);

        nombre.setText("Nombre: "+bundle.getString("nombre"));
        correo.setText("Correo: "+bundle.getString("correo"));


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Se resetea shared preferences

                SharedPreferences preferences=getSharedPreferences("Preferencias",MODE_PRIVATE);
                SharedPreferences.Editor resetear=preferences.edit();
                resetear.clear().commit();

            }
        });

    }
}
