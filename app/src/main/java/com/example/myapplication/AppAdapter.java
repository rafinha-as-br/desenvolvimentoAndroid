package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<ApplicationInfo> {

    Context mContext;
    int mResourceLayout;

    public AppAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        convertView = inflater.inflate(mResourceLayout, parent, false);

        ImageView imageView = convertView.findViewById(R.id.imageView2);
        TextView textView = convertView.findViewById(R.id.textView);

        ApplicationInfo appInfo = getItem(position);

        if(appInfo == null){
            return convertView;
        }
        imageView.setImageDrawable(appInfo.loadIcon(mContext.getPackageManager()));
        textView.setText(appInfo.loadLabel(mContext.getPackageManager()).toString());




        return convertView;
    }










}
