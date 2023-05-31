package org.musicApp.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.inject.Singleton;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.musicApp.module.Music;

import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;

@Singleton
public class MusicRepository {

    private MusicRepository musicManager = new MusicRepository();

    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry  = fromRegistries(getDefaultCodecRegistry(),fromProviders(pojoCodecProvider));


    @ConfigProperty(name = "mongo.string")
    String uri ;

    @ConfigProperty(name = "mongo.database")
    String dbName ;

    public void getMusics(){
        System.out.println("startGet");
        try(MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("dbName").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Music> collection = database.getCollection("music", Music.class);

            List<Music> musics = (List<Music>) collection.find(eq("name", "Back to the Future"));
            System.out.println(musics);
        }
    }


}
