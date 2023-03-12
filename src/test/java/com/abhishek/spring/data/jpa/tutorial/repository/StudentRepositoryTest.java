package com.abhishek.spring.data.jpa.tutorial.repository;

import com.abhishek.spring.data.jpa.tutorial.entity.Guardian;
import com.abhishek.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    /*@Test
    public void saveStudent() {

        Student student = Student.builder()
                .emailId("abhishek@gmail.com")
                .firstName("Abhi")
                .lastName("chhipa")
//                .guardianName("Nidhi")
//                .guardianEmail("nidhi@gmail.com")
//                .guardianMobile("7014599580")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        var guardian = Guardian.builder()
                .name("maa")
                .email("maa@gmail.com")
                .mobile("8889990008")
                .build();

        var student = Student.builder()
                .firstName("Ashu")
                .emailId("ashu@gmial.com")
                .lastName("chhipa")
                .guardian(guardian)  //this will take a whole guardian obj so make one first and put it here
                .build();

        studentRepository.save(student);
    }
*/
    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {

        List<Student> listOfStudents = studentRepository.findByFirstName("Abhi");
        System.out.println("listOfStudents = " + listOfStudents);

    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> listOfStudents = studentRepository.findByFirstNameContaining("hi");
        System.out.println("listOfStudents = " + listOfStudents);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> listOfStudents = studentRepository.findByGuardianName("maa");
        System.out.println("listOfStudents = " + listOfStudents);
    }

    @Test
    public void printGetStudentByEmailNative(){
        Student student = studentRepository.getStudentByEmailNative("abhishek@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailNativeNamedParam("abhishek@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmail(){
        Student student = studentRepository.getStudentByEmail("abhishek@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void printUpdateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("chinu","abhishek@gmail.com");
    }

}