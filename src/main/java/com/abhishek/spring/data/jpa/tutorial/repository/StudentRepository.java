package com.abhishek.spring.data.jpa.tutorial.repository;

import com.abhishek.spring.data.jpa.tutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByGuardianName(String guardianName);


    //    JPQL
    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmail(String emailId);


    //    NATIVE QUERY
    @Query(
            value = "SELECT * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    public Student getStudentByEmailNative(String emailId);


    //    NATIVE named param QUERY
    @Query(
            value = "SELECT * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    public Student getStudentByEmailNativeNamedParam(
            @Param("emailId") String emailId
    );


//    modifying data in db using @Modify
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    public int updateStudentNameByEmailId(String firstName, String emailId);

}
