package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhang.C
 * @since 2021-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dept")
@ApiModel(value="Dept对象")
public class Dept implements Serializable {

    private String deptId;

    private String deptName;

    @TableField(exist = false)
    private List<Dept> subList;


}
