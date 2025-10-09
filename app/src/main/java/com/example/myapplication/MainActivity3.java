package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {


    ListView listView;

    ControllerPlaneta controllerPlaneta;

    EditText editText;

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);



        editText = findViewById(R.id.textField);

        PlanetaAdapter adapter = new PlanetaAdapter(this, R.layout.itemlista, controllerPlaneta.getPlanetas());



        listView = findViewById(R.id.listView);


        button = findViewById(R.id.button);
        listView.setAdapter(adapter);

        button.setOnClickListener(click -> {

            adapter.notifyDataSetChanged();

        });

        listView.setOnItemClickListener(
                (parent, view, position, id)->{

                    Toast.makeText(
                            getApplicationContext(),
                            "Planeta clicado: " + controllerPlaneta.get(position).nome,
                            Toast.LENGTH_SHORT).show();

        });

        listView.setOnItemLongClickListener(
                (parent, view, position, id)-> {
                    adapter.notifyDataSetChanged();
                    return true;
                });



    }

}