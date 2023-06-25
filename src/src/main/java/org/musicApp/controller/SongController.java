package org.musicApp.controller;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.musicApp.entities.Song;
import org.musicApp.service.SongService;

import java.util.List;


@Slf4j
@Path("/api/songs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SongController {

    private final SongService service;

    @Inject
    public SongController(SongService songService) {
        this.service = songService;
    }

    @GET
    public List<Song> getAllSongs() {
        return service.getAllSongs();
    }

    @GET
    @Path("/{id}")
    public Song getSongById(@PathParam("id") String id) {
        return service.getSongById(id);
    }

    @GET
    @Path("/name/{name}")
    public Song getSongByName(@PathParam("name") String name) {
        return service.getSongByName(name);
    }

    @GET
    @Path("/partialName/{partialName}")
    public List<Song> getAllSongWithPartialName(@PathParam("partialName") String partialName) {
        return service.getAllSongWithPartialName(partialName);
    }

    @GET
    @Path("/getSongCountByDuration")
    public List<Document> getSongCountByDuration() {
        return service.getSongCountByDuration();
    }

    @GET
    @Path("/getAllSongWithDurationSuperior120")
    public List<Song> getAllSongWithDurationSuperior120() {
        return service.getAllSongWithDurationSuperior120();
    }

    @GET
    @Path("/genre/{genre}")
    public List<Song> getSongsByGenre(@PathParam("genre") String genre) {
        return service.getSongsByGenre(genre);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addSong(Song song) {
        service.addSong(song);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateSong(@PathParam("id") String id, Song song) {
        service.updateSong(id, song);
    }

    @DELETE
    @Path("/{id}")
    public void deleteSong(@PathParam("id") String id) {
        service.deleteSong(id);
    }

}
