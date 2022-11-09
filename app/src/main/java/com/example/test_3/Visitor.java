package com.example.test_3;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Visitor implements Serializable {
    String name;
    String surname;
    Double height;
    Double weight;
    Integer year;
    Integer age;

    public Visitor(String name, String surname, Double height, Double weight, Integer year){
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.weight = weight;
        this.year = year;
        this.age = Calendar.getInstance().get(Calendar.YEAR) - year;
    }
}
