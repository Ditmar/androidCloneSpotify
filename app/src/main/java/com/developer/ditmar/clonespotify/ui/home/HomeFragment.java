package com.developer.ditmar.clonespotify.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.developer.ditmar.clonespotify.ApiResfull.MusicApi;
import com.developer.ditmar.clonespotify.ApiResfull.onLoadData;
import com.developer.ditmar.clonespotify.R;
import com.developer.ditmar.clonespotify.adapters.HomeAdapter;
import com.developer.ditmar.clonespotify.adapters.StructListMp3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class HomeFragment extends Fragment implements onLoadData {

    private HomeViewModel homeViewModel;
    private ListView list;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        /*homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        list = this.getActivity().findViewById(R.id.musica_list);
        ArrayList<StructListMp3> datos = new ArrayList<>();
        MusicApi api = new MusicApi(this);
        api.loadMusic();

    }

    @Override
    public void onJsonLoad(JSONObject data) {

    }

    @Override
    public void onJsonArrayLoad(JSONArray data) {
        ArrayList<StructListMp3> datos = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            StructListMp3 item = new StructListMp3();
            try {
                if (data.getJSONObject(i).has("title")) {
                    item.setTitle(data.getJSONObject(i).getString("title"));
                } else {
                    item.setTitle("");
                }
                if (data.getJSONObject(i).has("Album")) {
                    item.setAlbum(data.getJSONObject(i).getString("Album"));
                } else {
                    item.setAlbum("");
                }
                if (data.getJSONObject(i).has("image")) {
                    item.setImage(data.getJSONObject(i).getString("image"));
                } else {
                    item.setImage("No IMAGE");
                }
                datos.add(item);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        HomeAdapter adapter = new HomeAdapter(datos, this.getContext());
        //ArrayAdapter<String> adapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_list_item_1, datos);
        list.setAdapter(adapter);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

    }
}