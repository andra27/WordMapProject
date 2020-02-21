package com.example.worldmap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ViewCountry extends AppCompatActivity {

    Button btnBack;
    Button googleMaps;
    TextView txtNameOfTheCountry;
    ImageButton imgButton;
    TextView txtPopulation;
    TextView txtPopulationInfo;
    TextView txtOffLang;
    TextView txtOffLangInfo;
    TextView txtInfo;
    TextView txtInfoInfo;
    ImageView imgViewFlag;
    TextView txtNameCapital;
    TextView txtArea;
    TextView txtAreaInfo;
    TextView txtPopCapital;
    TextView txtPopCapitalInfo;
    TextView txtInfoCapital;
    TextView txtInfoCapitalInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_country);
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        Country c=(Country)bundle.getSerializable("object_country");

        btnBack=(Button)findViewById(R.id.btnBack);
        txtNameOfTheCountry=(TextView)findViewById(R.id.tvNameOfCountry);
        imgButton=(ImageButton)findViewById(R.id.imgAdd);
        txtPopulation=(TextView)findViewById(R.id.tvPopulation);
        txtPopulationInfo=(TextView)findViewById(R.id.tvPopulationInfo);
        txtOffLang=(TextView)findViewById(R.id.tvOffLanguage);
        txtOffLangInfo=(TextView)findViewById(R.id.tvOffLanguageInfo);
        txtInfo=(TextView)findViewById(R.id.tvInfo);
        txtInfoInfo=(TextView)findViewById(R.id.tvInfoInfo);
        //imgViewFlag=(ImageView)findViewById(R.id.imageView2);
        txtNameCapital=(TextView)findViewById(R.id.tvNameCapital);
        txtArea=(TextView)findViewById(R.id.tvArea);
        txtAreaInfo=(TextView)findViewById(R.id.tvAreaInfo);
        txtPopCapital=(TextView)findViewById(R.id.tvPopCapital);
        txtPopCapitalInfo=(TextView)findViewById(R.id.tvPopCapitalInfo);
        txtInfoCapital=(TextView)findViewById(R.id.tvCapitalInfoInfo);
        txtInfoCapitalInfo=(TextView)findViewById(R.id.tvInfoInfoCapital);
        googleMaps=(Button)findViewById(R.id.goodleMapsOpen);
        txtNameOfTheCountry.setText(c.getName().toString());
        txtPopulationInfo.setText(c.getNoOfHabitants().toString());
        txtOffLangInfo.setText(c.getLanguage().toString());
        txtInfoInfo.setText(c.getInfo().toString());
        txtNameCapital.setText(c.getCapital().getName().toString());
        txtAreaInfo.setText(c.getCapital().getSurface().toString());
        txtPopCapitalInfo.setText(c.getCapital().getNoOfHabitants().toString());
        txtInfoCapitalInfo.setText(c.getCapital().getInfo().toString());

        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"this Country was added to your list of visited countries :) ",Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        googleMaps.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GoogleMapsActivity.class);
                startActivity(intent);
            }
        });

    }
}
