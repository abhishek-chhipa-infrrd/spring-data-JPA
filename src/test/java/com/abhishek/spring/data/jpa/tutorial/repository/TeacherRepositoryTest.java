package com.abhishek.spring.data.jpa.tutorial.repository;

import com.abhishek.spring.data.jpa.tutorial.entity.Course;
import com.abhishek.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(2)
                .build();
        Course courseJava = Course.builder()
                .title("java")
                .credit(5)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("NK")
                .firstName("kishore")
//                .courses(List.of(courseJava,courseDBA))
                .build();

        teacherRepository.save(teacher);
    }

}