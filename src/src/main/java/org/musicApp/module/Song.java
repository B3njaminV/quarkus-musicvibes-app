package org.musicApp.module;

public class Song {

    private String name;
    private String id;


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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
