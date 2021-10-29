package com.example.passwordkeychain.test;

import static com.mongodb.client.model.Filters.eq;
import static org.junit.Assert.assertEquals;

import com.example.passwordkeychain.database.Database;
import com.example.passwordkeychain.model.Account;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import org.junit.*;

public class DatabaseTest {

    @Test
    public void testDatabaseInsert(){
        Database db = Database.getInstance();

        Account testAccount = new Account("siteNameTest", "usernameTest", "passwordTest");

        InsertOneResult res = db.insertAccount(testAccount);

        Account testAccountRetrieved = db.findAccount(testAccount);

        Assert.assertEquals(testAccount.getId(),testAccountRetrieved.getId());
        Assert.assertEquals(testAccount.getSiteName(), testAccountRetrieved.getSiteName());
        Assert.assertEquals(testAccount.getUsername(), testAccountRetrieved.getUsername());
        Assert.assertEquals(testAccount.getPassword(), testAccountRetrieved.getPassword());
        Assert.assertTrue(res.wasAcknowledged());
    }

    @Test
    public void testDatabaseDelete(){
        Database db = Database.getInstance();

        Account testAccount = new Account("siteNameTest", "usernameTest", "passwordTest");
        db.insertAccount(testAccount);

        DeleteResult res = db.deleteAccount(testAccount);

        Account searchRes = db.findAccount(testAccount);

        Assert.assertTrue(res.wasAcknowledged());
        Assert.assertNull(searchRes);
    }

    @Test
    public void testDatabaseUpdate(){
        Database db = Database.getInstance();

        Account testAccount = new Account("siteNameTest", "usernameTest", "passwordTest");

        InsertOneResult insertOneResult = db.insertAccount(testAccount);

        testAccount.setUsername("newUsername");
        testAccount.setPassword("newPassword");
        testAccount.setSiteName("newSitename");

        db.updateAccount(testAccount);

        Account updateResult = db.findAccount(testAccount);

        assertEquals(testAccount.getId(), updateResult.getId());
        assertEquals(testAccount.getSiteName(), updateResult.getSiteName());
        assertEquals(testAccount.getUsername(), updateResult.getUsername());
        assertEquals(testAccount.getPassword(), updateResult.getPassword());


    }


}
