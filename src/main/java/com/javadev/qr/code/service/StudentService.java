package com.javadev.qr.code.service;

import com.javadev.qr.code.model.Student;
import com.javadev.qr.code.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService (StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getAllStudents() {
    return this.studentRepository.findAll();
  }

  public Student saveStudent(Student student) {
    return this.studentRepository.save(student);
  }

  public Student getStudentById(Long id) {
    return this.studentRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Student not found"));
  }

}
