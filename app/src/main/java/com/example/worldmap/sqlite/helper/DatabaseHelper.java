package com.example.worldmap.sqlite.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.example.worldmap.Capital;
import com.example.worldmap.Country;
import com.example.worldmap.VisitedCountries;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "CountriesAndCapitals";
    private static final int DATABASE_VERSION = 1;
    private static final String ID = "id";
    private static final String TABLE_VC_NAME = "visited_countries";
    private static final String TABLE_CO_NAME = "country";
    private static final String TABLE_C_NAME = "capital";
    private static final String TABLE_INFO = "informatii";


    private static final String COLUMN_INFO="informatii";
    private static final String COLUMN_INFO_ID = "id_info";
    private static final String COLUMN_VC_ID = "id";
    private static final String COLUMN_VC_COUNTRY = "country_id";
    private static final String COLUMN_VC_NOTES = "notes";
    private static final String COLUMN_VC_STARTDATE = "startDate";
    private static final String COLUMN_CO_ID = "country_id";
    private static final String COLUMN_CO_NAME = "name";
    private static final String COLUMN_CO_NOOFHABITANTS = "noOfHabitants";
    private static final String COLUMN_CO_LANGUAGE = "language";
    private static final String COLUMN_CO_CAPITAL = "capital_id";
    private static final String COLUMN_CO_INFO = "info";
    private static final String COLUMN_C_ID = "capital_id";
    private static final String COLUMN_C_NAME = "name";
    private static final String COLUMN_C_SURFACE = "surface";
    private static final String COLUMN_C_NOOFHABITANT = "noOfHabitants";
    private static final String COLUMN_C_INFO = "info";

    //table create statments
    private static final String CREATE_TABLE_VISITEDCOUNTRIES = "CREATE TABLE "
            + TABLE_VC_NAME + "(" + COLUMN_VC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_VC_COUNTRY
            + " INTEGER," + COLUMN_VC_NOTES + " TEXT," + COLUMN_VC_STARTDATE + " DATETIME," + "FOREIGN KEY " +
            "(" + COLUMN_VC_COUNTRY + ")" + "REFERENCES " + " "+TABLE_CO_NAME + "(" + COLUMN_CO_ID + ")" + ")";

    private static final String CREATE_TABLE_COUNTRY = "CREATE TABLE "
            + TABLE_CO_NAME + "(" + COLUMN_CO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CO_NAME
            + " TEXT," + COLUMN_CO_NOOFHABITANTS + " INTEGER," + COLUMN_CO_LANGUAGE + " TEXT,"
            + COLUMN_CO_CAPITAL + " INTEGER, " + COLUMN_CO_INFO + " TEXT," + "FOREIGN KEY " +
            "(" + COLUMN_CO_CAPITAL + ")" + "REFERENCES " + " "+TABLE_C_NAME + "(" + COLUMN_C_ID + ")" + ")";

    private static final String CREATE_TABLE_CAPITAL = "CREATE TABLE "
            + TABLE_C_NAME + "(" + COLUMN_C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_C_NAME
            + " TEXT," + COLUMN_C_SURFACE + " TEXT," + COLUMN_C_NOOFHABITANT + " INTEGER,"
            + COLUMN_CO_INFO + " TEXT " + ")";

    private static final String CREATE_TABLE_INFO = "CREATE TABLE "
            + TABLE_INFO + "(" + COLUMN_INFO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_INFO
            + " TEXT "  + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CAPITAL);
        db.execSQL(CREATE_TABLE_COUNTRY);
        db.execSQL(CREATE_TABLE_VISITEDCOUNTRIES);
        db.execSQL(CREATE_TABLE_INFO);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_C_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CO_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VC_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_INFO);

        onCreate(db);

    }


    public void createInfo(String info){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_INFO,info);
        Log.v("a treuct p aici ","dada");
        db.insert(TABLE_INFO,null,values);
    }



