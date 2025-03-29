package br.com.fecapccp.ni1_projetocalculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class CalculoIMCActivity extends AppCompatActivity {


    private Button btnT2CalcularIMC;
    private Button btnT2Fechar;
    private EditText campoPeso;
    private EditText campoAltura;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo_imcactivity);

        campoPeso = findViewById(R.id.editTextT2CampoPeso);
        campoAltura = findViewById(R.id.editTextT2CampoAltura);

        btnT2CalcularIMC = findViewById(R.id.btnT2Calcular);
        btnT2Fechar = findViewById(R.id.btnT2Fechar);

        btnT2CalcularIMC.setOnClickListener(view ->{
           calcular();
        });

        btnT2Fechar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void calcular(){
        String pesoStr = campoPeso.getText().toString();
        String alturaStr = campoAltura.getText().toString();

        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            campoPeso.setError("Preencha este campo");
            campoAltura.setError("Preencha este campo");
            return;
        }

        float peso = Float.parseFloat(pesoStr);
        float altura = Float.parseFloat(alturaStr);

        float imc = peso/(altura*altura);
        DecimalFormat df = new DecimalFormat("#.##");
        String resultadoImc = df.format(imc);

        Intent intent;

        if(imc<18.5) {
            intent = new Intent(this, AbaixoDoPesoActivity.class);
        }
        else if(imc>=18.5 && imc<25){
            intent = new Intent(this, PesoNormalActivity.class);
        }
        else if(imc>=25.0 && imc<30){
            intent = new Intent(this, SobrepesoActivity.class);
        }
        else if(imc>=30.0 && imc<35){
            intent = new Intent(this, Obesidade1Activity.class);
        }
        else if(imc>=35.0 && imc<40){
            intent = new Intent(this, Obesidade2Activity.class);
        }
        else {
            intent = new Intent(this, Obesidade3Activity.class);
        }

        intent.putExtra("imc", resultadoImc);
        intent.putExtra("peso", pesoStr);
        intent.putExtra("altura", alturaStr);
        startActivity(intent);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }


    public void limpar(android.view.View view){
        campoAltura.setText("");
        campoPeso.setText("");

    }



}