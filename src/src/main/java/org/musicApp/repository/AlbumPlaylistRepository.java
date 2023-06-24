package org.musicApp.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.musicApp.entities.AlbumPlaylist;
import org.musicApp.entities.Song;

import javax.swing.event.DocumentEvent;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class AlbumPlaylistRepository {

    private final MongoCollection<Document> collection;
    private final MongoDatabase bdd;

    @Inject
    public AlbumPlaylistRepository() {
        this.bdd = DBConnection.getDatabase();
        this.collection = bdd.getCollection("albumPlaylist");
    }

    public List<AlbumPlaylist> getAllAlbumPlaylists() {
        List<AlbumPlaylist> albumPlaylists = new ArrayList<>();
        for (Document doc : collection.find()) {
            AlbumPlaylist albumPlaylist = documentToAlbumPlaylist(doc);
            albumPlaylists.add(albumPlaylist);
        }
        return albumPlaylists;
    }

    public AlbumPlaylist getAlbumPlaylistById(String id) {
        Document doc = collection.find(new Document("_id", new ObjectId(id))).first();
        if (doc != null) {
            return documentToAlbumPlaylist(doc);
        }
        return null;
    }

    public AlbumPlaylist getAlbumPlaylistByName(String name) {
        Document doc = collection.find(new Document("name", name)).first();
        if (doc != null) {
            return documentToAlbumPlaylist(doc);
        }
        return null;
    }

    private AlbumPlaylist documentToAlbumPlaylist(Document doc) {
        AlbumPlaylist albumPlaylist = new AlbumPlaylist();
        albumPlaylist.setId(doc.getObjectId("_id"));
        albumPlaylist.setName(doc.getString("name"));
        return albumPlaylist;
    }

    public void addAlbumPlaylist(AlbumPlaylist albumPlaylist) {
        Document doc = albumPlaylistToDocument(albumPlaylist);
        collection.insertOne(doc);
    }

    public void updateAlbumPlaylist(String id, AlbumPlaylist albumPlaylist) {
        Document filter = new Document("_id", new ObjectId(id));
        Document update = albumPlaylistToDocument(albumPlaylist);
        collection.updateOne(filter, new Document("$set", update));
    }

    public void deleteAlbumPlaylist(String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }

    private Document albumPlaylistToDocument(AlbumPlaylist albumPlaylist) {
        return new Document("_id", albumPlaylist.getId())
                .append("name", albumPlaylist.getName());
    }
}
