package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Class;

import java.util.List;

/**
 * @Classname ClassService
 * @Description TODO
 * @Date 2021/7/6 15:52
 * @Created by ZhangChen
 */

public interface ClassService extends IService<Class> {
    List<Class> selectList(String classId);
    List<Class> selectByResultMap();
}
