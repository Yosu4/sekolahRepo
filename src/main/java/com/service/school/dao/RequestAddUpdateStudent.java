package com.service.school.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class RequestAddUpdateStudent {
    private String firstName;
    private String lastName;
    private String classId;
    private String address;
    private Integer age;
    private Integer enrollmentYear;
    private Date birthDate;
    private String contactNumber;
}
