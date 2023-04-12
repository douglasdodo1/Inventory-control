package com.inventorycontrol.inventorycontrol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventoryControllController {
    
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
