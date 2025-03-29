package br.com.fecapccp.ni1_projetocalculadoraimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AbaixoDoPesoActivity extends AppCompatActivity {

    public Button btnT3Fechar;
    public String peso;
    public String altura;
    public String imc;
    public TextView txtT3Peso;
    public TextView txtT3Altura;
    public TextView txtT3Imc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abaixo_do_peso);
        btnT3Fechar = findViewById(R.id.btnT3Fechar);
        txtT3Peso = findViewById(R.id.txtT3Peso);
        txtT3Altura = findViewById(R.id.txtT3Altura);
        txtT3Imc = findViewById(R.id.txtT3Imc);

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getString("peso");
        altura = bundle.getString("altura");
        imc = bundle.getString("imc");

        txtT3Peso.setText("Peso: " + peso);
        txtT3Altura.setText("Altura: " + altura);
        txtT3Imc.setText("IMC: " + imc);

        btnT3Fechar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}