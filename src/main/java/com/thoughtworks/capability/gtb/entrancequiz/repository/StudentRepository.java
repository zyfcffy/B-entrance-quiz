package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private static final String[] originList= {"成吉思汗","鲁班七号","太乙真人","钟无艳",
            "花木兰","雅典娜","芈月","白起","刘禅","庄周","马超","刘备","哪吒","大乔","蔡文姬"};

    private static List<Student> studentList = new ArrayList<>();

    static {
        for (int i = 0;i<originList.length;i++){
            studentList.add(new Student(i+1,originList[i]));
        }
    }

    public List<Student> findAll(){
        return studentList;
    }
}
