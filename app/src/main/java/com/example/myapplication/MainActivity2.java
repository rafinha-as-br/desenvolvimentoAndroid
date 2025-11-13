package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity2 extends AppCompatActivity implements SensorEventListener {

    private SQLiteDatabase banco;
    SensorManager sensorManager;
    Sensor sensorLuz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        banco = this.openOrCreateDatabase("banco", getBaseContext().MODE_PRIVATE, null);

        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLuz= sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        sensorManager.registerListener(this, sensorLuz,SensorManager.SENSOR_DELAY_NORMAL);


    }

    public void inserirTabela(String nomeTabela, ContentValues values){
        this.banco.insert(nomeTabela, null, values);
    }

    public void editarTabela(String nomeTabela, String[] id, ContentValues values){
        this.banco.update(nomeTabela, values, "WHERE ID = ?", id);
    }

    public void remover(String nomeTabela, String[] id){
        this.banco.delete(nomeTabela, "WHERE ID = ?", id);
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}