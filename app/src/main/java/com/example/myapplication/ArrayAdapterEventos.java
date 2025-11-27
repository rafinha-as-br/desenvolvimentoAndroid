package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ArrayAdapterEventos  extends ArrayAdapter<Evento> {

    Context aContext;
    int aResource;

    public ArrayAdapterEventos(@NonNull Context context, int resource, @NonNull List<Evento> objects) {
        super(context, resource, objects);
        aContext = context;
        aResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        super.getView(position, convertView, parent);

        LayoutInflater layoutInflater = LayoutInflater.from(aContext);

        convertView = layoutInflater.inflate(aResource, parent, false);

        Evento e = getItem(position);

        TextView tv = convertView.findViewById(android.R.id.text1);
        tv.setText("ID: " + e.id.toString() + "| X: " + Float.toString(e.x) + "| Y: " + Float.toString(e.y) + "| Z: " + Float.toString(e.z) );

        return convertView;


    }
}
