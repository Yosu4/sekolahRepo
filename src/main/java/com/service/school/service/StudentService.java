package com.service.school.service;

import com.service.school.dao.RequestAddUpdateStudent;
import com.service.school.dao.RequestDeactiveStudent;
import com.service.school.dao.RequestUpdateStudent;
import com.service.school.exception.NoStudentFound;
import com.service.school.model.Student;
import com.service.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(RequestAddUpdateStudent student){
        Student newStudent = Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .enrollmentYear(student.getEnrollmentYear())
                .address(student.getAddress())
                .age(student.getAge())
                .classId(student.getClassId())
                .birthDate(student.getBirthDate())
                .isActive(true)
                .enrollmentYear(0)
                .contactNumber(student.getContactNumber())
                .build();

        studentRepository.save(newStudent);
    }

    public List<Student> getAllStudents() {
        List<Student> list = studentRepository.findActiveStudents();
        list.sort(Comparator.comparing(Student::getId));
        return list;
    }

    public List<Student> getAllDeactiveStudents() {
        List<Student> list = studentRepository.findDeactiveStudents();
        list.sort(Comparator.comparing(Student::getId));
        return list;
    }

    public List<Student> getStudentsByClassId(String classId) {
        List<Student> list = studentRepository.findActiveStudentsByClassId(classId);
        list.sort(Comparator.comparing(Student::getId));
        return list;
    }

    public Student updateStudent(RequestUpdateStudent student) throws NoStudentFound {
        Optional<Student> studentDetail = studentRepository.findById(student.getId());
        if(studentDetail.isEmpty()){
            throw new NoStudentFound("Student ID :" +student.getId() + " is not found");
        }

        Student updatedStudent = studentDetail.get();
        updatedStudent.setAddress(student.getAddress());
        updatedStudent.setContactNumber(student.getContactNumber());
        updatedStudent.setAge(student.getAge());
        updatedStudent.setClassId(student.getClassId());

        return studentRepository.save(updatedStudent);
    }

    public void deactivateStudent(RequestDeactiveStudent student) throws NoStudentFound {
        Optional<Student> studentDetail = studentRepository.findById(student.getId());
        if(studentDetail.isEmpty()){
            throw new NoStudentFound("Student ID :" +student.getId() + " is not found");
        }

        Student updatedStudent = studentDetail.get();
        updatedStudent.setIsActive(student.getIsActive());
        updatedStudent.setGraduate_year(student.getGraduate_year());

        studentRepository.save(updatedStudent);
    }
}
