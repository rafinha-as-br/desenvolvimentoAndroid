package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.metrics.Event;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements SensorEventListener {

    private SQLiteDatabase banco;
    SensorManager sensorManager;
    Sensor giroscopio;
    Button salvarButton;
    TextView display;
    TextView databaseList;

    ContentValues cv;

    ListView listView;

    List<Evento> eventos;
    ArrayAdapterEventos arrayAdapterEventos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        cv = new ContentValues();
        eventos = new ArrayList<>();

        banco = this.openOrCreateDatabase("banco", getBaseContext().MODE_PRIVATE, null);
        banco.execSQL("CREATE TABLE IF NOT EXISTS eventos(id INTEGER PRIMARY KEY AUTOINCREMENT, x REAL NOT NULL, y REAL NOT NULL, z REAL NOT NULL)");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        giroscopio = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        display = findViewById(R.id.textView);
        salvarButton = findViewById(R.id.button);

        listView = findViewById(R.id.listView);

        sensorManager.registerListener(this, giroscopio,SensorManager.SENSOR_DELAY_NORMAL);
        listar();
        salvarButton.setOnClickListener(l -> {
            String id = inserirTabela("eventos", cv);
            arrayAdapterEventos.notifyDataSetChanged();
            listar();


        });

        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            Evento evento = (Evento) adapterView.getItemAtPosition(i);
            remover("eventos", evento.id);
            arrayAdapterEventos.notifyDataSetChanged();
            listar();
            return true;
        });




    }

    public void listar(){

        Cursor query = banco.rawQuery("SELECT * FROM  eventos", null);

      query.moveToLast();
        eventos.clear();
        while(!query.isBeforeFirst()){
            Evento e = new Evento(
                    query.getInt(query.getColumnIndex("id")),
                    query.getFloat(query.getColumnIndex("x")),
                    query.getFloat(query.getColumnIndex("y")),
                    query.getFloat(query.getColumnIndex("z"))
                    );
            eventos.add(e);
            query.moveToPrevious();
        }
         arrayAdapterEventos = new ArrayAdapterEventos(this, android.R.layout.simple_list_item_1, eventos);


        listView.setAdapter(arrayAdapterEventos);

    }






    public String inserirTabela(String nomeTabela, ContentValues values){
        Long id = this.banco.insert(nomeTabela, null, values);
        return id.toString();
    }

    public void editarTabela(String nomeTabela, String[] id, ContentValues values){
        this.banco.update(nomeTabela, values, "WHERE ID = ?", id);
    }

    public void remover(String nomeTabela, int id){
        this.banco.delete(nomeTabela, "id = ?", new String[] {Integer.toString(id)});
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        cv.put("x", sensorEvent.values[0]);
        cv.put("y", sensorEvent.values[1]);
        cv.put("z", sensorEvent.values[2]);



        display.setText("Giroscópio \n X: " + cv.get("x") + "\n Y: " + cv.get("y") + "\n Z: " + cv.get("z"));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}