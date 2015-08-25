package com.atommarvel.tophots.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atommarvel.tophots.R;
import com.atommarvel.tophots.models.Hero;

import java.util.ArrayList;

public class HeroesAdapter extends ArrayAdapter{
    public HeroesAdapter(Context context, ArrayList<Hero> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Hero hero = (Hero)getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.herocard_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.name_tv);
        ImageView ivProfile = (ImageView) convertView.findViewById(R.id.profile_iv);
        // Populate the data into the template view using the data object
        tvName.setText(hero.name);

        Context ctx = getContext();
        String uri = hero.getProfileImgURI();
        int profileResource = ctx.getResources().getIdentifier(uri, null, ctx.getPackageName());
        ivProfile.setImageResource(profileResource);
        // Return the completed view to render on screen
        return convertView;
    }
}
