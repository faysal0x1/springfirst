package org.example.springfirst.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springfirst.Dto.StudentDto;
import org.example.springfirst.entity.Student;
import org.example.springfirst.repository.StudentRepository;
import org.example.springfirst.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not Found not with this id"));
        return modelMapper.map(student, StudentDto.class);
    }

}
