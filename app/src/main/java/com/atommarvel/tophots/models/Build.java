package com.atommarvel.tophots.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Build implements Serializable{
    public int gamesPlayed;
    public float winPercent;
    public ArrayList<Talent> talents;

    public static Build fromJson(JSONObject jsonObject){
        Build build = new Build();
        try {
            build.gamesPlayed = Integer.parseInt(jsonObject.getString("gamesPlayed"));
            build.winPercent = Float.parseFloat(jsonObject.getString("winPercent").replaceAll(" %", ""));
            build.talents = Talent.fromJson(jsonObject.getJSONArray("talents"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return build;
    }

    public static ArrayList<Build> fromJson(JSONArray jsonArray) {
        ArrayList<Build> builds= new ArrayList<Build>(jsonArray.length());
        // Process each result in json array, decode and convert to Build object
        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject buildJson = null;
            try {
                buildJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Build build = Build.fromJson(buildJson);
            if (build != null) {
                builds.add(build);
            }
        }

        return builds;
    }
}
