package com.example.eduardopalacios.sharedpreferencesejercicio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView crearCuenta;
    EditText campoCorreo,campocontraseña;
    Button btnAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAceptar=findViewById(R.id.btnAceptar1);
        btnAceptar.setOnClickListener(this);

        crearCuenta=findViewById(R.id.TvCrear);
        crearCuenta.setOnClickListener(this);

        campoCorreo=findViewById(R.id.campocorreo1);
        campocontraseña=findViewById(R.id.campocontraseña1);



    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnAceptar1)
        {
            SharedPreferences preferencias = getSharedPreferences("Preferencias",MODE_PRIVATE);

            String nombre=preferencias.getString("nombre","valor no encontrado");
            String correo=preferencias.getString("correo","valor no encontrado");
            String contraseña=preferencias.getString("contraseña","valor no encontrado");


            if (campoCorreo.getText().toString().equalsIgnoreCase(correo) && campocontraseña.getText().toString().equalsIgnoreCase(contraseña))
            {

                Bundle bundle=new Bundle();
                bundle.putString("nombre",nombre);
                bundle.putString("correo",correo);

                Intent intent=new Intent(MainActivity.this,Main3Activity.class);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        }


        if (view.getId()==R.id.TvCrear)
        {
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    }
}
