package com.example.demo.controller;

import com.example.demo.entity.Class;
import com.example.demo.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname ClassController
 * @Description TODO
 * @Date 2021/7/6 16:38
 * @Created by ZhangChen
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class ListController {
    @Autowired
    private ClassService classService;

    @GetMapping("/listClass")
    public List<Class> listClass(String id) {
        return classService.selectList(id);
    }
}
