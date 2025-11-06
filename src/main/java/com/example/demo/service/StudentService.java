package com.example.demo.service;

import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
       this.modelMapper = modelMapper;
    }

    public StudentResponseDTO saveStudent( StudentRequestDTO studentRequestDTO) {
        // Convert DTO → Entity
        Student student = modelMapper.map(studentRequestDTO, Student.class);

        // Save entity to DB
        Student saved = studentRepository.save(student);

        // Convert Entity → Response DTO
        return modelMapper.map(saved, StudentResponseDTO.class);
    }

    public Page<StudentResponseDTO> getAllStudents (int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> students = studentRepository.findAll(pageable);
      return students.map(student -> modelMapper.map(student, StudentResponseDTO.class));
    }

    public StudentResponseDTO getStudentById( Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id : " + id));
        return modelMapper.map(student, StudentResponseDTO.class);
    }

    public void deleteByID(Long id){
        studentRepository.deleteById(id);
    }
}
