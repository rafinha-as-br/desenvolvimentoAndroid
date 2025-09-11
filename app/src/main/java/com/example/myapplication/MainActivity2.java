package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity2 extends AppCompatActivity {

    FrameLayout frameLayout;
    Button buttonA, buttonB;

    FragmentoA fragmentoA;
    FragmentoB fragmentoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonA = findViewById(R.id.buttonFragA);
        buttonB = findViewById(R.id.buttonFragB);

        frameLayout = findViewById(R.id.frameLayoutMain);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        buttonA.setOnClickListener(v -> {
            if(fragmentoA == null){
                fragmentoA = new FragmentoA();
            }
            fragmentTransaction.replace(R.id.frameLayoutMain, fragmentoA);
            fragmentTransaction.commit();
        });

        buttonB.setOnClickListener(v -> {
            if(fragmentoB == null){
                fragmentoB = new FragmentoB();
            }

            Bundle bundle = new Bundle();
            bundle.putString("msg", "Olá");
            fragmentoB.setArguments(bundle);

            fragmentTransaction.replace(R.id.frameLayoutMain, fragmentoB);
            fragmentTransaction.commit();
        });



    }
}