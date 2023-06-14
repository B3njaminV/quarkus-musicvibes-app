package org.musicApp.model;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String username;
    private String password;

    private List<ObjectId> library = new ArrayList<>();

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(){
        this.username = "User";
        this.password = "User";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<ObjectId> getLibrary() {
        return library;
    }

    public void setLibrary(List<ObjectId> library) {
        this.library = library;
    }
}
