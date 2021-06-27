package com.registration.student.students;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Students> getStduentsDetail() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Students student) {
        Optional<Students> studentsOptional = studentRepository.findStudentsByEmail(student.getEmail());
        if(studentsOptional.isPresent()) {
            throw new IllegalStateException("email alrady exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.findById(studentId).isPresent();
        if(exists) {
            studentRepository.deleteById(studentId);
        }
    }

    @Transactional
    public Students updateStudent(Long id, String email, String name) {
        Students student =  studentRepository.findById(id).orElse(null);

        if (name != null && name.length() > 0) {
            student.setName(name);
        }

        if (email !=null && email.length() > 0) {
            student.setEmail(email);
        }

        return  student;
    }
}
