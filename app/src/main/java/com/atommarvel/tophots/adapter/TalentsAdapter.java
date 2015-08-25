package com.atommarvel.tophots.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atommarvel.tophots.R;
import com.atommarvel.tophots.models.Talent;

import java.util.ArrayList;

public class TalentsAdapter extends ArrayAdapter{
    public TalentsAdapter(Context context, ArrayList<Talent> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Talent talent = (Talent)getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.talentcard_compact_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.talent_tv);
        // Populate the data into the template view using the data object
        tvName.setText(talent.name);
        setupImg(convertView, R.id.talent_iv, talent);
        // Return the completed view to render on screen
        return convertView;
    }

    public void setupImg(View convertView, int id, Talent talent){
        ImageView iv = (ImageView) convertView.findViewById(id);
        Context ctx = getContext();
        String uri = talent.getImgURI();
        int profileResource = ctx.getResources().getIdentifier(uri, null, ctx.getPackageName());
        iv.setImageResource(profileResource);
    }

}
