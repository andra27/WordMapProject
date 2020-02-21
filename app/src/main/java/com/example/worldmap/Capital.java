package com.example.worldmap;

import java.io.Serializable;

public class Capital implements Serializable {

    private Integer id;
    private String name;
    private String surface;
    private Float noOfHabitants;
    private String info;


    public Capital(String name, String surface, Float noOfHabitants, String info) {
       // this.id=id;
        this.name = name;
        this.surface = surface;
        this.noOfHabitants = noOfHabitants;
        this.info = info;
    }

    public Capital(){
        this.name = "None";
        this.surface = "None";
        this.noOfHabitants = 10000.0f;
        this.info = "None";

    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurface() {
        return surface;
    }

    public Float getNoOfHabitants() {
        return noOfHabitants;
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

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public void setNoOfHabitants(Float noOfHabitants) {
        this.noOfHabitants = noOfHabitants;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    @Override
    public String toString() {
        return "Capital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surface='" + surface + '\'' +
                ", noOfHabitants=" + noOfHabitants +
                ", info='" + info + '\'' +
                '}';
    }
}
