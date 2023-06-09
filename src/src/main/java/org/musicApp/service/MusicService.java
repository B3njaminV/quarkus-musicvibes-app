package org.musicApp.service;

import org.musicApp.module.Song;
import org.musicApp.repository.MusicRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class MusicService {
    private final MusicRepository repository;

    @Inject
    public MusicService(MusicRepository musicRepository) {
        this.repository = musicRepository;
    }

    public List<Song> getAllMusics() {
        return repository.getAllMusics();
    }

    public Song getMusicById(String id) {
        return repository.getMusicById(id);
    }

    public void addMusic(Song music) {
        repository.addMusic(music);
    }

    public void updateMusic(String id, Song oldMusic) {
        repository.updateMusic(id, oldMusic);
    }

    public void deleteMusic(String id) {
        repository.deleteMusic(id);
    }
}