package org.example.springfirst.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springfirst.Dto.AddStudentRequestDto;
import org.example.springfirst.Dto.StudentDto;
import org.example.springfirst.entity.Student;
import org.example.springfirst.repository.StudentRepository;
import org.example.springfirst.service.StudentService;
import org.jspecify.annotations.Nullable;
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

    @Override
    public StudentDto createStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student Not Found not with this id");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public @Nullable StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not Found not with this id"));

        modelMapper.map(addStudentRequestDto, student);

        studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

}
