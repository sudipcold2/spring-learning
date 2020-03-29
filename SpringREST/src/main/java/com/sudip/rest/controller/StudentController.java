package com.sudip.rest.controller;

import com.sudip.rest.entity.Student;
import com.sudip.rest.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentController {

    private Map<Integer, Student> studentList;

    @PostConstruct
    public void loadData(){
        Student s1 = new Student(1,"Sudip", "Ghosh");
        Student s2 = new Student(2, "Binayak", " Ghosh");

        studentList = new HashMap<>();
        studentList.put(s1.getId(), s1);
        studentList.put(s2.getId(), s2);
    }

    @GetMapping("/students")
    public List<Student> allStudents(){
        List<Student> list = new ArrayList<>();
        for(Student s : studentList.values()){
            list.add(s);
        }

        return list;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        Student student = studentList.get(studentId);

        if(student == null){
            throw new StudentNotFoundException("student id not found -" + studentId);
        }

        return student;
    }

}
