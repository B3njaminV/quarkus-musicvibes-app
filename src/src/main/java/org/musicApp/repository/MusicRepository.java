package org.musicApp.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import jakarta.ws.rs.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.musicApp.module.Music;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

import java.util.ArrayList;
import java.util.List;


@Singleton
public class MusicRepository {

    private final MongoCollection<Document> collection;
    private final MongoDatabase bdd;
    private static final String MONGODB_URL = "mongodb://localhost:27017";
    private static final String MONGODB_DATABASE = "lequipe";

    @Inject
    public MusicRepository() {
        MongoClient db = MongoClients.create(MONGODB_URL);
        this.bdd = db.getDatabase(MONGODB_DATABASE);
        this.collection = bdd.getCollection("music");
    }

    public List<Music> getAllMusics() {
        List<Music> musics = new ArrayList<>();
        for (Document doc : collection.find()) {
            Music music = documentToMusic(doc);
            musics.add(music);
        }
        return musics;
    }

    public Music getMusicById(@PathParam("id") String id) {
        Document doc = collection.find(new Document("_id", new ObjectId(id))).first();
        if (doc != null) {
            return documentToMusic(doc);
        }
        return null;
    }

    public void addMusic(Music music) {
        Document doc = musicToDocument(music);
        collection.insertOne(doc);
        music.setId(doc.getObjectId("_id").toString());
    }

    public void updateMusic(@PathParam("id") String id, Music oldmusic) {
        Document filter = new Document("_id", new ObjectId(id));
        Document update = musicToDocument(oldmusic);
        collection.updateOne(filter, new Document("$set", update));
    }

    public void deleteMusic(@PathParam("id") String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }

    private Document musicToDocument(Music music) {
        return new Document("_id", new ObjectId(music.getId()))
                .append("name", music.getName());
    }

    private Music documentToMusic(Document doc) {
        Music music = new Music();
        music.setId(doc.getObjectId("_id").toString());
        music.setName(doc.getString("name"));
        return music;
    }

}
