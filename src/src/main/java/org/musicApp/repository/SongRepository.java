package org.musicApp.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import org.bson.Document;
import org.bson.conversions.Bson;
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

        // Création d'un index sur le champ "name" de la collection "song"
        // Etant donné que la plupart des recherches vont se faire sur le nom,
        // il est préférable de créer un index pour accélérer les recherches
        collection.createIndex(Indexes.ascending("name"));
    }

    /**
     * Retourner toute la liste des Song
     * @return liste des Song
     */
    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();
        for (Document doc : collection.find()) {
            Song song = documentToSong(doc);
            songs.add(song);
        }
        return songs;
    }

    /**
     * Retourner le Song (si trouvé) du Song avec l'id "id"
     * @param id id du song
     * @return song
     */
    public Song getSongById(String id) {
        Document doc = collection.find(new Document("_id", new ObjectId(id))).first();
        if (doc != null) {
            return documentToSong(doc);
        }
        return null;
    }

    /**
     * Retourner le Song (si trouvé) du Song avec le nom "name"
     * @param name nom du song
     * @return song
     */
    public Song getSongByName(String name) {
        Document doc = collection.find(new Document("name", name)).first();
        if (doc != null) {
            return documentToSong(doc);
        }
        return null;
    }

    /**
     * Recherche sur la collection à partir d'un genre donné
     * @param genre
     * @return
     */
    public List<Song> getSongsByGenre(String genre) {
        List<Song> songs = new ArrayList<>();
        Bson filter = Filters.in("genre", genre);
        for (Document doc : collection.find(filter)) {
            Song song = documentToSong(doc);
            songs.add(song);
        }
        return songs;
    }

    /**
     * Compter le nombre de Song groupé par leur durée (en utilisant une aggrégation)
     * @return list of document
     */
    public List<Document> getSongCountByDuration() {
        List<Document> documents = new ArrayList<>();
        List<Bson> pipeline = new ArrayList<>();
        pipeline.add(new Document("$group", new Document("_id", "$duration").append("count", new Document("$sum", 1))));
        pipeline.add(new Document("$sort", new Document("_id", 1)));
        collection.aggregate(pipeline).into(documents);
        return documents;
    }

    /**
     * Retourne les songs qui ont un nom du type ?name?
     * @param name
     * @return liste des Song
     */
    public List<Song> getAllSongWithPartialName(String name) {
        List<Song> songs = new ArrayList<>();
        Bson filter = Filters.regex("name", name);
        for (Document doc : collection.find(filter)) {
            Song song = documentToSong(doc);
            songs.add(song);
        }
        return songs;
    }

    /**
     * Retourne tous les Song qui ont une durée supérieur à 2h
     * @return liste des Song
     */
    public List<Song> getAllSongWithDurationSuperior120() {
        List<Song> trueSongs = new ArrayList<>();
        List<Document> songs = new ArrayList<>();
        List<Bson> pipeline = new ArrayList<>();
        pipeline.add(new Document("$match", new Document("duration", new Document("$gt", 120))));
        pipeline.add(new Document("$project", new Document("name", 1).append("duration", 1)));
        collection.aggregate(pipeline).into(songs);
        for (Document doc : songs) {
            Song song = documentToSong(doc);
            trueSongs.add(song);
        }
        return trueSongs;
    }

    /**
     * Ajouter un song
     * @param song song
     */
    public void addSong(Song song) {
        Document doc = songToDocument(song);
        collection.insertOne(doc);
        song.setId(doc.getObjectId("_id"));
    }

    /**
     * Mettre à jour un song
     * @param id id song
     * @param song song
     */
    public void updateSong(String id, Song song) {
        Document filter = new Document("_id", new ObjectId(id));
        Document update = songToDocument(song);
        collection.updateOne(filter, new Document("$set", update));
    }

    /**
     * Supprimer un song
     * @param id id song
     */
    public void deleteSong(String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }

    /**
     * Convertir un song en document
     * @param song
     * @return document
     */
    private Document songToDocument(Song song) {
        return new Document("_id", song.getId())
                .append("name", song.getName());
    }

    /**
     * Convertir un document en song
     * @param doc
     * @return song
     */
    private Song documentToSong(Document doc) {
        Song song = new Song();
        song.setId(doc.getObjectId("_id"));
        song.setName(doc.getString("name"));
        return song;
    }

}
