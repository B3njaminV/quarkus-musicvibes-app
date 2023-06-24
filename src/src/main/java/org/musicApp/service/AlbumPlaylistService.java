package org.musicApp.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.musicApp.entities.AlbumPlaylist;
import org.musicApp.repository.AlbumPlaylistRepository;
import org.musicApp.repository.SongRepository;

import java.util.List;

@Singleton
public class AlbumPlaylistService {

    private final AlbumPlaylistRepository repository;

    @Inject
    public AlbumPlaylistService(AlbumPlaylistRepository albumPlaylistRepository) {
        this.repository = albumPlaylistRepository;
    }

    public List<AlbumPlaylist> getAllAlbumPlaylists() {
        return repository.getAllAlbumPlaylists();
    }

    public AlbumPlaylist getAlbumPlaylistById(String id) {
        return repository.getAlbumPlaylistById(id);
    }

    public AlbumPlaylist getAlbumPlaylistByName(String name) {
        return repository.getAlbumPlaylistByName(name);
    }

    public void addAlbumPlaylist(AlbumPlaylist albumPlaylist) {
        repository.addAlbumPlaylist(albumPlaylist);
    }

    public void updateAlbumPlaylist(String id, AlbumPlaylist albumPlaylist) {
        repository.updateAlbumPlaylist(id, albumPlaylist);
    }

    public void deleteAlbumPlaylist(String id) {
        repository.deleteAlbumPlaylist(id);
    }


}
