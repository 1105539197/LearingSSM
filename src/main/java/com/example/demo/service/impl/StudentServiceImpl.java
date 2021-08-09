package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @Classname StudentServiceImpl
 * @Description TODO
 * @Date 2021/7/6 15:43
 * @Created by ZhangChen
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
