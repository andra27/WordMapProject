package com.example.worldmap;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.worldmap.sqlite.helper.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;


public class WorldMapPage extends AppCompatActivity {


    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private static FragmentManager fragmentManager;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_map_page);


        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        db= new DatabaseHelper(getApplicationContext());

        fragmentManager=getSupportFragmentManager();

        //aici iarasi ce pun in btn1
        Fragment argumentFragment=new WorldMapFragment();
        fragmentManager.beginTransaction().replace(R.id.frg,argumentFragment).commit();


        Capital ca= new Capital("Cairo","606 km2",9500000f,"Egypt, country located in the northeastern corner of Africa. Egypt s heartland, the Nile River valley and delta, was the home of one of the principal civilizations of the ancient Middle East and, like Mesopotamia farther east, was the site of one of the world’s earliest urban and literate societies. Pharaonic Egypt thrived for some 3,000 years through a series of native dynasties that were interspersed with brief periods of foreign rule.");
        Capital ca1 = new Capital("Bucharest","228 km2",1883425f," It is located in the southeast of the country, at 44°25′57″N 26°06′14″ECoordinates: 44°25′57″N 26°06′14″E, on the banks of the Dâmbovița River, less than 60 km (37.3 mi) north of the Danube River and the Bulgarian border.");
        Capital ca2= new Capital("Paris","105.4 km2",12213364f," Since the 17th century, Paris has been one of Europe's major centres of finance, diplomacy, commerce, fashion, science, and the arts. The City of Paris is the centre and seat of government of the Île-de-France, or Paris Region, which has an estimated official 2019  about 18 percent of the population of France.");
        Capital ca3= new Capital("Canberra","814.2 km2 ",420960f ," Founded following the federation of the colonies of Australia as the seat of government for the new nation, it is Australia's largest inland city and the eighth-largest city overall. The city is located at the northern end of the Australian Capital Territory.");

        ca.setId(1);
        ca1.setId(2);
        ca2.setId(3);
        ca3.setId(4);


        Country c1=new Country("Egypt", 99581200f,"Literary Arabic",ca,"It is the 3rd most populous country in Africa and the most populous in the Middle-East with the majority of its estimated 98 million people living on, or near, the banks of the Nile.");
        Country c2=new Country("Romania",20121641f,"Romana",ca1," Romania is the largest country in Southeastern Europe. It is roughly the same size as the United Kingdom and slightly smaller than the U.S. state of Oregon. The Carpathian Mountains are home to one of the largest undisturbed forests in Europe.");
        Country c3=new Country("France",67022000f,"France",ca2,"The metropolitan area of France extends from the Mediterranean Sea to the English Channel and the North Sea, and from the Rhine to the Atlantic Ocean.");
        Country c4=new Country("Australia",25555300f,"Australian",ca3,"Indigenous Australians inhabited the continent for about 65,000 years prior to European discovery[14] with the arrival of Dutch explorers in the early 17th century, who named it New Holland..");

        c1.setId(1);
        c2.setId(2);
        c3.setId(3);
        c4.setId(4);


        VisitedCountries v0=new VisitedCountries(c1,"some notes about this country ","12/12/1998");
        VisitedCountries v1=new VisitedCountries(c2,"some notes about this country ","10/09/2001");
        VisitedCountries v2=new VisitedCountries(c3,"some notes about this country ","11/07/2015");
        VisitedCountries v3=new VisitedCountries(c4,"some notes about this country ","09/11/2005");
        v0.setId(1);
        v1.setId(2);
        v2.setId(3);
        v3.setId(4);

        //      db.createCapital(ca3);
//       //      db.createCountry(c4,4);


//        db.createVisitedCountry(v0,1);
//        db.createVisitedCountry(v1,2);
//        db.createVisitedCountry(v2,3);
//        db.createVisitedCountry(v3,4);

        String one="The country with the largest surface is Russia!";
        String two="Africa has 54 countries!";
        String three="90% of the world's fresh water is in Antarctica!";

//       db.createInfo(one);
//        db.createInfo(two);
//       db.createInfo(three);

  //      db.createTable();

   //   db.deleteVisitedAfterId(4);

    //    db.deleteAllFromTables();
//
//
        List<Capital> list=new ArrayList<Capital>();
        list=db.getAllCapitals();
        for(int i=0;i<list.size();i++){
            Log.v("!!!capital: " ,String.valueOf(list.get(i).getName()+list.get(i).getId()));
        }

        List<Country> list1=new ArrayList<Country>();
        list1=db.getAllCountries();
        for(int i=0;i<list1.size();i++){
            Log.v("!!!country: " ,String.valueOf(list1.get(i).getName()+list1.get(i).getId()));
        }

        List<VisitedCountries> list3=new ArrayList<VisitedCountries>();
        list3=db.getAllVC();
        for(int i=0;i<list3.size();i++){
            Log.v("!!!vsitedcountries: " ,String.valueOf(list3.get(i).getId()+list3.get(i).getDateStart()+list3.get(i).getNotes()+list3.get(i).getCountry()));
        }


        List<String> infoList= new ArrayList<String>();
        infoList=db.getAllInfo();
        for(int i=0;i<infoList.size();i++){
            Log.v("infoTable: "+i ,infoList.get(i));
        }

        db.joinCountryAndCapital(1);


