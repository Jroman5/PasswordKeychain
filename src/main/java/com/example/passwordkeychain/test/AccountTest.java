package com.example.passwordkeychain.test;

import com.example.passwordkeychain.model.Account;
import org.junit.*;

public class AccountTest {

    @Test
    public void testGetSitename(){
        String testSitename = "Site_name_test";
        Account testAccount = new Account(testSitename, "username", "password");

        Assert.assertEquals(testSitename, testAccount.getSiteName());
    }

    @Test
    public void testGetUsername(){
        String testUsername = "Site_username";
        Account testAccount = new Account("site_name_test", testUsername, "password");

        Assert.assertEquals(testUsername, testAccount.getUsername());
    }

    @Test
    public void testGetPassword(){
        String testPassword = "Site_Password";
        Account testAccount = new Account("test_site_name", "username", testPassword);

        Assert.assertEquals(testPassword, testAccount.getPassword());
    }

    @Test
    public void testSetSitename(){
        String testSitename1 = "test_sitename1";
        String testSitename2 = "test_sitename2";
        Account testAccount = new Account(testSitename1, "username", "password");
        testAccount.setSiteName(testSitename2);

        Assert.assertEquals(testSitename2, testAccount.getSiteName());

    }

    @Test
    public void testSetUsername(){
        String testUsername1 = "test_username1";
        String testUsername2 = "test_username2";
        Account testAccount = new Account("sitename", testUsername1, "password");
        testAccount.setUsername(testUsername2);

        Assert.assertEquals(testUsername2, testAccount.getUsername());
    }

    @Test
    public void testSetPassword(){
        String testPassword1 = "test_password1";
        String testPassword2 = "test_password2";
        Account testAccount = new Account("sitename", "username", testPassword1);
        testAccount.setPassword(testPassword2);

        Assert.assertEquals(testPassword2, testAccount.getPassword());
    }
}
