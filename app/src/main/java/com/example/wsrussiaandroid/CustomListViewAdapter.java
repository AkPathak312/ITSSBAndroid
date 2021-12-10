package com.example.wsrussiaandroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListViewAdapter extends ArrayAdapter<String> {

    Activity context;
    String[] title,subTitle;
    public CustomListViewAdapter(@NonNull Activity context, String[] title, String[] subTitle) {
        super(context, R.layout.custom_list_view,title);
        this.context=context;
        this.title=title;
        this.subTitle=subTitle;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.custom_list_view,null,true);
        TextView txtTitle=rowView.findViewById(R.id.listTextViewTitle);
        TextView txtDate=rowView.findViewById(R.id.listTextViewDate);
        txtTitle.setText(title[position]);
        ImageView edit=rowView.findViewById(R.id.btnListEdit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return rowView;
    }
}
