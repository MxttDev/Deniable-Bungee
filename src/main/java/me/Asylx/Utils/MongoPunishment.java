package me.Asylx.Utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.net.UnknownHostException;
import java.util.UUID;

public class MongoPunishment {
    public static MongoDatabase mongoDatabase;
    public static MongoCollection mongoCollection;

    public static void SetupMongoDB() throws UnknownHostException {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Admin:admin@data.pnnij.mongodb.net/Players?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        mongoDatabase = mongoClient.getDatabase("Banned");
        mongoCollection = mongoDatabase.getCollection("Players");

        System.out.println("Database CONNECTED.");
    }

    public static Document getData(ProxiedPlayer p) {
        UUID uuid = p.getUniqueId();
        String value = Utils.ConvertUUID(uuid);
        Document PlayerData = (Document) mongoCollection.find(new Document("UUID", value)).first();
        return PlayerData;
    }

    public static Document getDataFromUUID(String UUID) {
        String value =  UUID.replace("-", "");
        Document PlayerData = (Document) mongoCollection.find(new Document("UUID", value)).first();
        return PlayerData;
    }

    public static void clearData(ProxiedPlayer p) {
        UUID uuid = p.getUniqueId();
        String value = Utils.ConvertUUID(uuid);
        Document PlayerData = (Document) mongoCollection.find(new Document("UUID", value)).first();
        Bson document = PlayerData;

        mongoCollection.deleteOne(document);
    }

    public static void clearDatafromUUID(String UUID) {
        Document PlayerData = (Document) mongoCollection.find(new Document("UUID", UUID)).first();
        Bson document = PlayerData;

        mongoCollection.deleteOne(document);
    }

    public static void InsertPlayerData(ProxiedPlayer p, String object, Object newValueObject) {
        Document PlayerData = (Document) mongoCollection.find(new Document("UUID", p.getUniqueId().toString())).first();

        if (PlayerData != null) {
            Bson newValue = new Document(object, newValueObject);
            Bson updatedOperation = new Document("$set", newValue);
            mongoCollection.updateOne(PlayerData, updatedOperation);

            System.out.println("OPERATION UPDATED.");
        } else {
            System.out.println("FAILED. NO DATA FOUND!");
        }

    }

    public static void createBanProfile(ProxiedPlayer p, String reason, long current) {
        Document playerdata = (Document) mongoCollection.find(new Document("UUID", p.getUniqueId().toString())).first();

        Document data = new Document();

        UUID uuid = p.getUniqueId();
        String value = Utils.ConvertUUID(uuid);


        data.append("UUID", value);
        data.append("Name", p.getName());
        data.append("Reason", reason);
        data.append("Expires", current);

        mongoCollection.insertOne(data);

    }

}
