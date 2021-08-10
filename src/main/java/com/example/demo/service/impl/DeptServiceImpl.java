package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Dept;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.service.DeptService;
import com.example.demo.utils.StringUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Zhang.C
 * @since 2021-08-09
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Override
    public List<Dept> tree() {
        List<Dept> list = selectSubList("");
        recurList(list);
        return list;
    }

    private void recurList(List<Dept> list) {
        if (list != null && list.size() > 0) {
            for (Dept dept : list) {
                List<Dept> subList = selectSubList(dept.getDeptId());
                dept.setSubList(subList);
                recurList(subList);
            }
        }
    }

    @Override
    public List<Dept> selectSubList(String id) {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        if (StringUtil.notEmpty(id)) {
            wrapper.eq("length(dept_id)", id.length() + 2);
            wrapper.likeRight("dept_id", id);
        } else {
            wrapper.eq("length(dept_id)", 2);
        }
        return this.list(wrapper);
    }


}
