package com.myapp.addressbookapp.buddy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 BuddyService: Service Class for Buddy
 @date: Feb. 17, 2022
 @author: Desmond Blake 101073534

 **/

@Service
public class BuddyService {
    @Autowired private buddyRepository budrepo;

    public List<Buddy> listAll() {
        return (List<Buddy>) budrepo.findAll();
    }

    public void save(Buddy buddy) {
        budrepo.save(buddy);
    }

    public void delete(Integer Id) {
        budrepo.deleteById(Id);
    }

    public Buddy get(Integer Id){
        Optional<Buddy> buddy = budrepo.findById(Id);

        if (buddy.isPresent()) {
            return buddy.get();
        }
        return null;
    }

    public String greet() {
        return "Welcome to the Address Book";
    }
}
