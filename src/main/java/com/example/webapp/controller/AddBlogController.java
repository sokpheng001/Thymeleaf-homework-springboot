package com.example.webapp.controller;
import com.example.webapp.model.Blog;
import com.example.webapp.model.Category;
import com.example.webapp.repository.CategoryData;
import com.example.webapp.repository.DataRepository;
import com.example.webapp.service.BlogService;
import com.example.webapp.service.CategoryService;
import com.example.webapp.service.CategoryServiceImp;
import com.example.webapp.service.FileUploadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AddBlogController {
    private final FileUploadService fileUpload;
    private final BlogService blogs;
    private final DataRepository dataRepository;
    private final CategoryService categoryService;
    private final CategoryData categoryData;
//    private int i=0;
    private Blog blog;

    @Bean("categoryBean1")
    public void setBeanForCategory(){
        blog = new Blog();
        blog.setCategoryList(categoryData.category());
    }
    @GetMapping("/add")
    public String add(Model model, Blog blog,Category category){
        List<Blog> blogs1 = blogs.findAll();
        model.addAttribute("blog1",blogs1);
        model.addAttribute("categories",categoryService.categoryData());
        //
        model.addAttribute("blog",blog);
        model.addAttribute("addCategory",category);
        return "pages/addBlogForm";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute("blog") @Valid Blog blog,
                          BindingResult error,
                          @RequestParam("file") MultipartFile multipartFile, @ModelAttribute Category category,
                          Model model) throws IOException {
        if(error.hasErrors() || multipartFile.isEmpty()){
            model.addAttribute("blog",blog);
            return "pages/addBlogForm";
        }
        blogs.save(blog,multipartFile);
        blog.setCategoryList(categoryService.categoryData());
        fileUpload.uploadSingle(multipartFile);
        System.out.println(blog.getCategoryList());
        System.out.println(category);
        return "redirect:/add";
    }
}
