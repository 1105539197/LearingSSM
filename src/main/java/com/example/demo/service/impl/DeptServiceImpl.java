package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.demo.entity.Dept;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.utils.StringUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhang.C
 * @since 2021-08-09
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Override
    public List<Dept> tree() {

        return null;
    }

    @Override
    public List<Dept> selectSubList(String id) {
        LambdaQueryWrapper<Dept> wrapper = new LambdaQueryWrapper<>();
        if(StringUtil.notEmpty(id)){
            wrapper.eq(dept -> (dept.getDeptId()).substring(0,dept.getDeptId().length()-2),id)

        }else {
            wrapper.eq(dept -> (dept.getDeptId().length(),2);
        }

                de.list();

    }


}
