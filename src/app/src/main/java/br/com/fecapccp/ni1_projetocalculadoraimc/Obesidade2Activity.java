package br.com.fecapccp.ni1_projetocalculadoraimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Obesidade2Activity extends AppCompatActivity {

    public Button btnT7Fechar;
    public String peso;
    public String altura;
    public String imc;
    public TextView txtT7Peso;
    public TextView txtT7Altura;
    public TextView txtT7Imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade2);
        btnT7Fechar = findViewById(R.id.btnT7Fechar);
        txtT7Peso = findViewById(R.id.txtT7Peso);
        txtT7Altura = findViewById(R.id.txtT7Altura);
        txtT7Imc = findViewById(R.id.txtT7Imc);

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getString("peso");
        altura = bundle.getString("altura");
        imc = bundle.getString("imc");

        txtT7Peso.setText("Peso: " + peso);
        txtT7Altura.setText("Altura: " + altura);
        txtT7Imc.setText("IMC: " + imc);

        btnT7Fechar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}