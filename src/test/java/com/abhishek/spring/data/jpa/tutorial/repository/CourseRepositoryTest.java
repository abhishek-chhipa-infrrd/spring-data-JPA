package com.abhishek.spring.data.jpa.tutorial.repository;

import com.abhishek.spring.data.jpa.tutorial.entity.Course;
import com.abhishek.spring.data.jpa.tutorial.entity.CourseMaterial;
import com.abhishek.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher
                .builder()
                .firstName("Madhu")
                .lastName("Soni")
                .build();
        /*CourseMaterial courseMaterial = CourseMaterial
                .builder()

                .build();*/

        Course course = Course.builder()
                .title("Controller")
                .credit(4)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}