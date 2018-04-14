package com.example.eduardopalacios.sharedpreferencesejercicio;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre,correo,contraseña;
    Button cancelar,aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre=findViewById(R.id.campoNombre);
        correo=findViewById(R.id.campoCorreo2);
        contraseña=findViewById(R.id.campocontraseña2);

        cancelar=findViewById(R.id.btnCancelar);
        cancelar.setOnClickListener(this);

        aceptar=findViewById(R.id.btnAceptar2);
        aceptar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.btnAceptar2)
        {
            if ((nombre.length()>0) && (contraseña.length()>0) && (evaluarContraseña(contraseña.getText().toString())==true))
            {
                SharedPreferences preferences=getSharedPreferences("Preferencias",MODE_PRIVATE);

                SharedPreferences.Editor insertar=preferences.edit();
                insertar.putString("nombre",nombre.getText().toString());
                insertar.putString("correo",correo.getText().toString());
                insertar.putString("contraseña",contraseña.getText().toString());
                insertar.commit();
                Toast.makeText(getApplicationContext(),"Valores almacenados correctamente",Toast.LENGTH_SHORT)
                        .show();


            }
        }


    }

    public boolean evaluarContraseña(String contrasenia)
    {
        // numero de caracteres menor a 8 con un valor numerico
        boolean correcto=false;
        int contadorNumero=0;
        if (contrasenia.length()<8)
        {
            for (int i=0;i<contrasenia.length();i++)
            {
                try {
                    Integer.parseInt(String.valueOf(contrasenia.charAt(i)));
                    contadorNumero++;


                }catch (Exception e)
                {

                }

            }

            if (contadorNumero==1)
            {
                correcto=true;
            }
        }

        return correcto;
    }
}