//        Country cc=db.getCountryy(3);
//        Log.v("vsitedcountries: " ,String.valueOf(cc.getName()));

//        Log.v("country: ",String.valueOf(country));
//        Log.v("cap: ",String.valueOf(capital));
//        db.createCapital(ca1);
//        db.createCountry(c2);
//        db.createVisitedCountry(v1);
//
//       db.createCapital(ca2);
//       db.createCountry(c3);
//       db.createVisitedCountry(v2);

        //db.execSQL(query);
        //db.execSQL(quer1);
        //db.execSQL(query2);


//        Country c4= new Country("Ethiopia",1000.f,"Ungureste",new Capital(),"innformatii lefate de tara");
//        Country c5= new Country("Kenya",3456.0f,"Spaniola",new Capital(),"info legate de tara");
//
//
//
//        Country c6=new Country("Australia",10000.0f,"Romana",new Capital(),"informati legate de tara ");
//        Country c7= new Country("New Zealand",1000.f,"Ungureste",new Capital(),"innformatii lefate de tara");
//        Country c8= new Country("Fiji",3456.0f,"Spaniola",new Capital(),"info legate de tara");
//
//
//
//        Country c9=new Country("Cuba",10000.0f,"Romana",new Capital(),"informati legate de tara ");
//        Country c10= new Country("Guatemala",1000.f,"Ungureste",new Capital(),"innformatii lefate de tara");
//        Country c11= new Country("Jamaica",3456.0f,"Spaniola",new Capital(),"info legate de tara");
//
//
//        Country c12=new Country("Russia",10000.0f,"Romana",new Capital(),"informati legate de tara ");
//        Country c13= new Country("Tjikistar",1000.f,"Ungureste",new Capital(),"innformatii lefate de tara");
//
//
//
//        Country c14=new Country("China",10000.0f,"Romana",new Capital(),"informati legate de tara ");
//        Country c15= new Country("Japan",1000.f,"Ungureste",new Capital(),"innformatii lefate de tara");
//        Country c16= new Country("Thailand",3456.0f,"Spaniola",new Capital(),"info legate de tara");
//
//
//
//        Country c17=new Country("Romania",10000.0f,"Romana",new Capital(),"informati legate de tara ");
//        Country c18= new Country("Germany",1000.f,"Ungureste",new Capital(),"innformatii lefate de tara");
//        Country c19= new Country("Spain",3456.0f,"Spaniola",new Capital(),"info legate de tara");
//
//
//
//        Country c20=new Country("Armenia",10000.0f,"Romana",new Capital(),"informati legate de tara ");
//        Country c21= new Country("Iran",1000.f,"Ungureste",new Capital(),"innformatii lefate de tara");
//        Country c22= new Country("Jordan",3456.0f,"Spaniola",new Capital(),"info legate de tara");
//
//
//
//        Country c23=new Country("Canada",10000.0f,"Romana",new Capital(),"informati legate de tara ");
//        Country c24= new Country("US",1000.f,"Ungureste",new Capital(),"innformatii lefate de tara");
//        Country c25= new Country("Mexico",3456.0f,"Spaniola",new Capital(),"info legate de tara");
//
//
//        Country c26=new Country("Brazil",10000.0f,"Romana",new Capital(),"informati legate de tara ");
//        Country c27= new Country("Peru",1000.f,"Ungureste",new Capital(),"innformatii lefate de tara");
//
//
//
//        Country c28=new Country("India",10000.0f,"Romana",new Capital(),"informati legate de tara ");
//        Country c29= new Country("Siri Lanca ",1000.f,"Ungureste",new Capital(),"innformatii lefate de tara");
//






        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment argumentFragment=new WorldMapFragment();
                fragmentManager.beginTransaction().replace(R.id.frg,argumentFragment).commit();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment argumentFragment=new CountriesAndCapitalsFragment();
                fragmentManager.beginTransaction().replace(R.id.frg,argumentFragment).commit();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment argumentFragment=new VisitedCountrieFragment();
                fragmentManager.beginTransaction().replace(R.id.frg,argumentFragment).commit();

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment argumentFragment=new SettingsFragment();
                fragmentManager.beginTransaction().replace(R.id.frg,argumentFragment).commit();
            }
        });


        db.closeDB();

    }
}