//    public void createTable(){
//        SQLiteDatabase db=this.getWritableDatabase();
//        String query2="DELETE  FROM "+TABLE_INFO;
//
//        db.execSQL(query2);
//    }


    public String getInfo(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_INFO;
        String info="";
        Cursor c = db.rawQuery(selectQuery, null);
        int count=1;
        if (c != null && c.moveToFirst()) {

            do {
                if(count==id){
                 info = c.getString(1);}
                count++;

            }while(c.moveToNext());

            return info;

        } else {
            return null;
        }
//        String selectQuery="SELECT "+COLUMN_INFO+" FROM "+TABLE_INFO+
//                " WHERE "+COLUMN_INFO_ID+" = "+id;
//        Cursor c=db.rawQuery(selectQuery,null);
//        if(c!=null && c.moveToFirst()){
//            String info=c.getString(c.getColumnIndex(COLUMN_INFO));
//            c.close();
//            return info;
//        }else{
//            c.close();
//            return null;
//        }
    }



    public List<String> getAllInfo(){
        List<String> list=new ArrayList<String>();
        String selectQuery="SELECT * FROM "+TABLE_INFO;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery(selectQuery,null);
        if(c!=null && c.moveToFirst()){
            do{
                list.add(c.getString(c.getColumnIndex(COLUMN_INFO)));
//                Log.v("INFO:",c.getInt(c.getColumnIndex(COLUMN_INFO_ID))+c.getString(c.getColumnIndex(COLUMN_INFO)));
            }while(c.moveToNext());
        }

        c.close();
        return list;
    }



    public void createCapital(Capital capital ) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_C_NAME, capital.getName());
        values.put(COLUMN_C_SURFACE, capital.getSurface());
        values.put(COLUMN_C_NOOFHABITANT, capital.getNoOfHabitants());
        values.put(COLUMN_C_INFO, capital.getInfo());
        db.insert(TABLE_C_NAME, null, values);

    }


