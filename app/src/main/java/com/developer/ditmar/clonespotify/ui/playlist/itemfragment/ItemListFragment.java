package com.developer.ditmar.clonespotify.ui.playlist.itemfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.developer.ditmar.clonespotify.R;
import com.developer.ditmar.clonespotify.adapters.HomeAdapter;
import com.developer.ditmar.clonespotify.adapters.StructListMp3;
import com.developer.ditmar.clonespotify.ui.playlist.PlayListFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ItemListFragment extends Fragment {
    private Integer position;
    public static Fragment createFragment(int position) {
        ItemListFragment inst = new ItemListFragment();
        Bundle args = new Bundle();
        args.putInt("id", position);
        inst.setArguments(args);
        return inst;
    }
    View ROOT;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_item_play_list, container, false);
        ROOT = root;
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle budle = this.getArguments();
        position = budle.getInt("id");
        ArrayList<StructListMp3>  listdata = PlayListFragment.playListdata.get(position).getDatasongs();
        ListView list = ROOT.findViewById(R.id.listdata);
        HomeAdapter adapter = new HomeAdapter(listdata, ROOT.getContext());
        list.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
