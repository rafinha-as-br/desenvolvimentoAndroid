package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class IMCresultado extends AppCompatActivity {
    Button b;

    TextView tvResultado;

    FrameLayout frameLayoutA;
    FrameLayout frameLayoutB;

    FragmentA fragmentA;
    FragmentB fragmentB;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imcresultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        frameLayoutA = findViewById(R.id.frameA);
        frameLayoutB = findViewById(R.id.frameB);


        b=findViewById(R.id.buttonReturn);
        b.setOnClickListener(v->{
            finish();
        });

        Bundle bundle = getIntent().getExtras();
        float peso = bundle.getFloat("peso");
        float altura = bundle.getFloat("altura");
        String nome = bundle.getString("nome");

        float imc = peso/(altura * altura);
        tvResultado.setText(Float.toString(imc));

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if(fragmentA == null){
            fragmentA = new FragmentA();
        }
        if(fragmentB == null){
            fragmentB = new FragmentB();
        }

        Bundle bundle1 = new Bundle();
        bundle1.putFloat("imc",imc);
        bundle1.putString("nome", nome);


        fragmentTransaction.replace(R.id.frameA, fragmentA);
        fragmentTransaction.replace(R.id.frameB, fragmentB);
        fragmentTransaction.commit();

        if(imc<18.5){
            imageView.setImageResource(R.drawable.abaixopeso);
            return;
        }
        if(imc<24.9){
            imageView.setImageResource(R.drawable.normal);
            return;
        }
        if(imc<29.9){
            imageView.setImageResource(R.drawable.sobrepeso);
        }
        if(imc<34.9){
            imageView.setImageResource(R.drawable.obesidade1);
            return;
        }
        if(imc<39.9){
            imageView.setImageResource(R.drawable.obesidade2);
            return;
        }
        if(imc>40){
            imageView.setImageResource(R.drawable.obesidade3);
            return;
        }


    }
}