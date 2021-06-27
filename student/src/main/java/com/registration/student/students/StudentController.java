package com.registration.student.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path= "api/v1/student")
    public List<Students> getStudent() {
        return studentService.getStduentsDetail();
    }

    @PostMapping(path = "api/v1/student")
    public void addNewStudent(@RequestBody Students student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "api/v1/student/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "api/v1/upstudent/{studentId")
    public Students updateStudent(@RequestParam(required = false) String email,
                                  @RequestParam(required = false) String  name,
                                  @PathVariable("studentId") Long id) {

        return studentService.updateStudent(id, email, name);
    }
}
