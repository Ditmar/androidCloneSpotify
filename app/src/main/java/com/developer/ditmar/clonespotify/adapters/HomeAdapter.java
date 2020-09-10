package com.developer.ditmar.clonespotify.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.developer.ditmar.clonespotify.R;

import java.util.ArrayList;

public class HomeAdapter extends BaseAdapter {
    private ArrayList<StructListMp3> LISTDATA;
    private Context context;
    public HomeAdapter(ArrayList<StructListMp3> data, Context context) {
        LISTDATA = data;
        this.context = context;
    }
    @Override
    public int getCount() {
        return LISTDATA.size();
    }

    @Override
    public Object getItem(int i) {
        return LISTDATA.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_listmp3, null);
            TextView title = view.findViewById(R.id.title);
            title.setText(LISTDATA.get(i).getTitle());
            TextView album = view.findViewById(R.id.album);
            ImageView imageView = view.findViewById(R.id.imageView3);
            album.setText(LISTDATA.get(i).getTitle());
            if (LISTDATA.get(i).getImage().equals("No IMAGE")) {
                //https://topesdegama.com/app/uploads-topesdegama.com/2018/10/Logo-Spotify-blanco.jpg
                Glide.with(context)
                        .load("https://topesdegama.com/app/uploads-topesdegama.com/2018/10/Logo-Spotify-blanco.jpg")
                        .centerCrop()
                        .into(imageView);
            } else {
                Glide.with(context)
                        .load(LISTDATA.get(i).getImage())
                        .centerCrop()
                        .into(imageView);
            }
        }
        return view;
    }
}
