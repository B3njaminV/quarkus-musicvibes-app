package org.musicApp.repository;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DBConnection {
    private static final String MONGODB_URL = System.getenv("MONGO");
    private static final String MONGODB_DATABASE = System.getenv("DATABASE");

    public static MongoDatabase getDatabase() {
        MongoClient db = MongoClients.create(MONGODB_URL);
        return db.getDatabase(MONGODB_DATABASE);
    }
}
