package com.example.myapplication;

public class Evento {
    Integer id;
    float x;
    float y;
    float z;

    public Evento(Integer id, float x, float y, float z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Evento(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
