package org.musicApp.module;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private ObjectId id;
    private Artist  artist;
    private String name;
    private List<Genre> genres = new ArrayList<>();
    private String cover;
    private String description;
    private List<Song> musicList = new ArrayList<>();

    public Album(Artist artist, String name, List<Genre> genres, String cover, String description, List<Song> musicList){
        this.artist = artist;
        this.name = name;
        this.genres = genres;
        this.cover = cover;
        this.description = description;
        this.musicList = musicList;
    }

    public Album(){
        this.artist = new Artist();
        this.name = "Album";
        this.genres = new ArrayList<>();
        this.cover = "Cover";
        this.description = "Description";
        this.musicList = new ArrayList<>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Song> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Song> musicList) {
        this.musicList = musicList;
    }

    public void addSong(Song song){
        this.musicList.add(song);
    }

    public void addGenre(Genre genre){
        this.genres.add(genre);
    }

    public void removeSong(Song song){
        this.musicList.remove(song);
    }

    public void removeGenre(Genre genre){
        this.genres.remove(genre);
    }
}
