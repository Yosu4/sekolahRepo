package com.service.school.repository;

import com.service.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM student u where u.is_active = true", nativeQuery = true)
    List<Student> findActiveStudents();

    @Query(value = "SELECT * FROM student u where u.is_active = false", nativeQuery = true)
    List<Student> findDeactiveStudents();

    @Query(value = "SELECT * FROM student u where u.class_id = :classId and u.is_active = true", nativeQuery = true)
    List<Student> findActiveStudentsByClassId(@Param("classId") String classId);
}
