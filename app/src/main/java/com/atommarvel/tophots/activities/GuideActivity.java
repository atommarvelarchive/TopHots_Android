package com.atommarvel.tophots.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.atommarvel.tophots.R;
import com.atommarvel.tophots.adapter.TalentsAdapter;
import com.atommarvel.tophots.models.Build;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        Build build = (Build) getIntent().getSerializableExtra("build");
        String heroName = getIntent().getStringExtra("heroName");
        setTitle(heroName.concat(" Guide"));

        // Create the adapter to convert the array to views
        TalentsAdapter adapter = new TalentsAdapter(this, build.talents);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.talents_lv);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guide, menu);
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
