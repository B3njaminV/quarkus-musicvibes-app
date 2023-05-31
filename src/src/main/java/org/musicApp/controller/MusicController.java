package org.musicApp.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.musicApp.module.Music;
import org.musicApp.repository.MusicRepository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Slf4j
@Path("/api/musics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MusicController {

    @Inject
    MusicRepository musicManagerController;
    private Set<Music> musicSet = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public MusicController() {
        musicSet.add(new Music("lol"));
        musicSet.add(new Music("hello"));
        musicSet.add(new Music("cool"));
        musicSet.add(new Music("no"));

    }

    @GET
    public Response getAllMusic(){
        System.out.println("hello i m the get");
        //musicManagerController.getMusics();
        return Response.ok(musicSet).build() ;
    }

}
