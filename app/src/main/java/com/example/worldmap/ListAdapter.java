package com.example.worldmap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<String>  {

    private  ArrayList<String> v_values;
    private ArrayList<Country> v_spinnerAfrica;
    private ArrayList<Country> v_spinnerEurope;
    private ArrayList<Country> v_spinnerAustralia_Oceania;
    private ArrayList<Country> v_spinnerCentral_America;
    private ArrayList<Country> v_spinnerCentral_Asia;
    private ArrayList<Country> v_spinnerEast_Southeast_Asia;
    private ArrayList<Country> v_spinnerMiddle_East;
    private ArrayList<Country> v_spinnerNorth_America;
    private ArrayList<Country> v_spinnerSouth_America;
    private ArrayList<Country> v_spinnerSouth_Asia;
    private Context mcontext;
    private Country c1;
    //ListView lv;

    public ListAdapter(Context context, ArrayList<String> values,ArrayList<Country> v,ArrayList<Country> v2,ArrayList<Country>  v3,ArrayList<Country> v4,ArrayList<Country> v5,ArrayList<Country> v6,ArrayList<Country> v7,ArrayList<Country> v8,ArrayList<Country>  v9,ArrayList<Country> v10){
        super(context,R.layout.listview_item_countries,values);
        this.mcontext=context;
        this.v_values=values;
        this.v_spinnerEurope=v;
        this.v_spinnerAfrica=v2;
        this.v_spinnerAustralia_Oceania=v3;
        this.v_spinnerCentral_America=v4;
        this.v_spinnerCentral_Asia=v5;
        this.v_spinnerEast_Southeast_Asia=v6;
        this.v_spinnerMiddle_East=v7;
        this.v_spinnerNorth_America=v8;
        this.v_spinnerSouth_America=v9;
        this.v_spinnerSouth_Asia=v10;

    }


    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull ViewGroup parent)
    {


        LayoutInflater inflater = (LayoutInflater) mcontext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View rowView = inflater.inflate(R.layout.listview_item_countries, parent, false);

        final int position_p=position;

        final TextView textView = (TextView) rowView.findViewById(R.id.lvItem);
        textView.setText(v_values.get(position));

       // lv=(ListView)rowView.findViewById(R.id.lvCountries);
       // rowView=inflater.inflate(R.layout.spinner_countries_fragm,parent,true);
        //parent.addView(spinner);
        //TextView tvSpinner=(TextView) rowView.findViewById(R.id.txViewSpinner);

        final Spinner spinner1=(Spinner)rowView.findViewById(R.id.lvSpinner);

        if(v_values.get(position).equalsIgnoreCase("Africa")){
         SpinnerAdapter adapterSpinner= new SpinnerAdapter(this.getContext(),v_spinnerAfrica);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(adapterSpinner);



        }

        if(v_values.get(position).equalsIgnoreCase("Europe")){
            SpinnerAdapter adapterSpinner= new SpinnerAdapter(this.getContext(),v_spinnerEurope);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(adapterSpinner);

            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    Object obj = parent.getItemAtPosition(position);
                    c1 = (Country) obj;
                    Log.v("country selectd spinn: ",c1.toString());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

        if(v_values.get(position).equalsIgnoreCase("Central America")){
            SpinnerAdapter adapterSpinner= new SpinnerAdapter(this.getContext(),v_spinnerCentral_America);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(adapterSpinner);


            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    Object obj = parent.getItemAtPosition(position);
                    c1 = (Country) obj;
                    Log.v("country selectd spinn: ",c1.toString());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
        if(v_values.get(position).equalsIgnoreCase("Central Asia")){
            SpinnerAdapter adapterSpinner= new SpinnerAdapter(this.getContext(),v_spinnerCentral_Asia);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(adapterSpinner);


            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    Object obj = parent.getItemAtPosition(position);
                    c1 = (Country) obj;
                    Log.v("country selectd spinn: ",c1.toString());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

        if(v_values.get(position).equalsIgnoreCase("East & Southeast Asia")){
            SpinnerAdapter adapterSpinner= new SpinnerAdapter(this.getContext(),v_spinnerEast_Southeast_Asia);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(adapterSpinner);

            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    Object obj = parent.getItemAtPosition(position);
                    c1 = (Country) obj;
                    Log.v("country selectd spinn: ",c1.toString());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

        if(v_values.get(position).equalsIgnoreCase("Middle East")){
            SpinnerAdapter adapterSpinner= new SpinnerAdapter(this.getContext(),v_spinnerMiddle_East);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(adapterSpinner);

            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    Object obj = parent.getItemAtPosition(position);
                    c1 = (Country) obj;
                    Log.v("country selectd spinn: ",c1.toString());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

        if(v_values.get(position).equalsIgnoreCase("North America")){
            SpinnerAdapter adapterSpinner= new SpinnerAdapter(this.getContext(),v_spinnerNorth_America);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(adapterSpinner);

            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    Object obj = parent.getItemAtPosition(position);
                    c1 = (Country) obj;
                    Log.v("country selectd spinn: ",c1.toString());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

        if(v_values.get(position).equalsIgnoreCase("South America")){
            SpinnerAdapter adapterSpinner= new SpinnerAdapter(this.getContext(),v_spinnerSouth_America);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(adapterSpinner);

            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    Object obj = parent.getItemAtPosition(position);
                    c1 = (Country) obj;
                    Log.v("country selectd spinn: ",c1.toString());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

        if(v_values.get(position).equalsIgnoreCase("South Asia")){
            SpinnerAdapter adapterSpinner= new SpinnerAdapter(this.getContext(),v_spinnerSouth_Asia);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(adapterSpinner);


            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    Object obj = parent.getItemAtPosition(position);
                    c1 = (Country) obj;
                    Log.v("country selectd spinn: ",c1.toString());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

        if(v_values.get(position).equalsIgnoreCase("Australia & Oceania")){
            SpinnerAdapter adapterSpinner= new SpinnerAdapter(this.getContext(),v_spinnerAustralia_Oceania);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(adapterSpinner);

            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    Object obj = parent.getItemAtPosition(position);
                    c1 = (Country) obj;
                    Log.v("country selectd spinn: ",c1.toString());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


        }

        textView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        Object obj = parent.getItemAtPosition(position);
                        c1 = (Country) obj;
                        Log.v("country selectd spinn: ",c1.toString());

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                Intent intent=new Intent(getContext(),ViewCountry.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle=new Bundle();
                bundle.putSerializable("object_country",c1);
                Log.v("in text view click:",c1.toString());
                intent.putExtras(bundle);
                rowView.getContext().startActivity(intent);
            }
        });


        return rowView;

    }
}
