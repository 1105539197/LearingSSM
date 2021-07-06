package com.example.demo.controller;

import com.example.demo.entity.Class;
import com.example.demo.entity.Student;
import com.example.demo.service.ClassService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Classname ClassController
 * @Description TODO
 * @Date 2021/7/6 16:38
 * @Created by ZhangChen
 */
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private ClassService classService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/listClass")
    public List<Class> listClass(String id) {
        List<Class> classList = classService.selectList(id);
        classList.forEach(c -> {
            String classId = c.getClassId();
            List<Student> students = studentService.selectListByClassId(classId);
            c.setStudents(students);
        });
        return classList;
    }
}
