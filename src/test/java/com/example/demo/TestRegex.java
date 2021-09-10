package com.example.demo;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author ZhangChen
 * @classname TestRegex
 * @description TODO
 * @date 2021/9/9 16:03
 */
@SuppressWarnings("unused")
public class TestRegex {
    @Test
    public void testOr() {
        String s = "1,2.3'4,";
        String reg="[,.']";

        //Single character alternation in RegExp  但是也行
        String reg2=",|\\.|'";

        String reg3="\\D";

        String[] split = s.split(reg3);

        LinkedList<Object> list = Lists.newLinkedList();


        System.out.println(Arrays.toString(split));
    }
}
