package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool   = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado     = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view) {

        //recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        // validar os campos digitados
        Boolean camposValidados = camposValidados(precoAlcool, precoGasolina);

        if (camposValidados){

            //converter string para numeros
            double valorAlcool = Double.parseDouble(precoAlcool);
            double valorGalosina = Double.parseDouble(precoGasolina);

            //calcular menor preço
            double resultado = valorAlcool / valorGalosina;
            if(resultado >= 0.7){
                textResultado.setText("melhor utilizar Gasolina");
            }else{
                textResultado.setText("melhor utilizar Álcool");
            }
        }else{
            textResultado.setText("Prencha os preços primeiro!!!");
        }
    }

    public  boolean camposValidados(String pAlcool , String pGasolina){

        Boolean camposValidados = true;
        String campo = "preenchido";

        if (pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
            campo = "alcool";
        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
            campo = "gasolina";
        }
        return camposValidados;
    }

}