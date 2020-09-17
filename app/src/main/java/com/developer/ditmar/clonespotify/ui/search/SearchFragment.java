package com.developer.ditmar.clonespotify.ui.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developer.ditmar.clonespotify.AdaptersRecyclerView.RecyclerViewAdapter;
import com.developer.ditmar.clonespotify.ApiResfull.MusicApi;
import com.developer.ditmar.clonespotify.ApiResfull.onLoadData;
import com.developer.ditmar.clonespotify.R;
import com.developer.ditmar.clonespotify.adapters.StructListMp3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class SearchFragment extends Fragment implements onLoadData {

    private SearchViewModel dashboardViewModel;
    private View ROOT;
    private MusicApi api;
    RecyclerView list;
    ArrayList<StructListMp3> dataList;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        /*final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        ROOT = root;
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        list = ROOT.findViewById(R.id.resultlist);
        api = new MusicApi(this);

        EditText search = ROOT.findViewById(R.id.searchText);
        search.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                api.searchMusic(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //api.searchMusic();
        //RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, lista);

    }
    @Override
    public void onJsonLoad(JSONObject data) {

    };
    @Override
    public void onJsonArrayLoad(JSONArray data) {
        dataList = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            try {

                JSONObject jsonobj = data.getJSONObject(i);
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
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this.getContext(), dataList);
        LinearLayoutManager manager = new LinearLayoutManager(ROOT.getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        list.setLayoutManager(manager);
        list.setAdapter(adapter);
    };
    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

    };
}