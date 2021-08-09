package com.example.demo.service;

import com.example.demo.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Zhang.C
 * @since 2021-08-09
 */
public interface DeptService extends IService<Dept> {
    List<Dept> tree();
    List<Dept> selectSubList(String id);
}
