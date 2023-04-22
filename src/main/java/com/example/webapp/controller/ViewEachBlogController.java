package com.example.webapp.controller;
import com.example.webapp.model.Blog;
import com.example.webapp.service.BlogService;
import com.example.webapp.service.GetFile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
public class ViewEachBlogController {
    private final BlogService blogService;
    private final GetFile getFile;
    @GetMapping("/any/blog/{description}")
    public String anyBlog(@PathVariable String description, Model model){
        System.out.println(description);
        List<Blog> blogList = blogService.findAll().stream().filter(e->e.getDescription().equals(description)).toList();
        System.out.println("Filter: " + blogList);
//        model.addAttribute("id",id);
        Random random = new Random();
        int size = random.nextInt(blogService.findAll().size());
        model.addAttribute("size",size);
        model.addAttribute("data",blogList);
        model.addAttribute("category",blogService.findAll().get(0).getCategoryList().get(0).getCategory());

        //getting file from repository;
        return "pages/view-each-blog";
    }
}
