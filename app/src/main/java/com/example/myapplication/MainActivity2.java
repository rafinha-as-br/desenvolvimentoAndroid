package com.example.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    EditText editTextMin, editTextMax;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.button);
        editTextMin = findViewById(R.id.edMin);
        editTextMax = findViewById(R.id.edMax);
        tv= findViewById(R.id.tvResultado);

        button.setOnClickListener(v-> {
            Random random = new Random();
            int min, max;
            min = Integer.parseInt(editTextMin.getText().toString() );
            max = Integer.parseInt(editTextMax.getText().toString());
            int delta = max-min;
            int sorteado = random.nextInt(delta)+min;

            tv.setText(Integer.toString(sorteado));

        });



    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("sorteado", tv.getText().toString());
    }



}