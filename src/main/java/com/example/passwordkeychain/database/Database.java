package com.example.passwordkeychain.database;

import com.example.passwordkeychain.model.Account;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;


public class Database {
    private static Database instance;
    private MongoClient client;
    private MongoClientSettings settings;
    private MongoDatabase database;
    private MongoCollection<Account> accounts;
    private CodecRegistry pojoCodecRegistry;

    private final String DATABASE_NAME = "Chain";
    private final String COLLECTION_NAME = "Accounts";


    private Database(){
        pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();
        client = MongoClients.create(settings);
        database = client.getDatabase(DATABASE_NAME);
        accounts = database.getCollection(COLLECTION_NAME, Account.class);


    }

    public static Database getInstance() {
        if(instance == null){
            return new Database();
        }
        return instance;
    }

    public FindIterable<Account> getAllAccounts(){
        return accounts.find();
    }

    public InsertOneResult insertAccount(Account account){
        return accounts.insertOne(account);

    }


    public DeleteResult deleteAccount(Account account){
        Bson query = eq("_id", account.getId());
        return accounts.deleteOne(query);
    }

    public Account findAccount(Account account){
        Bson query = eq("_id", account.getId());
        return accounts.find(query).first();
    }

    public void updateAccount(Account account){
        Bson filter = eq("_id", account.getId());
        Bson query = combine(
                set("siteName", account.getSiteName()),
                set("username", account.getUsername()),
                set("password", account.getPassword())
        );
        accounts.findOneAndUpdate(filter, query);
        return;
    }


}
