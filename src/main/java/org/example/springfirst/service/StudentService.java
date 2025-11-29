package org.example.springfirst.service;

import org.example.springfirst.Dto.AddStudentRequestDto;
import org.example.springfirst.Dto.StudentDto;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

     StudentDto createStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    @Nullable StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);
}
