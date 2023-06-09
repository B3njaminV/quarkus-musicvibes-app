package org.musicApp.service;

import org.bson.types.ObjectId;
import org.musicApp.module.Song;
import org.musicApp.repository.SongRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class SongService {
    private final SongRepository repository;

    @Inject
    public SongService(SongRepository songRepository) {
        this.repository = songRepository;
    }

    public List<Song> getAllSongs() {
        return repository.getAllSongs();
    }

    public Song getSongById(ObjectId id) {
        return repository.getSongById(id);
    }

    public void addSong(Song song) {
        repository.addSong(song);
    }

    public void updateSong(ObjectId id, Song song) {
        repository.updateSong(id, song);
    }

    public void deleteSong(ObjectId id) {
        repository.deleteSong(id);
    }
}
