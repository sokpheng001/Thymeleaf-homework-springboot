package com.example.webapp.model;

import com.example.webapp.service.CategoryService;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @NotBlank(message = "Title is required.")
    private String title;
    @NotBlank(message = "Author is required.")
    private String author;
    @NotBlank(message = "Description is required")
    private String description;
    //
    private List<Category> categoryList;

    //
//    @NotBlank(message = "Filed is required.")
    private String thumbnail;
}
