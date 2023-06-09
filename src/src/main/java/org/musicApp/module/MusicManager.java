package org.musicApp.module;

import java.util.ArrayList;
import java.util.List;

public class MusicManager {
    private List<Song> favMusicList = new ArrayList<>();
    private List<Artist> favArtistList = new ArrayList<>();
    private  List<Album> favAlbumList = new ArrayList<>();

    public List<Album> getFavAlbumList() {
        return favAlbumList;
    }

    public void setFavAlbumList(List<Album> favAlbumList) {
        this.favAlbumList = favAlbumList;
    }

    public List<Artist> getFavArtistList() {
        return favArtistList;
    }

    public void setFavArtistList(List<Artist> favArtistList) {
        this.favArtistList = favArtistList;
    }

    public List<Song> getFavMusicList() {
        return favMusicList;
    }

    public void setFavMusicList(List<Song> favMusicList) {
        this.favMusicList = favMusicList;
    }
}
