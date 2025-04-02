package com.testyantra.application.controller;


import com.testyantra.application.entity.Student;
import com.testyantra.application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/app")
@RestController
public class StudentController {


    @Autowired
    private  StudentService studentService;
//for saving the data
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){

       Student data =  studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    /**
     * for fetching the based on id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id){

      Student getByStudentId=  studentService.getById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(getByStudentId);
    }

    @PutMapping
    public ResponseEntity<String> updateUserDataById(@RequestParam Integer id, @RequestBody Student student){


        studentService.updateUserDataById(id,student);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Data Updated done");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteById(@RequestParam Integer id) {

        studentService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Data deleted successfully");
    }



}
