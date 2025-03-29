package br.com.fecapccp.ni1_projetocalculadoraimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Obesidade3Activity extends AppCompatActivity {

    public Button btnT8Fechar;
    public String peso;
    public String altura;
    public String imc;
    public TextView txtT8Peso;
    public TextView txtT8Altura;
    public TextView txtT8Imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade3);
        btnT8Fechar = findViewById(R.id.btnT8Fechar);
        txtT8Peso = findViewById(R.id.txtT8Peso);
        txtT8Altura = findViewById(R.id.txtT8Altura);
        txtT8Imc = findViewById(R.id.txtT8Imc);

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getString("peso");
        altura = bundle.getString("altura");
        imc = bundle.getString("imc");

        txtT8Peso.setText("Peso: " + peso);
        txtT8Altura.setText("Altura: " + altura);
        txtT8Imc.setText("IMC: " + imc);

        btnT8Fechar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}