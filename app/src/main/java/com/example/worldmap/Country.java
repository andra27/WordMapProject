package com.example.worldmap;

import java.io.Serializable;

public class Country implements Serializable {
    private Integer id;
    private String name;
    private Float noOfHabitants;
    private String language;
    private Capital capital;
    private String info;

    public Country(String n_name,Float n_noOfHabitants,String l_lang,Capital c_capital,String i_inf){
       // this.id=id;
        this.name=n_name;
        this.noOfHabitants=n_noOfHabitants;
        this.language=l_lang;
        this.capital=c_capital;
        this.info=i_inf;
    }
    public Country(){

        this.name="Greece";
        this.noOfHabitants=0.0f;
        this.language="None";
        this.capital= new Capital();
        this.info="None";
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getNoOfHabitants() {
        return noOfHabitants;
    }

    public String getLanguage() {
        return language;
    }

    public Capital getCapital() {
        return capital;
    }

    public String getCapitalName(){
        return this.capital.getName();
    }

    public String getInfo() {
        return info;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNoOfHabitants(Float noOfHabitants) {
        this.noOfHabitants = noOfHabitants;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", noOfHabitans='" + noOfHabitants + '\'' +
                ", language='" + language + '\'' +
                ", capital='" + capital + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
