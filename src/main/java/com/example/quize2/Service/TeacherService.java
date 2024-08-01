package com.example.quize2.Service;

import com.example.quize2.Model.Teeacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teeacher> teachers = new ArrayList<>();
    public ArrayList<Teeacher> getTeachers() {
        return teachers;
    }
    public void addTeacher(Teeacher teacher){
        teachers.add(teacher);

    }
    public boolean updateTeacher(int id,Teeacher teacher){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }
    public boolean deleteTeacher(int id){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }
    public Teeacher getTeacherById(int id){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                return teachers.get(i);

            }
        }
        return null;
    }
    public ArrayList<Teeacher>getteacherBySalary(int salary){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getSalary()>=salary){
                return teachers;


            }
        }
        return null;

    }
}
