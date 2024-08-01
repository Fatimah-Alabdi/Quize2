package com.example.quize2.Controllder;

import com.example.quize2.Api.ApiRespinse;
import com.example.quize2.Model.Student;
import com.example.quize2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
@GetMapping("/get")
    public ResponseEntity getAllStudents() {
        ArrayList<Student> students = studentService.getStudents();
        return ResponseEntity.status(200).body(students);

    }
    @PostMapping("/add")
    public ResponseEntity addSudent(@Valid @RequestBody Student student, Errors errors) {
    if(errors.hasErrors()) {
        String msg=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(msg);
    }
    studentService.addStudent(student);
    return ResponseEntity.status(200).body(new ApiRespinse("Student Added Successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @Valid@RequestBody Student student,Errors errors) {
    if(errors.hasErrors()) {
        String msg=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(msg);
    }
    boolean isupdated=studentService.updateStudent(id, student);
    if(isupdated) {
        return ResponseEntity.status(200).body(new ApiRespinse("Student Updated Successfully"));
    }
    return ResponseEntity.status(400).body(new ApiRespinse("Student Not Updated"));
    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
     boolean isdeleted=studentService.deleteStudent(id);
     if(isdeleted) {
         return ResponseEntity.status(200).body(new ApiRespinse("Student Deleted Successfully"));
     }
     return ResponseEntity.status(400).body(new ApiRespinse("Student Not Deleted"));
    }
    @GetMapping("/studentbyname/{name}")
    public ResponseEntity getStudentByName(@PathVariable String name) {
    Student student=studentService.getStudentByname(name);
    if(student==null) {
        return ResponseEntity.status(400).body( new ApiRespinse("Student not Found"));

    }
    return ResponseEntity.status(200).body(student);

    }
    @GetMapping("/getbymajor/{major}")
    public ResponseEntity getStudentBymajor(@PathVariable String major) {
     ArrayList<Student> sstudent=studentService.getStudentByMajor(major);
     if(sstudent==null) {
         return ResponseEntity.status(400).body( new ApiRespinse("Student not Found"));
     }
     return ResponseEntity.status(200).body(sstudent);
    }
}
