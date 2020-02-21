package com.example.worldmap;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.worldmap.sqlite.helper.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class AddCountry extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button btnCancel;
    Button btnDone;
    TextView nameCountry;
    TextView notes;
    EditText comments;
    TextView country;
    Spinner spinnerSelectCountryy;
    TextView date;
    String nameCountrySpinner;
    String datee;
    DatePicker datePicker;
    VisitedCountries visitedCountry;
    DatabaseHelper db;
    ArrayList<Country> arrayListSpinner;
    int id_country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country2);
        btnCancel=(Button)findViewById(R.id.buttonCancel);
        btnDone=(Button)findViewById(R.id.buttonDone);
        nameCountry=(TextView)findViewById(R.id.textViewCountry);
        notes=(TextView)findViewById(R.id.tvNotes);
        comments=(EditText)findViewById(R.id.etNotes);
        country=(TextView)findViewById(R.id.tvCountry);
        spinnerSelectCountryy=(Spinner) findViewById(R.id.spinnerSelect);
        date=(TextView)findViewById(R.id.tvDate);
        datePicker=(DatePicker) findViewById(R.id.datePicker1);
        db= new DatabaseHelper(getApplicationContext());
        arrayListSpinner= new ArrayList<Country>();
        arrayListSpinner=db.getAllCountries();
        SpinnerAdapter adapterSpinner= new SpinnerAdapter(getApplicationContext(),arrayListSpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSelectCountryy.setAdapter(adapterSpinner);
        spinnerSelectCountryy.setOnItemSelectedListener(this);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                List<VisitedCountries> lis= new ArrayList<VisitedCountries>();
                final String notes=comments.getText().toString();
                datee=datePicker.getDayOfMonth()+"/"+datePicker.getMonth()+"/"+datePicker.getYear();
                lis=db.getAllVC();
                int country_ID=lis.size()+1;

                visitedCountry.setId(country_ID);
                visitedCountry.setNotes(notes);
                visitedCountry.setDateStart(datee);

                if(visitedCountry.getId()!=null && visitedCountry.getCountry()!=null && visitedCountry.getNotes()!=null && visitedCountry.getDateStart()!=null){

                     db.createVisitedCountry(visitedCountry,id_country);
                }
                finish();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });


        db.closeDB();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Object obj=parent.getItemAtPosition(position);
        final Country c=(Country)obj;
        id_country=c.getId();
        final String note=notes.getText().toString();
        visitedCountry= new VisitedCountries(c,note,datee);
        visitedCountry.setIdCountry(c.getId());
        visitedCountry.setNameCountry(c.getName());
        visitedCountry.setCountryNoOfHabitants(c.getNoOfHabitants());
        visitedCountry.setLanguageCountry(c.getLanguage());
        visitedCountry.setInfoCountry(c.getInfo());
        nameCountrySpinner=visitedCountry.toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
