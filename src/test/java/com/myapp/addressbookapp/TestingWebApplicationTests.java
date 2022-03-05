package com.myapp.addressbookapp;



import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestingWebApplicationTests {

    @Autowired
    private MainController controller;

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(controller);
    }

}