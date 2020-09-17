package com.developer.ditmar.clonespotify.ui.playlist.structpageadapter;

import com.developer.ditmar.clonespotify.adapters.StructListMp3;

import java.util.ArrayList;

public class StructPage {
    private String title;
    private Integer position;
    private String id;
    private ArrayList<StructListMp3> datasongs;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<StructListMp3> getDatasongs() {
        return datasongs;
    }

    public void setDatasongs(ArrayList<StructListMp3> datasongs) {
        this.datasongs = datasongs;
    }
}
