package com.napier.set08103.group27;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DatabaseManager {

    //Probably should make this a singleton

    //Connect to mongodb
    MongoClient mongoClient = new MongoClient("mongodb-server");

    //Get database
    MongoDatabase database = mongoClient.getDatabase("world.sql");
}
