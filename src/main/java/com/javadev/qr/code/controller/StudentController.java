package com.javadev.qr.code.controller;

import com.google.zxing.WriterException;
import com.javadev.qr.code.model.Student;
import com.javadev.qr.code.service.StudentService;
import com.javadev.qr.code.utils.QRCodeGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public ResponseEntity<List<Student>> getAllStudent() throws IOException, WriterException {
    List<Student> students = this.studentService.getAllStudents();

    if(students.size() != 0) {
      for (Student student : students) {
        QRCodeGenerator.generateQRCode(student);
      }
    }

    return ResponseEntity.ok(this.studentService.getAllStudents());
  }

  @PostMapping
  public Student saveStudent(@RequestBody Student student) {
    return this.studentService.saveStudent(student);
  }

  @GetMapping("/{id}")
  public Student getStudentById(@PathVariable Long id) {
    return this.studentService.getStudentById(id);
  }

}
