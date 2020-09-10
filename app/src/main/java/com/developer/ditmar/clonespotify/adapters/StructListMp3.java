package com.developer.ditmar.clonespotify.adapters;

import java.util.ArrayList;

public class StructListMp3 {
    private String title;
    private String subtitle;
    private ArrayList<String> genero;
    private String Album;
    private String image;
    private String _id;
    private String pathfile;
    private String hash;
    private String relativepath;
    private ArrayList<String> commentaries;
    private ArrayList<String> likes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public ArrayList<String> getGenero() {
        return genero;
    }

    public void setGenero(ArrayList<String> genero) {
        this.genero = genero;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPathfile() {
        return pathfile;
    }

    public void setPathfile(String pathfile) {
        this.pathfile = pathfile;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getRelativepath() {
        return relativepath;
    }

    public void setRelativepath(String relativepath) {
        this.relativepath = relativepath;
    }

    public ArrayList<String> getCommentaries() {
        return commentaries;
    }

    public void setCommentaries(ArrayList<String> commentaries) {
        this.commentaries = commentaries;
    }

    public ArrayList<String> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<String> likes) {
        this.likes = likes;
    }
}
