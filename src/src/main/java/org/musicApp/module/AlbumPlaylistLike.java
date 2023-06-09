package org.musicApp.module;

import org.bson.types.ObjectId;

import java.util.List;

public class AlbumPlaylistLike {

    private boolean isLike;

    private List<ObjectId> albums_playlists;

    public AlbumPlaylistLike(boolean isLike, List<ObjectId> albums_playlists){
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

    public List<ObjectId> getAlbums_playlists() {
        return albums_playlists;
    }

    public void setAlbums_playlists(List<ObjectId> albums_playlists) {
        this.albums_playlists = albums_playlists;
    }

    public void addAlbumOrPlaylist(ObjectId albumId){
        this.albums_playlists.add(albumId);
    }

    public void removeAlbumOrPlaylist(ObjectId albumId){
        this.albums_playlists.remove(albumId);
    }
}
