package com.atommarvel.tophots.models;

import android.content.Context;
import android.content.res.Resources;

import com.atommarvel.tophots.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Hero implements Serializable{
    public String name;
    public float winPercent;
    public float winDelta;
    public float popularity;


    public static String[] roster = {
            "Abathur", "Anub'arak", "Arthas", "Azmodan", "Brightwing", "Chen", "Diablo", "E.T.C.",
            "Falstad", "Gazlowe", "Illidan", "Jaina", "Johanna", "Kael'thas", "Kerrigan", "Leoric",
            "Li Li", "Malfurion", "Muradin", "Murky", "Nazeebo", "Nova", "Raynor", "Rehgar",
            "Sgt. Hammer", "Sonya", "Stitches", "Sylvanas", "Tassadar", "The Butcher",
            "The Lost Vikings", "Thrall", "Tychus", "Tyrael", "Tyrande", "Uther", "Valla", "Zagara",
            "Zeratul"};


    public Hero(String name){
        this.name = name;
        //TODO: get the below data from the api once I expose it
        this.winPercent = 50.0f;
        this.winDelta = 0.5f;
        this.popularity = 2.0f;
    }

    public String getApiName(){
        //TODO: get java string manipulation recommendation
        return name.toLowerCase().replaceAll("\\s","").replaceAll("'","").replaceAll("\\.","");
    }

    public String getProfileImgURI() {
        return "@drawable/profile_".concat(getApiName());
    }

    public static ArrayList<Hero> getRoster() {
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        for( int i = 0; i < roster.length; i++){
            heroes.add(new Hero(roster[i]));
        }
        return heroes;
    }
}
