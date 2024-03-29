package org.musicApp.repository;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DBConnection {
    private static final String MONGODB_URL = "mongodb://localhost:27017";
    private static final String MONGODB_DATABASE = "musicvibes";

    public static MongoDatabase getDatabase() {
        MongoClient db = MongoClients.create(MONGODB_URL);
        return db.getDatabase(MONGODB_DATABASE);
    }
}
