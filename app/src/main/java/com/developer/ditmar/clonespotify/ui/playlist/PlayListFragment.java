package com.developer.ditmar.clonespotify.ui.playlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.developer.ditmar.clonespotify.ApiResfull.MusicApi;
import com.developer.ditmar.clonespotify.ApiResfull.onLoadData;
import com.developer.ditmar.clonespotify.R;
import com.developer.ditmar.clonespotify.adapters.StructListMp3;
import com.developer.ditmar.clonespotify.ui.playlist.structpageadapter.StructPage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class PlayListFragment extends Fragment implements onLoadData {

    private PlayListViewModel notificationsViewModel;
    private View ROOT;
    private ViewPager pager;
    public static ArrayList<StructPage> playListdata;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(PlayListViewModel.class);

        View root = inflater.inflate(R.layout.fragment_playlist, container, false);
        ROOT = root;
        return root;

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
        pager = ROOT.findViewById(R.id.contentpager);
        playListdata = new ArrayList<>();
        //Gustavo123
        /*if (playListdata != null) {
            FragmentAdapterItems adapter = new FragmentAdapterItems(this.getFragmentManager(), playListdata);
            pager.setAdapter(adapter);
        } else {*/
            MusicApi api = new MusicApi(this);
            api.loadPlayList("Gustavo123");
       // }

    }

    public void loadAdapter() {
        FragmentAdapterItems adapter = new FragmentAdapterItems(this.getFragmentManager(), playListdata);
        pager.setAdapter(adapter);
    }
    @Override
    public void onJsonLoad(JSONObject data) {

    }
    @Override
    public void onJsonArrayLoad(JSONArray data) {
        if (data.length() == 1) {
            try {
                JSONObject itemObject = data.getJSONObject(0);
                if (itemObject.has("playlist")) {
                    JSONArray playlistdata = itemObject.getJSONArray("playlist");
                    for (int i  = 0; i < playlistdata.length(); i++) {
                        JSONObject itemPlayList = playlistdata.getJSONObject(i);
                        StructPage page = new StructPage();
                        page.setTitle(itemPlayList.getString("nombre"));
                        page.setId("");
                        ArrayList<StructListMp3> dataList = new ArrayList<>();
                        if (itemPlayList.has("music")) {
                            JSONArray musicdata =  itemPlayList.getJSONArray("music");
                            for (int j = 0; j < musicdata.length(); j++) {
                                try {

                                    JSONObject jsonobj = musicdata.getJSONObject(j);
                                    if (jsonobj.has("relativepath")) {
                                        StructListMp3 item = new StructListMp3();
                                        item.setImage(jsonobj.getString("image"));
                                        item.setTitle(jsonobj.getString("title"));
                                        item.setAlbum(jsonobj.getString("Album"));
                                        item.setRelativepath(jsonobj.getString("relativepath"));
                                        dataList.add(item);
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                            page.setDatasongs(dataList);
                        }
                        playListdata.add(page);
                    }
                    //LLAMAR AL ADAPTADOR
                    loadAdapter();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

    }
}