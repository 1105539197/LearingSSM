package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import com.example.demo.utils.StringUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname StudentServiceImpl
 * @Description TODO
 * @Date 2021/7/6 15:43
 * @Created by ZhangChen
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Override
    public List<Student> selectListByClassId(String classId) {
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq(StringUtil.notEmpty(classId), "class_id", classId);
        return list(studentQueryWrapper);
    }
}
