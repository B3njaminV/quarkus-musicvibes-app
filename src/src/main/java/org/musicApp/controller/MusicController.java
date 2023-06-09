package org.musicApp.controller;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.musicApp.module.Song;
import org.musicApp.service.SongService;

import java.util.List;


@Slf4j
@Path("/api/songs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MusicController {

    private final SongService service;

    @Inject
    public MusicController(SongService musicService) {
        this.service = musicService;
    }

    @GET
    public List<Song> getAllSongs() {
        return service.getAllSongs();
    }

    @GET
    @Path("/{id}")
    public Song getSongById(ObjectId id) {
        return service.getSongById(id);
    }

    @POST
    public void addSong(Song song) {
        service.addSong(song);
    }

    @PUT
    @Path("/{id}")
    public void updateSong(ObjectId id, Song song) {
        service.updateSong(id, song);
    }

    @DELETE
    @Path("/{id}")
    public void deleteSong(ObjectId id) {
        service.deleteSong(id);
    }

}
