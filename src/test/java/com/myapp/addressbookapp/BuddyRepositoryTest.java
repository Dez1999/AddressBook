package com.myapp.addressbookapp;

import com.myapp.addressbookapp.buddy.Buddy;
import com.myapp.addressbookapp.buddy.buddyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

/**
 BuddyRepository Test Class
 @date: Feb. 17, 2022
 @author: Desmond Blake 101073534

 **/

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class BuddyRepositoryTest {
    @Autowired private buddyRepository budrepo;

    @Test
    public void addBuddyTest() {
        Buddy buddy1 = new Buddy();
        buddy1.setFirstName("Des");
        buddy1.setLastName("Blake");
        buddy1.setPhoneNumber("888-999-7777");

        Buddy Buddy_Saved = budrepo.save(buddy1);

        //Assert saved buddy is in database and first name is correct
        Assertions.assertEquals("Des", Buddy_Saved.getFirstName());
    }

    @Test
    public void listAllBuddiesTest() {
        Iterable<Buddy> buddies = budrepo.findAll();
        Assertions.assertNotNull(buddies);

        for (Buddy buddy : buddies) {
            System.out.println(buddy);
        }
    }


    public void updateBuddyTest() {
        Integer buddyID = 1;
        Optional<Buddy> optionalBuddy = budrepo.findById(buddyID);
        Buddy buddy = optionalBuddy.get();
        buddy.setPhoneNumber("613-000-8888");
        budrepo.save(buddy);

        Buddy updatedBuddy = budrepo.findById(buddyID).get();
        Assertions.assertNotNull(updatedBuddy.getPhoneNumber());

    }

    @Test
    public void getBuddyTest() {
        Optional<Buddy> optBuddy = budrepo.findById(2);
        Assertions.assertNotNull(optBuddy);
    }


    public void deleteBuddyTest() {
        Buddy buddy1 = new Buddy();
        buddy1.setFirstName("John");
        buddy1.setLastName("Blake");
        buddy1.setPhoneNumber("888-999-7777");

        budrepo.save(buddy1);

        Buddy buddy2 = new Buddy();
        buddy2.setFirstName("John");
        buddy2.setLastName("Begrain");
        buddy2.setPhoneNumber("888-999-7777");

        budrepo.save(buddy2);

        int id = 2;
        Assertions.assertNotNull(buddy2);
    }

}
