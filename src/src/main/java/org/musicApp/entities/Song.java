package org.musicApp.entities;

import org.bson.types.ObjectId;
import org.musicApp.model.Genre;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private ObjectId id;
    private String name;
    private Double duration;
    private List<Genre> genres = new ArrayList<>();

    public Song(String name, Double duration, List<Genre> genres){
        this.name = name;
        this.duration = duration;
        this.genres = genres;
    }

    public Song(){
        this.name = "Song";
        this.duration = 0.0;
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

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}