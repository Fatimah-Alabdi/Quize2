package com.example.quize2.Controllder;

import com.example.quize2.Api.ApiRespinse;
import com.example.quize2.Model.Teeacher;
import com.example.quize2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){
        ArrayList<Teeacher> teeacherslist=teacherService.getTeachers();
        return ResponseEntity.status(200).body(teeacherslist);

    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teeacher teacher, Errors errors){
        if(errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiRespinse("teacher added successfully"));

    }
    @PutMapping("ubdate/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id,@Valid@RequestBody Teeacher teacher, Errors errors){
        if(errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        boolean isupdate=teacherService.updateTeacher(id,teacher);
        if(isupdate){
            return ResponseEntity.status(200).body(new ApiRespinse("teacher updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespinse("teacher not updated "));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        boolean isdelete=teacherService.deleteTeacher(id);
        if(isdelete){
            return ResponseEntity.status(200).body(new ApiRespinse("teacher deleted successfully"));

        }
        return ResponseEntity.status(400).body(new ApiRespinse("teacher not deleted "));
    }
    @GetMapping("/getteacher/{id}")
    public ResponseEntity getTeacherByid(@PathVariable int id){
        Teeacher teacher=teacherService.getTeacherById(id);
        if(teacher==null){
            return ResponseEntity.status(400).body(new ApiRespinse("teacher not found"));
        }
        return ResponseEntity.status(200).body(teacher);
    }
    @GetMapping("/getsalary/{salary}")
    public ResponseEntity getTeacherBySalary(@PathVariable int salary){
        ArrayList<Teeacher> tarraylist=teacherService.getteacherBySalary(salary);
        if(tarraylist==null){
            return ResponseEntity.status(400).body(new ApiRespinse("salary not found"));
        }
        return ResponseEntity.status(200).body(tarraylist);
    }
}
