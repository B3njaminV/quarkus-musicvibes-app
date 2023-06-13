package org.musicApp.model;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private ObjectId id;
    private String name;
    private Number duration;
    private List<Genre> genres = new ArrayList<>();

    public Song(String name, Number duration, List<Genre> genres){
        this.name = name;
        this.duration = duration;
        this.genres = genres;
    }

    public Song(){
        this.name = "Song";
        this.duration = 0;
        this.genres = new ArrayList<>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getDuration() {
        return duration;
    }

    public void setDuration(Number duration) {
        this.duration = duration;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
