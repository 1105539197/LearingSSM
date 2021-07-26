package com.example.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId
    private String studentId;
    @Excel(name = "学生姓名")
    private String studentName;
    @Excel(name = "班级ID")
    private String classId;
}
