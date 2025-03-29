package br.com.fecapccp.ni1_projetocalculadoraimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PesoNormalActivity extends AppCompatActivity {

    public Button btnT4Fechar;
    public String peso;
    public String altura;
    public String imc;
    public TextView txtT4Peso;
    public TextView txtT4Altura;
    public TextView txtT4Imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_peso_normal);
        btnT4Fechar = findViewById(R.id.btnT4Fechar);
        txtT4Peso = findViewById(R.id.txtT4Peso);
        txtT4Altura = findViewById(R.id.txtT4Altura);
        txtT4Imc = findViewById(R.id.txtT4Imc);

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getString("peso");
        altura = bundle.getString("altura");
        imc = bundle.getString("imc");

        txtT4Peso.setText("Peso: " + peso);
        txtT4Altura.setText("Altura: " + altura);
        txtT4Imc.setText("IMC: " + imc);

        btnT4Fechar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}