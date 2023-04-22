package com.example.webapp.controller;

import com.example.webapp.model.Blog;
import com.example.webapp.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ViewEachAuthor {
    private final BlogService blogService;
    @GetMapping("/each/author/{author_name}")
    String eachAuthor(@PathVariable("author_name") String nameName, Model model){
        List<Blog> blogList = blogService.findAll().stream().filter(e->e.getAuthor().equals(nameName)).toList();
        System.out.println("Author:" + blogList);
        //
        model.addAttribute("author",blogList);
        model.addAttribute("category",blogList.get(0).getCategoryList().get(0));
        System.out.println(blogList.get(0));
        return "pages/view-each-author";
    }
}
