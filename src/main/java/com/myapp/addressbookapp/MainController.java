package com.myapp.addressbookapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("")
    public @ResponseBody String displayAddressBook(){
        return "buddies";

    }
}
