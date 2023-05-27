package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchTest() {
      // mandatory information test
      User user1 = new User(null,null,null);
      List<User> users = new ArrayList<>();
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class , () -> SILab2.function(user1,users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        //

        //password less than 8 characters
        User user2 = new User ("lukabazuka", "sedumka", "lukaradulovikj@gmail.com");
        assertFalse(SILab2.function(user2,users));
        //


        //password has a " " in it
        User user3 = new User("lukaraduki", "sedummm kaaa", "lukaradulovikj@gmail.com");
        assertFalse(SILab2.function(user3,users));
        //

        //invalid email
        User user4 = new User("lukabazuka", "sedumka12@@34sedumka", "ovaneeemailadresa");
        assertFalse(SILab2.function(user4,users));
        //

        //adding to user list with same usernames and different emails
        User user5 = new User("lukaluka","gospodin!!!", "luka@gmail.com");
        User user6 = new User("lukaluka","vtorgospodin!!", "luka123@gmail.com");
        User user7 = new User("luka123", "tretgospodin!!!", "luka12345@gmail.com");
        users.add(user5);
        users.add(user6);
        users.add(user7);
        assertFalse(SILab2.function(user7,users));
        //

        //setting email as username
        User user8 = new User(null, "lukapuka123!", "lukaradulovikj@gmail.com");
        assertTrue(SILab2.function(user8,users));
        //


    }
    @Test
    void multipleConditionsTest(){
        List<User> users = new ArrayList<>();
        // Site uslovi se tochni (user e null)
        User user1 = null;
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class , () -> SILab2.function(user1,users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // Samo email-ot e null
        User user2 = new User("lukabazuka", "gospodin!!!", null);
        ex = assertThrows(RuntimeException.class , () -> SILab2.function(user1,users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // Samo passwordot e null
        User user3 = new User("gospodinot123", null, "luka@gmail.com");
        ex = assertThrows(RuntimeException.class , () -> SILab2.function(user1,users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // Nitu eden ne e null e vsushnost Every Branch Testot, bez prviot test primer, pa nema potreba dopolnitelno da go prepokrivame.
    }
}