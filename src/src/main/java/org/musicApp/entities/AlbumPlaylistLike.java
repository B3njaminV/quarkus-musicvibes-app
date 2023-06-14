package org.musicApp.entities;

import org.bson.types.ObjectId;

import java.util.List;

public class AlbumPlaylistLike {

    private boolean isLike;

    private List<String> albums_playlists;

    public AlbumPlaylistLike(boolean isLike, List<String> albums_playlists){
        this.isLike = isLike;
        this.albums_playlists = albums_playlists;
    }

    public AlbumPlaylistLike(){
        this.isLike = false;
        this.albums_playlists = null;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public List<String> getAlbums_playlists() {
        return albums_playlists;
    }

    public void setAlbums_playlists(List<String> albums_playlists) {
        this.albums_playlists = albums_playlists;
    }

    public void addAlbumOrPlaylist(String albumId){
        this.albums_playlists.add(albumId);
    }

    public void removeAlbumOrPlaylist(String albumId){
        this.albums_playlists.remove(albumId);
    }
}
