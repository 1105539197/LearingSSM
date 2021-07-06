package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname StudentMapper
 * @Description TODO
 * @Date 2021/7/6 15:24
 * @Created by ZhangChen
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
