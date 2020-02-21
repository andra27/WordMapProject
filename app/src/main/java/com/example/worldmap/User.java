package com.example.worldmap;

import java.util.ArrayList;

public class User {
    private String id;
    private String email;
    private String password;
    private ArrayList<VisitedCountries> visitedCountries;

    public User(String p_phoneNumber,String p_password,ArrayList<VisitedCountries> v_visitedCountries){
        this.email=p_phoneNumber;
        this.password=p_password;
        this.visitedCountries=v_visitedCountries;

    }
    public User(){

    }
    public String getPhoneNumber(){
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
