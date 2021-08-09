package com.example.response;

import com.example.entity.Student;
import com.example.entity.Subject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/student/")

public class StudentResponse {
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    private String lastName;
    private String email;
    private String fullName;
    private String street;
    private String city;

    private List<SubjectResponse> learningSubjects;

    public StudentResponse (Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.fullName = student.getFirstName() + " " + student.getLastName();
        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();

        if (student.getLearningSubjects() != null) {
            learningSubjects = new ArrayList<>();
            for (Subject subject : student.getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }
        }
    }
}
