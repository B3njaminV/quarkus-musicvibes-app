package org.musicApp.service;

import org.bson.types.ObjectId;
import org.musicApp.entities.Song;
import org.musicApp.repository.SongRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
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

    public Song getSongById(String id) {
        return repository.getSongById(id);
    }

    public Song getSongByName(String name) {
        return repository.getSongByName(name);
    }

    public List<Song> getSongsByGenre(String genre) {
        return repository.getSongsByGenre(genre);
    }

    public void addSong(Song song) {
        List<String> erreurs = new ArrayList<>();
        if (song.getName().isEmpty()) {
            erreurs.add("Aucun nom n'a été renseigné !");
        }
        if ((song.getDuration() == null) || (song.getDuration() == 0.0)) {
            erreurs.add("Aucune durée n'a été renseigné !");
        }
        if (song.getId() == null) {
            erreurs.add("Aucun id trouvé !");
        }
        if(song.getGenres() == null){
            erreurs.add("Aucun genres trouvé !");
        }
        if (erreurs.size() > 0) {
            throw new IllegalArgumentException(erreurs.toString());
        }else{
            repository.addSong(song);
        }
    }

    public void updateSong(String id, Song song) {
        repository.updateSong(id, song);
    }

    public void deleteSong(String id) {
        repository.deleteSong(id);
    }
}
