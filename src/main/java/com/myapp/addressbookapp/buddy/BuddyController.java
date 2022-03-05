package com.myapp.addressbookapp.buddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 BuddyController: Controller Class for Buddy
 @date: Feb. 17, 2022
 @author: Desmond Blake 101073534

 **/

@Controller
public class BuddyController {
    @Autowired private BuddyService service;

    @GetMapping("/buddies")
    public String displayBuddyList(Model model) {
        List<Buddy> listBuddies = service.listAll();
        model.addAttribute("listBuddies", listBuddies);

        return "buddies";

    }

    @GetMapping("/buddies/add")
    public String displayForm(Model model){
        model.addAttribute("buddy", new Buddy());
        model.addAttribute("title_page", "Add Buddy");
        return "Buddy_form";
    }

    @PostMapping("/buddies/save")
    public String saveBuddy(Buddy buddy){
        service.save(buddy);

        return "redirect:/buddies";
    }

    @GetMapping("/buddies/delete/{id}")
    public String deleteBuddy(@PathVariable("id") Integer id){
        service.delete(id);
        return "redirect:/buddies";
    }

    @GetMapping("/buddies/edit/{id}")
    public String displayEditForm(@PathVariable("id") Integer id, Model model){
        Buddy buddy = service.get(id);
        model.addAttribute("buddy", buddy);
        model.addAttribute("title_page", "Update Buddy");

        return "Buddy_form";
    }

    @RequestMapping("/greeting")
    public @ResponseBody
    String greeting() {
        return service.greet();
    }
}
