package org.musicApp.controller;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.musicApp.module.Song;
import org.musicApp.service.MusicService;

import java.util.List;


@Slf4j
@Path("/api/musics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MusicController {

    private final MusicService service;

    @Inject
    public MusicController(MusicService musicService) {
        this.service = musicService;
    }

    @GET
    public List<Song> getAllMusics() {
        return service.getAllMusics();
    }

    @GET
    @Path("/{id}")
    public Song getMusicById(@PathParam("id") String id) {
        return service.getMusicById(id);
    }

    @POST
    public void addMusic(Song music) {
        service.addMusic(music);
    }

    @PUT
    @Path("/{id}")
    public void updateMusic(@PathParam("id") String id, Song oldMusic) {
        service.updateMusic(id, oldMusic);
    }

    @DELETE
    @Path("/{id}")
    public void deleteMusic(@PathParam("id") String id) {
        service.deleteMusic(id);
    }

}
