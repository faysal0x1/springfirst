package org.example.springfirst.controller;

import org.example.springfirst.Dto.StudentDto;
import org.example.springfirst.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

}
