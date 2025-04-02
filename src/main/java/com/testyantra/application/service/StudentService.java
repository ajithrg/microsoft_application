package com.testyantra.application.service;


import com.testyantra.application.entity.Student;
import com.testyantra.application.repo.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Transactional
    public Student saveStudent(Student student) {

        return studentRepo.save(student);
    }

    public Student getById(Integer id) {

        return studentRepo.findById(id).get();
    }

    public void updateUserDataById(Integer id, Student student) {

        Student student1 = studentRepo.findById(id).orElseThrow(()-> new RuntimeException("No User found"));
        student1.setName(student.getName());
        studentRepo.save(student1);

    }

    public void deleteById(Integer id) {

        studentRepo.deleteById(id);
    }
}
