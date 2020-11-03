package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Team;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService {
    //TODO GTB-工程实践: + StudentService.java:14 有抽取Magic number的意识
    private static final int TEAM_NUM = 6;

    //TODO GTB-知识点: + StudentService.java:17 使用了构造器注入
    final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    public void addStudent(String name) {
        studentRepository.addStudent(name);
    }

    //TODO GTB-工程实践: - StudentService.java:30 长方法，需要按模块抽取方法进行重构
    public List<Team> getTeams() {
        List<Student> studentList = studentRepository.findAll();
        List<Student> sortedStudent = new ArrayList<>(studentList);
        Collections.shuffle(sortedStudent);
        List<Team> teams = new ArrayList<>();
        int startIndex = 0;
        int amountInEveryTeam = studentList.size() / TEAM_NUM;
        int remain = studentList.size() % TEAM_NUM;
        for (int i = 0; i < TEAM_NUM; i++) {
            if (remain > 0) {
                teams.add(new Team(String.format("%d组",i + 1), sortedStudent.subList(startIndex, startIndex + amountInEveryTeam + 1)));
                remain--;
                startIndex = startIndex + amountInEveryTeam + 1;
            } else {
                teams.add(new Team(String.format("%d组", i + 1), sortedStudent.subList(startIndex, startIndex + amountInEveryTeam)));
                startIndex = startIndex + amountInEveryTeam;
            }
        }
        return teams;
    }
}
