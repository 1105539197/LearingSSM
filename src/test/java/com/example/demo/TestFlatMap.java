package com.example.demo;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo.entity.Student;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ZhangChen
 * @classname TestFlatMap
 * @description TODO
 * @date 2021/9/2 15:33
 */

public class TestFlatMap {

    @Test
    public void merge() {
        List<Integer[]> integers = Arrays.asList(new Integer[]{1, 2, 3, 4}, new Integer[]{5, 6, 7});
        integers.forEach(System.out::println);
        List<Object> collect = integers.stream().flatMap(Arrays::stream).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


    @Test
    public void merge2() {
        List<Object> list = Arrays.asList(
                Arrays.asList("the", "quick", "brown", "fox"),
                new String[]{"jumps", "over"},
                "a", "lazy", "dog"
        );
        // list.stream()
        //         .flatMap(t->{
        //             if(t instanceof String){
        //                 return Stream.of(t);
        //             } else if (t instanceof List) {
        //                 return ((List<?>)t).stream();
        //             }else if (t instanceof String[]){
        //                 return Arrays.stream((String[]) t);
        //             }
        //             return null;
        //         })
        //         .forEach(System.out::println);

    }




}
