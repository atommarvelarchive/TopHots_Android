package com.atommarvel.tophots.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Talent implements Serializable{
    public String desc;
    public int lvl;
    public String name;

    public static Talent fromJson(JSONObject jsonObject){
        Talent talent = new Talent();
        try {
            talent.desc = jsonObject.getString("desc");
            talent.name = jsonObject.getString("name");
            talent.lvl = Integer.parseInt(jsonObject.getString("lvl"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return talent;
    }

    public static ArrayList<Talent> fromJson(JSONArray jsonArray) {
        ArrayList<Talent> talents = new ArrayList<Talent>(jsonArray.length());
        // Process each result in json array, decode and convert to Talent object
        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject talentJson = null;
            try {
                talentJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Talent talent = Talent.fromJson(talentJson);
            if (talent != null) {
                talents.add(talent);
            }
        }

        return talents;
    }

    public String getImgURI(){
        return "@drawable/talent_".concat(getApiName());
    }

    public String getApiName(){
        return this.name.toLowerCase()
                .replaceAll(" ", "_")
                .replaceAll("-", "_")
                .replaceAll("\\.", "")
                .replaceAll(":", "")
                .replaceAll("!", "")
                .replaceAll(",","")
                .replaceAll("'","");
    }
}
