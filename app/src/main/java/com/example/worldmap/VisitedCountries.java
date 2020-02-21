package com.example.worldmap;

import java.io.Serializable;

public class VisitedCountries implements Serializable {



    private Integer id;
    private Country country;
    private String notes;
    private String dateStart;


//    public VisitedCountries(Country c_country,String n_notes){//,DatePicker d_start,DatePicker d_stop){
//        this.country=c_country;
//        this.notes=n_notes;
////        this.dateStart=d_start;
////        this.dateEnd=d_stop;
//    }
    public VisitedCountries( Country country, String notes, String dateStart) {
        this.country = country;
        this.country.setId(country.getId());
        this.country.setName(country.getName());
        this.country.setLanguage(country.getLanguage());
        this.country.setCapital(country.getCapital());
        this.country.setInfo(country.getInfo());
        this.notes = notes;
        this.dateStart = dateStart;

    }
    public VisitedCountries(){
        this.country=new Country();
        this.notes="None";
        this.dateStart=null;

    }
    public void setIdCountry(int id){
        country.setId(id);
    }

    public int getCountryId(){
        return country.getId();
    }

    public void setNameCountry(String name){
        country.setName(name);
    }

    public Integer getId() {
        return id;
    }

    public Country getCountry() {
        return country;
    }

    public String getCountryName(){
        return country.getName();
    }


    public void setCountryNoOfHabitants(Float f){
        country.setNoOfHabitants(f);
    }

    public void setLanguageCountry(String lan){
        country.setLanguage(lan);
    }
    public void setInfoCountry(String info){
        country.setInfo(info);
    }

    //public setCountry
    public String getNotes() {
        return notes;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    @Override
    public String toString() {
        return "VisitedCountries{" +
                "id='" + id + '\'' +
                ", country=" + country +
                ", notes='" + notes + '\'' +
                ", dateStart='" + dateStart + '\'' +
                '}';
    }
}
