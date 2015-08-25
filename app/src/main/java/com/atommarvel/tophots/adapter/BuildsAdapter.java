package com.atommarvel.tophots.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atommarvel.tophots.R;
import com.atommarvel.tophots.models.Build;
import com.atommarvel.tophots.models.Talent;

import java.util.ArrayList;

public class BuildsAdapter extends ArrayAdapter<Build>{
    public BuildsAdapter(Context context, ArrayList<Build> builds) {
        super(context, 0, builds);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Build build= getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.buildcard_layout, parent, false);
        }
        TextView tvGP = (TextView) convertView.findViewById(R.id.played_tv);
        TextView tvWP = (TextView) convertView.findViewById(R.id.winper_tv);
        String gp = Integer.toString(build.gamesPlayed);
        String wp = Float.toString(build.winPercent);
        tvGP.setText(gp);
        tvWP.setText(wp.concat(" %"));

        setupImg(convertView, R.id.iv1, build.talents.get(0));
        setupImg(convertView, R.id.iv2, build.talents.get(1));
        setupImg(convertView, R.id.iv3, build.talents.get(2));
        setupImg(convertView, R.id.iv4, build.talents.get(3));
        setupImg(convertView, R.id.iv5, build.talents.get(4));
        setupImg(convertView, R.id.iv6, build.talents.get(5));
        setupImg(convertView, R.id.iv7, build.talents.get(6));

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
