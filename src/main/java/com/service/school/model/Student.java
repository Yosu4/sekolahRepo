package com.service.school.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "class_id")
    private String classId;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private Integer age;

    @Column(name = "enrollment_year")
    private Integer enrollmentYear;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "graduateYear")
    private Integer graduate_year;

    @Column(name = "contact_number")
    private String contactNumber;
}
