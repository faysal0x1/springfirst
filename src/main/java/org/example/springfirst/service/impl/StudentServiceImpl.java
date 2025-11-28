package org.example.springfirst.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springfirst.Dto.StudentDto;
import org.example.springfirst.entity.Student;
import org.example.springfirst.repository.StudentRepository;
import org.example.springfirst.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail()
                ))
                .toList();
    }

}
