package br.com.fecapccp.ni1_projetocalculadoraimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Obesidade1Activity extends AppCompatActivity {

    public Button btnT6Fechar;
    public String peso;
    public String altura;
    public String imc;
    public TextView txtT6Peso;
    public TextView txtT6Altura;
    public TextView txtT6Imc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade1);
        btnT6Fechar = findViewById(R.id.btnT6Fechar);
        txtT6Peso = findViewById(R.id.txtT6Peso);
        txtT6Altura = findViewById(R.id.txtT6Altura);
        txtT6Imc = findViewById(R.id.txtT6Imc);

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getString("peso");
        altura = bundle.getString("altura");
        imc = bundle.getString("imc");

        txtT6Peso.setText(peso);
        txtT6Altura.setText(altura);
        txtT6Imc.setText(imc);

        btnT6Fechar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}