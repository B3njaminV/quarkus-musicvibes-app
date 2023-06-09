package org.musicApp.module;


import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Artist {

    private ObjectId id;
    private String username;
    private String password;

    private List<ObjectId> albums_playlists = new ArrayList<>();

    public Artist(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Artist(){
        this.username = "Artist";
        this.password = "Artist";
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ObjectId> getAlbums_playlists() {
        return albums_playlists;
    }

    public void setAlbums_playlists(List<ObjectId> albums_playlists) {
        this.albums_playlists = albums_playlists;
    }

    public void addAlbum(ObjectId albumId){
        this.albums_playlists.add(albumId);
    }

    public void removeAlbum(ObjectId albumId){
        this.albums_playlists.remove(albumId);
    }
}
