package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Team;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //TODO GTB-完成度: - StudentController.java:20 缺少一个专门查看team的接口

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudentList(){
        return studentService.getStudentList();
    }

    //TODO GTB-知识点: - StudentController.java:28 按照restful实践，资源名一般是复数
    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    //TODO GTB-知识点: - StudentController.java:31 最好使用Object接@RequestBody
    public void addStudent(@RequestBody String name){
        studentService.addStudent(name);
    }

    //TODO GTB-工程实践: - StudentController.java:36 team相关的接口，单独抽取一个controller来做，与students不是操作的一个资源
    @GetMapping("/teams")
    @ResponseStatus(HttpStatus.OK)
    public List<Team> getTeams(){
        return studentService.getTeams();
    }
}
