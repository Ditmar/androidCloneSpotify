package com.developer.ditmar.clonespotify.ui.playlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.developer.ditmar.clonespotify.ui.playlist.itemfragment.ItemListFragment;
import com.developer.ditmar.clonespotify.ui.playlist.structpageadapter.StructPage;

import java.util.ArrayList;

public class FragmentAdapterItems extends FragmentPagerAdapter {
    private ArrayList<StructPage> PAGEDATALIST;
    public FragmentAdapterItems(FragmentManager manager, ArrayList<StructPage> datalist) {
        super(manager);
        PAGEDATALIST = datalist;
    }
    @Override
    public Fragment getItem(int position) {
        return ItemListFragment.createFragment(position);
    }

    @Override
    public int getCount() {
        return PAGEDATALIST.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return PAGEDATALIST.get(position).getTitle();
    }
}
