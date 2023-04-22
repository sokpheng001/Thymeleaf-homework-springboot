package com.example.webapp.repository;


import com.example.webapp.model.Blog;
import com.example.webapp.model.Category;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@RequiredArgsConstructor
public class DataRepository {
    private final Faker faker;
    private final CategoryData categoryData;
    Blog blog;
    private final List<Blog> blogs = new ArrayList<>();

    @PostConstruct
    public List<Blog> init() {
        blogs.add(new Blog(faker.book().genre().replace('/',' '), faker.book().author(), faker.book().title(), categoryData.category(),"a1.jpg"));
        blogs.add(new Blog(faker.book().genre().replace('/',' '), faker.book().author(), faker.book().title(), categoryData.category(),"a2.jpg"));
        blogs.add(new Blog(faker.book().genre().replace('/',' '), faker.book().author(), faker.book().title(), categoryData.category(),"a3.png"));
        blogs.add(new Blog(faker.book().genre().replace('/',' '), faker.book().author(), faker.book().title(), categoryData.category(),"a4.jpg"));
//        for (int i = 0; i < 4; i++) {
//            if (i % 2 == 0) {
//                blogs.add(new Blog(faker.book().genre(), faker.book().author(), faker.book().title(),categoryData.category() ,"pic1.jpg"));
//            }
//        }
        return blogs;
    }
}
