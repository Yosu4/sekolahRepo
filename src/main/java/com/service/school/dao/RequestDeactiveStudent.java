package com.service.school.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RequestDeactiveStudent {
    private Long id;
    private Boolean isActive;
    private Integer graduate_year;
}
