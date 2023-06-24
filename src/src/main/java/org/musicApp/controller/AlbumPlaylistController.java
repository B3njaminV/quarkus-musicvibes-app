package org.musicApp.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.musicApp.entities.AlbumPlaylist;
import org.musicApp.service.AlbumPlaylistService;

import java.util.List;

@Slf4j
@Path("/api/album-playlist")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlbumPlaylistController {

    private final AlbumPlaylistService service;

    @Inject
    public AlbumPlaylistController(AlbumPlaylistService albumPlaylistService) {
        this.service = albumPlaylistService;
    }

    @GET
    public List<AlbumPlaylist> getAllAlbumPlaylists() {
        return service.getAllAlbumPlaylists();
    }

    @GET
    @Path("/{id}")
    public AlbumPlaylist getAlbumPlaylistById(@PathParam("id") String id) {
        return service.getAlbumPlaylistById(id);
    }

    @GET
    @Path("/name/{name}")
    public AlbumPlaylist getAlbumPlaylistByName(@PathParam("name") String name) {
        return service.getAlbumPlaylistByName(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAlbumPlaylist(AlbumPlaylist albumPlaylist) {
        service.addAlbumPlaylist(albumPlaylist);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAlbumPlaylist(@PathParam("id") String id, AlbumPlaylist albumPlaylist) {
        service.updateAlbumPlaylist(id, albumPlaylist);
    }

    @DELETE
    @Path("/{id}")
    public void deleteAlbumPlaylist(@PathParam("id") String id) {
        service.deleteAlbumPlaylist(id);
    }
}
