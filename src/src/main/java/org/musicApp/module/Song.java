package org.musicApp.module;

import org.bson.types.ObjectId;

public class Song {

    private String name;
    private ObjectId id;

    public Song(String name){
        this.name=name;
    }

    public Song(){
        this.name = "Music";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
