package com.service.school.controller;

import com.service.school.dao.RequestAddUpdateStudent;
import com.service.school.dao.RequestDeactiveStudent;
import com.service.school.dao.RequestUpdateStudent;
import com.service.school.dao.ResponseModel;
import com.service.school.model.Student;
import com.service.school.service.StudentService;
import com.service.school.util.ConstantUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.service.school.util.ConstantUtil.FAILED;

@Slf4j
@RestController
public class SchoolController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    private ResponseModel addStudent(@RequestBody RequestAddUpdateStudent body) {
        try{
            studentService.addStudent(body);
            return ResponseModel.builder()
                    .bodyResponse("Student has been added")
                    .status(ConstantUtil.OK)
                    .build();
        } catch (Exception e){
            log.error("Error Add Students. Error Message : " +e.getMessage());
            return ResponseModel.builder()
                    .bodyResponse("Error add student || " + e.getMessage())
                    .status(FAILED)
                    .build();
        }
    }

    @GetMapping("/getAllStudents")
    public ResponseModel getAllStudents(){
        try {
            List<Student> list = studentService.getAllStudents();
            return ResponseModel.builder()
                    .bodyResponse(list)
                    .status(ConstantUtil.OK)
                    .build();
        } catch (Exception e){
            log.error("Error Get Students. Error Message : " +e.getMessage());
            return ResponseModel.builder()
                    .status(FAILED)
                    .bodyResponse(e.getMessage())
                    .build();
        }
    }

    @GetMapping("/getAllDeactiveStudents")
    public ResponseModel getAllDeactiveStudents(){
        try {
            List<Student> list = studentService.getAllDeactiveStudents();
            return ResponseModel.builder()
                    .bodyResponse(list)
                    .status(ConstantUtil.OK)
                    .build();
        } catch (Exception e){
            log.error("Error Get Students. Error Message : " +e.getMessage());
            return ResponseModel.builder()
                    .status(FAILED)
                    .bodyResponse(e.getMessage())
                    .build();
        }
    }

    @PutMapping("/getStudentsByClass/{classId}")
    public ResponseModel getActiveStudentsByClass(@PathVariable("classId") String classId){
        try {
            List<Student> list = studentService.getStudentsByClassId(classId);
            return ResponseModel.builder()
                    .bodyResponse(list)
                    .status(ConstantUtil.OK)
                    .build();
        } catch (Exception e){
            log.error("Error Get Students. Error Message : " +e.getMessage());
            return ResponseModel.builder()
                    .status(FAILED)
                    .bodyResponse(e.getMessage())
                    .build();
        }
    }

    @PostMapping("/updateStudent")
    private ResponseModel updateStudent(@RequestBody RequestUpdateStudent body) {
        try{
            studentService.updateStudent(body);
            return ResponseModel.builder()
                    .bodyResponse("Student has been updated")
                    .status(ConstantUtil.OK)
                    .build();
        } catch (Exception e){
            log.error("Error Update Student with id :"+ body.getId() +" || Error Message : " +e.getMessage());
            return ResponseModel.builder()
                    .bodyResponse("Error update student || " + e.getMessage())
                    .status(FAILED)
                    .build();
        }
    }

    @PostMapping("/deactivateStudent")
    private ResponseModel deactivateStudent(@RequestBody RequestDeactiveStudent body) {
        try{
            studentService.deactivateStudent(body);
            return ResponseModel.builder()
                    .bodyResponse("Student status has been changed")
                    .status(ConstantUtil.OK)
                    .build();
        } catch (Exception e){
            log.error("Error Deactivate Student with id :"+ body.getId() +" || Error Message : " +e.getMessage());
            return ResponseModel.builder()
                    .bodyResponse("Error change status student || " + e.getMessage())
                    .status(FAILED)
                    .build();
        }
    }
}
