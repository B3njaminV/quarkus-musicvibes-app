package org.musicApp.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.musicApp.entities.Song;

import java.util.ArrayList;
import java.util.List;


@Singleton
public class SongRepository {
    private final MongoCollection<Document> collection;
    private final MongoDatabase bdd;

    @Inject
    public SongRepository() {
        this.bdd = DBConnection.getDatabase();
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

    public Song getSongById(String id) {
        Document doc = collection.find(new Document("_id", new ObjectId(id))).first();
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

    public void updateSong(String id, Song song) {
        Document filter = new Document("_id", new ObjectId(id));
        Document update = songToDocument(song);
        collection.updateOne(filter, new Document("$set", update));
    }

    public void deleteSong(String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id)));
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
