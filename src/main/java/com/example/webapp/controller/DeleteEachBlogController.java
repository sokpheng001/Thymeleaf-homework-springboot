package com.example.webapp.controller;

import com.example.webapp.model.Blog;
import com.example.webapp.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DeleteEachBlogController {
    private final BlogService blogService;
    @GetMapping("/deleted/{description}")
    String delete(@PathVariable("description") String description){
        List<Blog> blogList = blogService.findAll().stream().filter(e->e.getDescription().equals(description)).toList();
        System.out.println(blogList);
        if(blogService.findAll().size()==1){
//            return "pages/blog";
//            blogs.findAll().remove(blogList);
            return "redirect:/all/blog";
        }else {
            blogService.findAll().remove(blogList.get(0));
            System.out.println("Deleted card: " + blogList);
        }
        return "redirect:/all/blog";
    }
}
