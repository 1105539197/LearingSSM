package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.demo.entity.Class;
import com.example.demo.entity.Dept;
import com.example.demo.entity.Student;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.ClassService;
import com.example.demo.service.DeptService;
import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;

/**
 * @Classname SampleTest
 * @Description TODO
 * @Date 2021/7/6 14:37
 * @Created by ZhangChen
 */

@SpringBootTest
public class SampleTest {

    @Autowired
    private ClassService classService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private DeptService deptService;
    @Test
    public void testClassListWithStu() {
        classService.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testResultMap() {
        List<Class> classList = classService.selectByResultMap();
        classList.forEach(System.out::println);
    }

    @Test
    public void testLambdaChain() {
        List<Class> classList = classService.selectList(null);
        classList.forEach(c -> c.setStudents(
                new LambdaQueryChainWrapper<>(studentService.getBaseMapper())
                        .eq(Student::getClassId, c.getClassId())
                        .list()
        ));
        System.out.println("========================");
        classList.forEach(System.out::println);
    }

    @Test
    public void sortByDate(){
        List<Class> classList = classService.selectList(null);
        classList.sort(Comparator.comparing(Class::getTime));
        classList.forEach(System.out::println);
    }


    @Test
    public void selectSubList(){
        List<Dept> list = deptService.selectSubList("GS");
        list.forEach(System.out::println);
    }

}
