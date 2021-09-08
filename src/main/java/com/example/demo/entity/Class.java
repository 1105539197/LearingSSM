package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author MyBatisPlusGenerator
 * @since 2021-07-06
 */
@Data
@TableName("t_class")
public class Class {

    private String classId;

    private String className;

    private String teacherName;

    @TableField(exist = false)
    private List<Student> students;

    private Date time;

}
