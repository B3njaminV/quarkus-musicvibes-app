package org.musicApp.entities;

import org.bson.types.ObjectId;
import org.musicApp.model.Genre;
import org.musicApp.model.Song;

import java.util.ArrayList;
import java.util.List;

public class AlbumPlaylist {

    private ObjectId id;
    private Artist artist;
    private String name;
    private List<Genre> genres = new ArrayList<>();
    private String cover;
    private String description;
    private List<Song> songList = new ArrayList<>();

    public AlbumPlaylist(Artist artist, String name, List<Genre> genres, String cover, String description, List<Song> songList){
        this.artist = artist;
        this.name = name;
        this.genres = genres;
        this.cover = cover;
        this.description = description;
        this.songList = songList;
    }

    public AlbumPlaylist(){
        this.artist = new Artist();
        this.name = "Album";
        this.genres = new ArrayList<>();
        this.cover = "Cover";
        this.description = "Description";
        this.songList = new ArrayList<>();
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

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public void addSong(Song song){
        this.songList.add(song);
    }

    public void removeSong(Song song){
        this.songList.remove(song);
    }

    public void addGenre(Genre genre){
        this.genres.add(genre);
    }

    public void removeGenre(Genre genre){
        this.genres.remove(genre);
    }
}
