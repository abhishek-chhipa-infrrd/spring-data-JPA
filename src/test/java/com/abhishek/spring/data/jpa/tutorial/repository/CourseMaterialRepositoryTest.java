package com.abhishek.spring.data.jpa.tutorial.repository;

import com.abhishek.spring.data.jpa.tutorial.entity.Course;
import com.abhishek.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CourseMaterialRepositoryTest {


    @Autowired
    private CourseMaterialRepository repository;


    @Test
    public void saveCourseMaterial(){


        Course course = Course.builder()
                .title("CSS")
                .credit(3)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.helloworld.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

}