//fetching a country from country table-select * from country where id=#


    public Capital getCapitall(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_C_NAME + " WHERE "
                + COLUMN_C_ID + " = " + id;
        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null&& c.moveToFirst()) {
            Capital capital = new Capital();
            capital.setId(c.getInt(c.getColumnIndex(COLUMN_C_ID)));
            capital.setName(c.getString(c.getColumnIndex(COLUMN_C_NAME)));
            capital.setSurface(c.getString(c.getColumnIndex(COLUMN_C_SURFACE)));
            capital.setNoOfHabitants(c.getFloat(c.getColumnIndex(COLUMN_C_NOOFHABITANT)));
            capital.setInfo(c.getString(c.getColumnIndex(COLUMN_C_INFO)));
            c.close();
            Log.e("getcap cap:", capital.getName());
            return capital;
        }else {
            c.close();
            return null;
        }
    }



    //select * from capital

    public List<Capital> getAllCapitals(){
        List<Capital> list= new ArrayList<Capital>();

        String selectQuery="SELECT * FROM "+TABLE_C_NAME;

      //  Log.e("get all countries ",selectQuery);

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor c= db.rawQuery(selectQuery,null);

        if( c!=null && c.moveToFirst()){
            do{
                Capital capital=new Capital();
                capital.setId(c.getInt(c.getColumnIndex(COLUMN_C_ID)));
                capital.setName(c.getString(c.getColumnIndex(COLUMN_C_NAME)));
                capital.setSurface(c.getString(c.getColumnIndex(COLUMN_C_SURFACE)));
                capital.setNoOfHabitants(c.getFloat(c.getColumnIndex(COLUMN_C_NOOFHABITANT)));
                capital.setInfo(c.getString(c.getColumnIndex(COLUMN_C_INFO)));

                list.add(capital);
               // Log.v("EEEEEEEE",capital.toString());

            }while (c.moveToNext());
        }
        c.close();
        return list;
    }


    //get a capital after name


    public Capital getCapitalAfterName(String name){
        SQLiteDatabase db=this.getReadableDatabase();

        String selectQuery="SELECT * FROM "+TABLE_C_NAME+ " WHERE "+ COLUMN_C_NAME+" = "+name;
       // Log.e("capital dupa nume",selectQuery);
        Cursor c=db.rawQuery(selectQuery,null);
        if(c!=null && c.moveToFirst() ){

            Capital capital=new Capital();
            capital.setId(c.getInt(c.getColumnIndex(COLUMN_C_ID)));
            capital.setName(c.getString(c.getColumnIndex(COLUMN_C_NAME)));
            capital.setSurface(c.getString(c.getColumnIndex(COLUMN_C_SURFACE)));
            capital.setNoOfHabitants(c.getFloat(c.getColumnIndex(COLUMN_C_NOOFHABITANT)));
            capital.setInfo(c.getString(c.getColumnIndex(COLUMN_C_INFO)));
            c.close();
            return capital;
        }
        else{
            return null;
        }
    }

    //updating a capital
    public int updateCapital(Capital capital){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues values= new ContentValues();

        values.put(COLUMN_C_NAME, capital.getName());
        values.put(COLUMN_C_SURFACE, capital.getSurface());
        values.put(COLUMN_C_NOOFHABITANT, capital.getNoOfHabitants());
        values.put(COLUMN_C_INFO, capital.getInfo());

        return db.update(TABLE_C_NAME,values,COLUMN_C_ID+" = ?",new String[]{
                String.valueOf(capital.getId())});
    }


    public void deleteAllFromTables(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="DELETE  FROM "+TABLE_C_NAME;
        String quer1="DELETE  FROM "+TABLE_CO_NAME;
        String query2="DELETE  FROM "+TABLE_VC_NAME;
//        db.delete(TABLE_C_NAME,null,null);
//        db.delete(TABLE_CO_NAME,null,null);
//        db.delete(TABLE_VC_NAME,null,null);
        db.execSQL(query);
        db.execSQL(quer1);
        db.execSQL(query2);

    }


    public long countVC(){
        long count=0;
        SQLiteDatabase db = this.getReadableDatabase();
        SQLiteStatement s = db.compileStatement( "SELECT COUNT(*) FROM " + TABLE_VC_NAME);
        count=s.simpleQueryForLong();
        Log.v("COUNTTTT::",String.valueOf(count));
        return count;

    }


    public void deleteVisitedAfterId(int id ){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="DELETE FROM "+TABLE_VC_NAME;
        db.execSQL(query);
    }

    public void deleteCapital(long id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_C_NAME,COLUMN_C_ID+" = ?", new String[]{String.valueOf(id)});
    }





    //create a country-insert a row into country table

    public void createCountry(Country country,int id_capital) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CO_NAME, country.getName());
        values.put(COLUMN_CO_NOOFHABITANTS, country.getNoOfHabitants());
        values.put(COLUMN_CO_LANGUAGE, country.getLanguage());
        values.put(COLUMN_CO_CAPITAL,id_capital);
        values.put(COLUMN_CO_INFO, country.getInfo());

            //insert row
        db.insert(TABLE_CO_NAME, null, values);

        Log.v("createCountry: ",String.valueOf(values));


    }


    //fetching all countries

    public ArrayList<Country> getAllCountries() {
        ArrayList<Country> list = new ArrayList<Country>();
        String selectQuery = "SELECT * FROM " + TABLE_CO_NAME;

       // Log.e("sunt in getallcountries", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery(selectQuery, null);
        //looping thrugh all rows and adding to the list

        if (c!=null &c.moveToFirst()) {
            do {
                Country country = new Country();
                country.setId(c.getInt(c.getColumnIndex(COLUMN_CO_ID)));
                country.setName(c.getString(c.getColumnIndex(COLUMN_CO_NAME)));
                country.setNoOfHabitants(c.getFloat(c.getColumnIndex(COLUMN_CO_NOOFHABITANTS)));
                country.setLanguage(c.getString(c.getColumnIndex(COLUMN_CO_LANGUAGE)));
                country.setInfo(c.getString(c.getColumnIndex(COLUMN_CO_INFO)));
              //  Log.e("countryall id: ",String.valueOf(c.getInt(c.getColumnIndex(COLUMN_CO_CAPITAL))));
                Capital capital= getCapitall(c.getInt(c.getColumnIndex(COLUMN_CO_CAPITAL)));
                country.setCapital(capital);
                country.setInfo(c.getString(c.getColumnIndex(COLUMN_CO_INFO)));

                list.add(country);

            } while (c.moveToNext());
        }
        c.close();
        return list;
    }


    public void joinCountryAndCapital(int ID){
        SQLiteDatabase db=this.getReadableDatabase();
        String queryJoin="SELECT * FROM "+TABLE_CO_NAME+" AS co JOIN "+TABLE_C_NAME+" AS c ON "+" co."+COLUMN_CO_CAPITAL+" = "+"c."+COLUMN_C_ID+" WHERE c."+COLUMN_C_ID+" = "+ID;
        Cursor c=db.rawQuery(queryJoin,null);
        if (c != null && c.moveToFirst()) {
            //do{
                Capital ca=new Capital();
                ca.setId(c.getInt(c.getColumnIndex(COLUMN_C_ID)));
                ca.setName(c.getString(c.getColumnIndex(COLUMN_C_NAME)));
                ca.setSurface(c.getString(c.getColumnIndex(COLUMN_C_SURFACE)));
                ca.setNoOfHabitants(c.getFloat(c.getColumnIndex(COLUMN_C_NOOFHABITANT)));
                ca.setInfo(c.getString(c.getColumnIndex(COLUMN_C_INFO)));
                Country co=new Country();
                co.setId(c.getInt(c.getColumnIndex(COLUMN_CO_ID)));
                co.setName(c.getString(c.getColumnIndex(COLUMN_CO_NAME)));
                co.setNoOfHabitants(c.getFloat(c.getColumnIndex(COLUMN_CO_NOOFHABITANTS)));
                co.setLanguage(c.getString(c.getColumnIndex(COLUMN_CO_LANGUAGE)));
                co.setCapital(ca);
                co.setInfo(c.getString(c.getColumnIndex(COLUMN_CO_INFO)));
                Log.v("QQQQQ:",ca.toString()+"    "+co.toString());
          //  }while(c.moveToNext());
        }
        c.close();
    }


    public Country getCountryy(long c_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_CO_NAME + " WHERE "
                + COLUMN_CO_ID + " = " + c_id;

        //Log.e("getasingle country", selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null && c.moveToFirst()) {
            Country country = new Country();

            country.setId(c.getInt(c.getColumnIndex(COLUMN_CO_ID)));
            country.setName(c.getString(c.getColumnIndex(COLUMN_CO_NAME)));
            //Log.v("getCountry name este: ", country.getName());
            country.setNoOfHabitants(c.getFloat(c.getColumnIndex(COLUMN_CO_NOOFHABITANTS)));
            country.setLanguage(c.getString(c.getColumnIndex(COLUMN_CO_LANGUAGE)));
           // Log.e("getCountry id este: ", String.valueOf(c.getInt(c.getColumnIndex(COLUMN_CO_CAPITAL))));
            Capital capital= getCapitall(c.getInt(c.getColumnIndex(COLUMN_CO_CAPITAL)));

            country.setCapital(capital);
            country.setInfo(c.getString(c.getColumnIndex(COLUMN_CO_INFO)));
            c.close();
            return country;

        }
        else {
            return null;
        }




    }


