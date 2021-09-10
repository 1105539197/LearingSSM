package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author ZhangChen
 * @classname TestSplit
 * @description TODO
 * @date 2021/9/10 10:07
 */

public class TestSplit {
    @Test
    public void test1() {
        String s1 = "1,2,3,4,,,";
        String s2 = "1,2,3,,,4";
        String collect1 = Arrays.stream(s1.split(",")).filter(Objects::nonNull).collect(Collectors.joining("-"));
        String collect2 = Arrays.stream(s1.split(",")).filter(Objects::nonNull).reduce((x,y)->x+"-"+y).get();

        System.out.println(collect1);
        System.out.println(collect2);

    }

}
