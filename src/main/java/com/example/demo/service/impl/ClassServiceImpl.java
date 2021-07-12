package com.example.demo.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Class;
import com.example.demo.entity.Student;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.service.ClassService;
import com.example.demo.service.StudentService;
import com.example.demo.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ClassServiceImpl
 * @Description TODO
 * @Date 2021/7/6 15:53
 * @Created by ZhangChen
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {
    @Autowired
    private StudentService studentService;

    @Override
    public List<Class> selectList(String classId) {
        QueryWrapper<Class> classQueryWrapper = new QueryWrapper<>();
        classQueryWrapper.eq(StringUtil.notEmpty(classId), "class_id", classId);
        List<Class> classList = baseMapper.selectList(classQueryWrapper);
        classList.forEach(c -> {
            String stuClassId = c.getClassId();
            List<Student> students = studentService.selectListByClassId(stuClassId);
            c.setStudents(students);
        });
        return classList;
    }

    @Override
    public List<Class> selectByResultMap() {
        return baseMapper.selectByResultMap();
    }
}
