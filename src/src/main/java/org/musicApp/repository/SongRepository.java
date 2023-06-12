package org.musicApp.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.musicApp.model.Song;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

import java.util.ArrayList;
import java.util.List;


@Singleton
public class SongRepository {
    private final MongoCollection<Document> collection;
    private final MongoDatabase bdd;
    private static final String MONGODB_URL = System.getenv("MONGO");
    private static final String MONGODB_DATABASE = System.getenv("DATABASE");

    @Inject
    public SongRepository() {
        MongoClient db = MongoClients.create(MONGODB_URL);
        this.bdd = db.getDatabase(MONGODB_DATABASE);
        this.collection = bdd.getCollection("song");
    }

    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();
        for (Document doc : collection.find()) {
            Song song = documentToSong(doc);
            songs.add(song);
        }
        return songs;
    }

    public Song getSongById(ObjectId id) {
        Document doc = collection.find(new Document("_id", id)).first();
        if (doc != null) {
            return documentToSong(doc);
        }
        return null;
    }

    public void addSong(Song song) {
        Document doc = songToDocument(song);
        collection.insertOne(doc);
        song.setId(doc.getObjectId("_id"));
    }

    public void updateSong(ObjectId id, Song song) {
        Document filter = new Document("_id", id);
        Document update = songToDocument(song);
        collection.updateOne(filter, new Document("$set", update));
    }

    public void deleteSong(ObjectId id) {
        collection.deleteOne(new Document("_id", id));
    }

    private Document songToDocument(Song song) {
        return new Document("_id", song.getId())
                .append("name", song.getName());
    }

    private Song documentToSong(Document doc) {
        Song song = new Song();
        song.setId(doc.getObjectId("_id"));
        song.setName(doc.getString("name"));
        return song;
    }

}
