package com.atommarvel.tophots.networking;

import com.atommarvel.tophots.models.Build;
import com.loopj.android.http.*;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TophotsApi {
    public Context ctx;

    public TophotsApi(Context context){
        this.ctx = context;
    }

    private Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public void getHeroBuilds(String hero, JsonHttpResponseHandler handleResponse){
        String url = "http://tophots.atommarvel.com/builds/".concat(hero).concat(".json");
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        client.get(url, params, handleResponse);
    }
}
