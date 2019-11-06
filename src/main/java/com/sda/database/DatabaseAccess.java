package com.sda.database;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DatabaseAccess {
    private static DatabaseAccess db;

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    private DatabaseAccess() {
        this.client = new MongoClient();
        this.database = client.getDatabase("clinica");
        this.collection = database.getCollection("doctori");
    }

    //SINGLETON pattern, making sure we have only 1 connection open
    public static DatabaseAccess getDatabaseAccess() {
        if (db == null) {
            db = new DatabaseAccess();
        }
        return db;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public static void closeClientConnection() {
        db.client.close();
    }

    /**
     * @param nume = the name of the searched doctor
     * @return a doctor, as a Document
     */
    public Document findDocument(String nume) {
        return collection.find(new Document("name", nume)).first();
    }

    public void saveDoctor(Document doctor) {
        Document findResult = findDocument(doctor.getString("name"));

        if (findResult == null || findResult.isEmpty()) {
            collection.insertOne(doctor);
        } else {
            System.err.println("Doctor already saved!");
        }
    }

    public void updateDoctor(Document doctor, List insertItems) {
        collection.updateOne(new Document("name", doctor.getString("name")),
                new Document("$set", doctor.append("pacienti",
                        new ArrayList<String>(insertItems))));
    }

    public void printPatients() {
        for (Document document : collection.find(new Document())) {
            System.out.println(document.get("pacienti"));
        }
    }

    public void printDoctors() {
        for (Document document : collection.find(new Document())) {
            System.out.println(document);
        }
    }
}
