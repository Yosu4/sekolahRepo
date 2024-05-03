package com.service.school.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RequestUpdateStudent {
    private Long id;
    private String classId;
    private String address;
    private Integer age;
    private String contactNumber;
}
