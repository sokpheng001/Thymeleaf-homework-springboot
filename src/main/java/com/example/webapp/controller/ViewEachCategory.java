package com.example.webapp.controller;

import com.example.webapp.service.BlogService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
@RequiredArgsConstructor
public class ViewEachCategory {
    private final BlogService blogService;
    @GetMapping("/each/category")
    public String eachCategory(Model model){
        Random random =new Random();
        int size = random.nextInt(blogService.findAll().size());
//        model.addAttribute("id",id);
        model.addAttribute("size",size);
        model.addAttribute("data",blogService.findAll());
        model.addAttribute("category",blogService.findAll().get(0).getCategoryList().get(0).getCategory());
        return "pages/view-each-category";
    }
}
