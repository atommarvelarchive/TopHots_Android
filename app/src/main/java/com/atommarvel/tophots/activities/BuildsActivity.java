package com.atommarvel.tophots.activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.atommarvel.tophots.R;
import com.atommarvel.tophots.adapter.BuildsAdapter;
import com.atommarvel.tophots.models.Build;
import com.atommarvel.tophots.models.Hero;
import com.atommarvel.tophots.networking.TophotsApi;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;

import java.util.ArrayList;

public class BuildsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builds);
        final Hero hero = (Hero) getIntent().getSerializableExtra("hero");
        setTitle(hero.name.concat(" Builds"));

        TophotsApi api = new TophotsApi(this);
        final Context ctx = this;
        api.getHeroBuilds(hero.getApiName(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                // Root JSON in response is an array i.e [ { ... }, { ... } ]
                // Handle resulting parsed JSON response here
                ArrayList<Build> builds = Build.fromJson(response);
                // Create the adapter to convert the array to views
                BuildsAdapter adapter = new BuildsAdapter(ctx, builds);
                // Attach the adapter to a ListView
                ListView listView = (ListView) findViewById(R.id.builds_lv);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                        Build build = (Build) adapter.getItemAtPosition(position);
                        Intent intent = new Intent(BuildsActivity.this, GuideActivity.class);
                        intent.putExtra("build", build);
                        intent.putExtra("heroName", hero.name);
                        startActivity(intent);
                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_builds, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
