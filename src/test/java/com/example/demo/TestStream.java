package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author ZhangChen
 * @classname TestReduce
 * @description TODO
 * @date 2021/9/9 14:32
 */

public class TestStream {
    @Test
    public void testReduce() {
        String[] strings = {"q", "w", "e", "r"};
        Optional<String> reduce = Arrays.stream(strings).reduce((a, b) -> a + "+" + b);
        System.out.println(reduce.get());
    }

    @Test
    public void testParallel() {
        Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.stream(ints).parallel().forEach(System.out::println);
    }

    @Test
    public void testJoinAndReduce() {
        String s1 = "1,2,3,,4,,5";
        // joining只能对字符串用
        String collect1 = Arrays.stream(s1.split(",")).filter(Objects::nonNull).collect(Collectors.joining("-"));
        // reduce对所有类型都能用
        String collect2 = Arrays.stream(s1.split(",")).filter(Objects::nonNull).reduce((x, y) -> x + "-" + y).get();

        System.out.println(collect1);
        System.out.println(collect2);

    }
}
