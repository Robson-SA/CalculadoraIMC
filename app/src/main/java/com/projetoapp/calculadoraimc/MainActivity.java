package com.projetoapp.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botaoCalcularImc;
    private EditText campoAltura;
    private EditText campoPeso;
    private TextView textoResultado;
    private TextView imcResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa os componentes da interface usando seus IDs
        campoAltura = findViewById(R.id.taille_value);
        campoPeso = findViewById(R.id.poids_value);
        botaoCalcularImc = findViewById(R.id.calc_imc);
        textoResultado = findViewById(R.id.res_imc);
        imcResultado = findViewById(R.id.imc_result);

        // Configura a ação do botão para calcular o IMC
        botaoCalcularImc.setOnClickListener(v -> {
            try {
                // Converte os valores de entrada para double
                double altura = Double.parseDouble(campoAltura.getText().toString());
                double peso = Double.parseDouble(campoPeso.getText().toString());

                // Calcula o IMC: peso / (altura * altura)
                double imc = peso / (altura * altura);
                String resultado;

                String valorImc = String.format("%.2f", imc);

                // Determina a categoria do IMC
                if (imc > 40) {
                    resultado = "Obesidade mórbida";
                } else if (imc > 35) {
                    resultado = "Obesidade severa";
                } else if (imc >= 30) {
                    resultado = "Obesidade moderada";
                } else if (imc >= 25) {
                    resultado = "Sobrepeso";
                } else if (imc >= 18.5) {
                    resultado = "Peso normal";
                } else if (imc >= 16.5) {
                    resultado = "Magreza";
                } else {
                    resultado = "Desnutrição";
                }

                // Exibe o resultado no TextView
                textoResultado.setText(resultado);

                //Exibe o resultdo do calculo
                imcResultado.setText("IMC " + valorImc);

            } catch (NumberFormatException e) {
                // Exibe uma mensagem de erro se os campos estiverem vazios ou inválidos
                Toast.makeText(this, "Por favor, insira valores válidos para peso e altura", Toast.LENGTH_SHORT).show();
                textoResultado.setText("");
            }
        });
    }
}