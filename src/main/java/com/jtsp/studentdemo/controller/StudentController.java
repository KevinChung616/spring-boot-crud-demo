package com.jtsp.studentdemo.controller;

import com.jtsp.studentdemo.service.StudentService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jtsp.studentdemo.entity.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    ResponseEntity<List<Student>> listStudents(@Nullable @RequestParam Integer age) {
        if (Objects.isNull(age)) {
            return ResponseEntity.ok(studentService.listStudents());
        } else {
            return getStudentsByAge(age);
        }

    }

    @GetMapping("/{id}")
    ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    ResponseEntity<List<Student>> getStudentsByAge(@RequestParam Integer age) {
        return ResponseEntity.ok(studentService.listStudents()
                .stream()
                .filter(s -> s.getAge().equals(age))
                .toList());
    }

}
