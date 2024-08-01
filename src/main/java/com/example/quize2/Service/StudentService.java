package com.example.quize2.Service;

import com.example.quize2.Model.Student;
import com.example.quize2.Model.Teeacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }
    public void addStudent(Student student) {
        students.add(student);

    }
    public boolean updateStudent(int id, Student student) {
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }
    public boolean deleteStudent(int id) {
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    public Student getStudentByname(String name) {
        for(int i=0;i<students.size();i++){
            if(students.get(i).getName().equals(name)){
                return students.get(i);

            }
        }
        return null;
    }
    public ArrayList<Student> getStudentByMajor(String major) {
        for(int i=0;i<students.size();i++){
            if(students.get(i).getMajor().equalsIgnoreCase(major)){
                return students;


            }
        }
        return null;
    }
}
