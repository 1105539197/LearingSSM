package com.example.demo.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Class;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.service.ClassService;
import com.example.demo.utils.StringUtil;
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
    @Override
    public List<Class> selectList(String classId) {
        QueryWrapper<Class> classQueryWrapper = new QueryWrapper<>();
        classQueryWrapper.eq(StringUtil.notEmpty(classId), "class_id", classId);
        return baseMapper.selectList(classQueryWrapper);
    }
}
