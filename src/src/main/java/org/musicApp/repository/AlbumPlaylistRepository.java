package org.musicApp.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
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

        // Création d'un index sur le champ "name" de la collection "albumPlaylist"
        // Etant donné que la plupart des recherches vont se faire sur le nom,
        // il est préférable de créer un index pour accélérer les recherches
        collection.createIndex(Indexes.ascending("name"));
    }

    /**
     * Retourner toute la liste des AlbumPlaylist
     * @return liste des AlbumPlaylist
     */
    public List<AlbumPlaylist> getAllAlbumPlaylists() {
        List<AlbumPlaylist> albumPlaylists = new ArrayList<>();
        for (Document doc : collection.find()) {
            AlbumPlaylist albumPlaylist = documentToAlbumPlaylist(doc);
            albumPlaylists.add(albumPlaylist);
        }
        return albumPlaylists;
    }

    /**
     * Retourner un AlbumPlaylist avec l'id "id" (si trouvé)
     * @param id id de l'albumPlaylist
     * @return albumPlaylist
     */
    public AlbumPlaylist getAlbumPlaylistById(String id) {
        Document doc = collection.find(new Document("_id", new ObjectId(id))).first();
        if (doc != null) {
            return documentToAlbumPlaylist(doc);
        }
        return null;
    }

    /**
     * Retourner un AlbumPlaylist avec le nom "name" (si trouvé)
     * @param name nom de l'albumPlaylist
     * @return albumPlaylist
     */
    public AlbumPlaylist getAlbumPlaylistByName(String name) {
        Document doc = collection.find(new Document("name", name)).first();
        if (doc != null) {
            return documentToAlbumPlaylist(doc);
        }
        return null;
    }

    /**
     * Retourne les AlbumPlaylist qui ont 1 seul titre
     * Cela nous permettra ensuite de différencier entre les playlists et un morceau simple
     * @return liste des AlbumPlaylist
     */
    public List<AlbumPlaylist> getAlbumPlaylistWithOneSong() {
        List<AlbumPlaylist> albumPlaylists = new ArrayList<>();
        List<Document> pipeline = new ArrayList<>();
        pipeline.add(new Document("$match", new Document("songList", new Document("$size", 1))));
        pipeline.add(new Document("$sort", new Document("name", 1)));
        for (Document doc : collection.aggregate(pipeline)) {
            AlbumPlaylist albumPlaylist = documentToAlbumPlaylist(doc);
            albumPlaylists.add(albumPlaylist);
        }
        return albumPlaylists;
    }

    /**
     * Retourner tous les albumsPlaylists qui ont pour auteur l'artiste "name" dans leur liste de artists
     * @param name nom de l'artiste
     * @return liste des albumsPlaylists
     */
    public List<AlbumPlaylist> getAlbumPlaylistsByArtist(String name) {
        List<AlbumPlaylist> albumPlaylists = new ArrayList<>();
        List<Document> pipeline = new ArrayList<>();
        pipeline.add(new Document("$match", new Document("artist", name)));
        pipeline.add(new Document("$sort", new Document("name", 1)));
        for (Document doc : collection.aggregate(pipeline)) {
            AlbumPlaylist albumPlaylist = documentToAlbumPlaylist(doc);
            albumPlaylists.add(albumPlaylist);
        }
        return albumPlaylists;
    }

    /**
     * Ajouter un AlbumPlaylist dans la base de données
     * @param albumPlaylist AlbumPlaylist à ajouter
     */
    public void addAlbumPlaylist(AlbumPlaylist albumPlaylist) {
        Document doc = albumPlaylistToDocument(albumPlaylist);
        collection.insertOne(doc);
    }

    /**
     * Mettre à jour un AlbumPlaylist
     * @param id id de l'AlbumPlaylist
     * @param albumPlaylist AlbumPlaylist
     */
    public void updateAlbumPlaylist(String id, AlbumPlaylist albumPlaylist) {
        Document filter = new Document("_id", new ObjectId(id));
        Document update = albumPlaylistToDocument(albumPlaylist);
        collection.updateOne(filter, new Document("$set", update));
    }

    /**
     * Supprimer un AlbumPlaylist
     * @param id id de l'AlbumPlaylist
     */
    public void deleteAlbumPlaylist(String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }

    /**
     * Convertir un document en AlbumPlaylist
     * @param doc
     * @return
     */
    private AlbumPlaylist documentToAlbumPlaylist(Document doc) {
        AlbumPlaylist albumPlaylist = new AlbumPlaylist();
        albumPlaylist.setId(doc.getObjectId("_id"));
        albumPlaylist.setName(doc.getString("name"));
        return albumPlaylist;
    }

    /**
     * Convertir un AlbumPlaylist en document
     * @param albumPlaylist
     * @return
     */
    private Document albumPlaylistToDocument(AlbumPlaylist albumPlaylist) {
        return new Document("_id", albumPlaylist.getId())
                .append("name", albumPlaylist.getName());
    }
}
