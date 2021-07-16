package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Class;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname ClassMapper
 * @Description TODO
 * @Date 2021/7/6 14:38
 * @Created by ZhangChen
 */
@Mapper
public interface ClassMapper extends BaseMapper<Class> {
    List<Class> selectByResultMap();

}
