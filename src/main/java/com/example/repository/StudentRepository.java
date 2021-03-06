package com.example.repository;

import com.example.entity.Address;
import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>  {
    List<Student> findByFirstName(String firstname);
    Student findByFirstNameAndLastName(String firstName, String lastName);
    List<Student> findByFirstNameOrLastName (String firstName, String lastName);
    List<Student> findByFirstNameIn(List<String> firstNames);
    List<Student> findByFirstNameContains(String firstName);
    List<Student> findByAddress_City(String city);

}
