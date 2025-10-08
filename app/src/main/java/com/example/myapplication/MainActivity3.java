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
    ArrayList<String> nomes;

    EditText editText;

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        nomes = new ArrayList<>(){{
            add("Apple");
            add("Banana");
            add("Cherry");
        }};

        editText = findViewById(R.id.textField);




        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>( this,
                android.R.layout.simple_list_item_1,
                nomes
        );

        button = findViewById(R.id.button);
        listView.setAdapter(adapter);

        button.setOnClickListener(click -> {

            nomes.add(editText.getText().toString());
            adapter.notifyDataSetChanged();

        });

        listView.setOnItemClickListener(
                (parent, view, position, id)->{

                    Toast.makeText(
                            getApplicationContext(),
                            "Elemento clicado: " + nomes.get(position),
                            Toast.LENGTH_SHORT).show();

        });

        listView.setOnLongClickListener(
                (parent, view, position, id)-> {
                    nomes.remove(position);
                    adapter.notifyDataSetChanged();
                    return true;
                });



    }

}