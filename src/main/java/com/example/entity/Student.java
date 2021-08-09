package com.example.entity;

import com.example.request.CreateStudentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Transient  // Compiler zanemaruje u tablici tu oznaku, ali nam može služiti za nešto drugo dalje
    private String fullName;

    @OneToOne
    @JoinColumn(name = "id")
    private Address address;

    @OneToMany(mappedBy = "student")
    private List<Subject> learningSubjects;

    public Student(CreateStudentRequest createStudentRequest) {
        this.firstName = createStudentRequest.getFirstName();
        this.lastName = createStudentRequest.getLastName();
        this.email = createStudentRequest.getEmail();
        this.fullName = createStudentRequest.getFirstName() + " " + createStudentRequest.getLastName();
    }
}
