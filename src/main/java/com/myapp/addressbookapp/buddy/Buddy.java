package com.myapp.addressbookapp.buddy;

import javax.persistence.*;

/**
 BuddyClass: Buddy contained in Address Book
 @date: Feb. 15, 2022
 @author: Desmond Blake 101073534

 **/

@Entity
@Table(name ="buddies")
public class Buddy {
    @Id //Indicates that it maps to the primary value in the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Values of ID column are generated automatically by database
    private Integer id;

    @Column(nullable = false, name = "buddy_firstName")
    private String firstName;

    @Column(nullable = false, name = "buddy_lastName")
    private String lastName;

    @Column(nullable = false)
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Buddy [ id = " + id +
                ", firstName= " + firstName +
                ", lastName = " + lastName +
                ", phone Number= " + phoneNumber;
    }
}
