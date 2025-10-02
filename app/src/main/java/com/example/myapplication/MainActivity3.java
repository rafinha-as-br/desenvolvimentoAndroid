package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity3 extends AppCompatActivity {

    Button button;
    EditText edPeso, edAltura, nomeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button = findViewById(R.id.button);
        edPeso=findViewById(R.id.edPeso);
        edAltura=findViewById(R.id.edAltura);
        nomeUser=findViewById(R.id.nomeUser);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


        button.setOnClickListener(v->{
            Intent intent = new Intent(this, IMCresultado.class);

            Float peso = Float.parseFloat(edPeso.getText().toString());
            Float altura = Float.parseFloat(edAltura.getText().toString());
            String nome = nomeUser.getText();

            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("nome", nome);

            startActivity(intent);


        });
    }
}