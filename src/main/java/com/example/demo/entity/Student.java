package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname Student
 * @Description TODO
 * @Date 2021/7/6 15:21
 * @Created by ZhangChen
 */
@Data
@TableName("t_student")
public class Student {
    private String studentId;
    private String studentName;
    private String classId;
}