//updating a country

    public void updateCountry(Country country) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CO_NAME, country.getName());
        values.put(COLUMN_CO_NOOFHABITANTS, country.getNoOfHabitants());
        values.put(COLUMN_CO_LANGUAGE, country.getLanguage());
        Cursor c=db.query(TABLE_C_NAME,new String[]{COLUMN_C_ID},COLUMN_C_NAME+" = ?",new String[]{country.getCapital().getName()},null,null,null);

        if(c.getCount()==1){
        values.put(COLUMN_CO_CAPITAL, c.getInt(0));
        values.put(COLUMN_CO_INFO, country.getInfo());

         db.update(TABLE_CO_NAME, values, COLUMN_CO_ID + " = ?", new String[]{String.valueOf(country.getId())});
        }



    }


//Pass country id t thw following function to delete the country form db

    public void deleteCountry(long countr_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CO_NAME, COLUMN_CO_ID + " = ?", new String[]{String.valueOf(countr_id)});
    }








    public void createVisitedCountry(VisitedCountries visitedCountries, int id_country ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

            values.put(COLUMN_VC_COUNTRY, id_country);
            values.put(COLUMN_VC_NOTES, visitedCountries.getNotes());
            values.put(COLUMN_VC_STARTDATE, visitedCountries.getDateStart());
            //insert the row
             db.insert(TABLE_VC_NAME, null, values);
    }


    //fetchng a vs-select * from vs where id=1
    public VisitedCountries getVisitedCountry(long vc_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_VC_NAME + " WHERE " + COLUMN_VC_ID + " = " + vc_id;

       // Log.e("din getvisitedcountries", selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null && c.moveToFirst()) {
            VisitedCountries vs = new VisitedCountries();

            vs.setId(c.getInt(c.getColumnIndex(COLUMN_VC_ID)));
            Country country = getCountryy(c.getColumnIndex(COLUMN_VC_COUNTRY));
            vs.setCountry(country);
            vs.setNotes(c.getString(c.getColumnIndex(COLUMN_VC_NOTES)));
            vs.setDateStart(c.getString(c.getColumnIndex(COLUMN_VC_STARTDATE)));
            c.close();
            return vs;

        }else{
            return null;
        }


    }




    //create method to view the data from the tabel of vc

    public Cursor viewData(){
        SQLiteDatabase db= this.getReadableDatabase();
        String query="SELECT * FROM "+TABLE_VC_NAME;
        Cursor cursor=db.rawQuery(query,null);

        return cursor;
    }








    //fetching all the vs

    public ArrayList<VisitedCountries> getAllVC() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<VisitedCountries> list = new ArrayList<VisitedCountries>();
        String selectQuery = "SELECT * FROM " + TABLE_VC_NAME;

        Cursor c = db.rawQuery(selectQuery, null);
        //looping through all rows and adding to list
        if ( c!=null &&c.moveToFirst()) {
            do {
                VisitedCountries vs = new VisitedCountries();
                Country co=new Country();
                vs.setId(c.getInt(c.getColumnIndex(COLUMN_VC_ID)));

                Log.v("AICI: ",String.valueOf(c.getInt(1)));

                String queryJoin="SELECT * FROM "+TABLE_CO_NAME+" AS co JOIN "+TABLE_C_NAME+" AS c ON "+" co."+COLUMN_CO_CAPITAL+" = "+"c."+COLUMN_C_ID+" WHERE c."+COLUMN_C_ID+" = "+c.getInt(1);
                Cursor c1=db.rawQuery(queryJoin,null);
                if (c1 != null && c1.moveToFirst()) {

                    Capital ca=new Capital();
                    ca.setId(c1.getInt(0));
                    ca.setName(c1.getString(c1.getColumnIndex(COLUMN_C_NAME)));
                    ca.setSurface(c1.getString(c1.getColumnIndex(COLUMN_C_SURFACE)));
                    ca.setNoOfHabitants(c1.getFloat(c1.getColumnIndex(COLUMN_C_NOOFHABITANT)));
                    ca.setInfo(c1.getString(c1.getColumnIndex(COLUMN_C_INFO)));

                    co=new Country();
                    co.setId(c1.getInt(c1.getColumnIndex(COLUMN_CO_ID)));
                    co.setName(c1.getString(c1.getColumnIndex(COLUMN_CO_NAME)));
                    co.setNoOfHabitants(c1.getFloat(c1.getColumnIndex(COLUMN_CO_NOOFHABITANTS)));
                    co.setLanguage(c1.getString(c1.getColumnIndex(COLUMN_CO_LANGUAGE)));
                    co.setCapital(ca);
                    co.setInfo(c1.getString(c1.getColumnIndex(COLUMN_CO_INFO)));
//                    c1.close();
                }


                vs.setCountry(co);
                vs.setNotes(c.getString(c.getColumnIndex(COLUMN_VC_NOTES)));
                vs.setDateStart(c.getString(c.getColumnIndex(COLUMN_VC_STARTDATE)));

                list.add(vs);
            } while (c.moveToNext());
        }
        c.close();
        return list;
    }


    public int updateVC(VisitedCountries visitedCountries) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_VC_COUNTRY, visitedCountries.getCountry().getId().toString());
        values.put(COLUMN_VC_NOTES, visitedCountries.getNotes());
        values.put(COLUMN_VC_STARTDATE, visitedCountries.getDateStart());

        //upadting row
        return db.update(TABLE_VC_NAME, values, COLUMN_VC_ID + " = ?", new String[]{String.valueOf(visitedCountries.getId())});


    }


    public void deleteVC(long vs_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_VC_NAME, COLUMN_VC_ID + " = ?", new String[]{String.valueOf(vs_id)});
    }




// the capital table




    public void closeDB(){
        SQLiteDatabase db=this.getReadableDatabase();
        if(db!=null && db.isOpen()){
            db.close();
        }
    }




    private String DateTime(){
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date= new Date();
        return dateFormat.format(date);
    }

}