package org.musicApp.model;

import org.bson.types.ObjectId;

public class Artist {

    private ObjectId id;
    private String username;
    private String password;

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
}
