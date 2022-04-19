package com.example.david.validadorpasswordkaliope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int password;

    TextView informacionTv,passwordTv;
    EditText numeroET,numeroSemanaET;
    Button generarB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        informacionTv = (TextView) findViewById(R.id.main_infoTV);
        passwordTv = (TextView)findViewById(R.id.main_password);
        numeroET = (EditText)findViewById(R.id.main_numeroET);
        numeroSemanaET = (EditText) findViewById(R.id.main_numeroSemanaET);
        generarB = (Button) findViewById(R.id.main_generarB);



        generarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    int numero = Integer.parseInt(numeroET.getText().toString());
                    int numeroSemana = Integer.parseInt(numeroSemanaET.getText().toString());

                    generarPassword(numero,numeroSemana);
                    passwordTv.setText(String.valueOf(password));
                    Toast.makeText(getApplicationContext(),"Password generado",Toast.LENGTH_SHORT).show();

                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Hay algun campo vacio o caracteres invalidos",Toast.LENGTH_SHORT).show();
                }








            }
        });



    }


    @Override
    protected void onResume() {
        super.onResume();

        String info = "Numero de Semana: " + utilidades.getNumeroSemana();
        informacionTv.setText(info);
        numeroSemanaET.setText(String.valueOf(utilidades.getNumeroSemana()));

    }

    private void generarPassword (int numero, int numeroSemana){
        int semilla = 5;
        //generamos el password segun la clase de password variable de la app kaliope 6.0
        double temporal;
        temporal = (numero + 250)*semilla;
        temporal = temporal / numeroSemana;
        temporal = temporal * numero;
        temporal = Math.sqrt(temporal);
        //redondeamos al numero inmediatamente superior
        password = (int) Math.ceil(temporal);

    }

}
