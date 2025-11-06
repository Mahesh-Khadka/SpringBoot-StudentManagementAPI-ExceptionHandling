package com.example.demo.controller;

import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> save(@RequestBody @Valid StudentRequestDTO studentRequestDTO){
        return ResponseEntity.ok(studentService.saveStudent(studentRequestDTO));
    }

    @GetMapping
    public ResponseEntity<Page<StudentResponseDTO>> getAll(@RequestParam(defaultValue = "0") int page ,
                                                           @RequestParam(defaultValue = "4") int size){
        return ResponseEntity.ok(studentService.getAllStudents(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("/{id}")
    public  void  delete(@PathVariable Long id){
        studentService.deleteByID(id);
    }
}
