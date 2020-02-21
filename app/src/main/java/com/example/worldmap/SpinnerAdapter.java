package com.example.worldmap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter {


    public SpinnerAdapter(Context context,ArrayList<Country> List){
        super(context,0,List);

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


       View listViewItem=convertView;
       if(listViewItem==null){
           listViewItem=LayoutInflater.from(getContext()).inflate(R.layout.spinner_countries_fragm,parent,false);
       }

        Country c= (Country) getItem(position);
        TextView tv=(TextView)listViewItem.findViewById(R.id.txViewSpinner);
        tv.setText(c.getName());
        return listViewItem;
    }
}
