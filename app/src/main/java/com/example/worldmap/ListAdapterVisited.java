package com.example.worldmap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapterVisited extends ArrayAdapter<VisitedCountries> {
    private  ArrayList<VisitedCountries> v_values;
    private Context mcontext;
    private String nameCountry;

    public ListAdapterVisited(Context context,ArrayList<VisitedCountries> values,String name){

        super(context,R.layout.lv_visited_countries_items,values);
        this.mcontext=context;
        this.v_values=values;
        this.nameCountry=name;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        VisitedCountries visitedCountries=(VisitedCountries) getItem(position);

        LayoutInflater inflater = (LayoutInflater) mcontext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.lv_visited_countries_items, parent, false);

        ImageView imageView=(ImageView)rowView.findViewById(R.id.imgFlg);//fac legatura cu imageview ul

        TextView textViewCountryName = (TextView) rowView.findViewById(R.id.tvNameCountry);
        textViewCountryName.setText(visitedCountries.getCountryName()); //aici s ar ptea sa fie in cazul in care nu mi va aparea pe escarn

        TextView textViewNotes=(TextView)rowView.findViewById(R.id.tvNotes);
        textViewNotes.setText(visitedCountries.getNotes());

        TextView textViewDate=(TextView)rowView.findViewById(R.id.tvDate);
        textViewDate.setText(visitedCountries.getDateStart());

        return rowView;
    }
}
