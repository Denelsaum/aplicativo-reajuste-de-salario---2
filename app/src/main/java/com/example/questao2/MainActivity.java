package com.example.questao2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etSalario;
    RadioGroup rgPercentual;
    RadioButton rb40, rb45, rb50;
    Button btnCalcular, btnLimpar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSalario = findViewById(R.id.et_salario);
        rgPercentual = findViewById(R.id.rg_percentual);
        rb40 = findViewById(R.id.rb_40);
        rb45 = findViewById(R.id.rb_45);
        rb50 = findViewById(R.id.rb_50);
        btnCalcular = findViewById(R.id.btn_calcular);
        btnLimpar = findViewById(R.id.btn_limpar);
        tvResultado = findViewById(R.id.tv_resultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String salarioStr = etSalario.getText().toString();

                if (salarioStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Digite o salário!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double salario = Double.parseDouble(salarioStr);
                double percentual = 0;

                int checkedId = rgPercentual.getCheckedRadioButtonId();
                if (checkedId == R.id.rb_40) {
                    percentual = 0.40;
                } else if (checkedId == R.id.rb_45) {
                    percentual = 0.45;
                } else if (checkedId == R.id.rb_50) {
                    percentual = 0.50;
                } else {
                    Toast.makeText(MainActivity.this, "Selecione um percentual!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double novoSalario = salario + (salario * percentual);
                tvResultado.setText("Novo salário: R$ " + String.format("%.2f", novoSalario));
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSalario.setText("");
                rgPercentual.clearCheck();
                tvResultado.setText("");
            }
        });
    }
}
