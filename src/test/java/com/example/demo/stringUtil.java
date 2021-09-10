package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author ZhangChen
 * @classname stringUtil
 * @description TODO
 * @date 2021/8/23 11:27
 */
@SuppressWarnings("unused")
public class stringUtil {
    public static List<String> string2Json(String s) {
        Pattern p = Pattern.compile("(\\{.+?})+?");
        Matcher m = p.matcher(s);
        List<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group());
        }
        return list;
    }

    public static List<String> string2Json2(String s) {
        return Arrays.stream(s.split("}"))
                .map(str -> str + "}")
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String s = "{\"id\":1,\"name\":\"Tom\",\"age\":19}{\"id\":2,\"name\":\"Tom2\",\"age\":17}{\"id\":3,\"name\":\"Tom3\",\"age\":11}";
        string2Json2(s).forEach(System.out::println);
        // string2Json(s).forEach(System.out::println);

    }

}
