package br.com.fecapccp.ni1_projetocalculadoraimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SobrepesoActivity extends AppCompatActivity {

    public Button btnT5Fechar;
    public String peso;
    public String altura;
    public String imc;
    public TextView txtT5Peso;
    public TextView txtT5Altura;
    public TextView txtT5Imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobrepeso);
        btnT5Fechar = findViewById(R.id.btnT5Fechar);
        txtT5Peso = findViewById(R.id.txtT5Peso);
        txtT5Altura = findViewById(R.id.txtT5Altura);
        txtT5Imc = findViewById(R.id.txtT5Imc);

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getString("peso");
        altura = bundle.getString("altura");
        imc = bundle.getString("imc");

        txtT5Peso.setText("Peso: " + peso);
        txtT5Altura.setText("Altura: " + altura);
        txtT5Imc.setText("IMC: " + imc);

        btnT5Fechar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}