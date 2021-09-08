package com.example.demo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author ZhangChen
 * @classname TestInitCollection
 * @description TODO
 * @date 2021/8/31 9:54
 */

public class TestInitCollection {
    @Test
    public void test1(){
        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("srg", 1);
            put("sjy", 2);
            put("mg", 3);
        }};
        map.entrySet().forEach(System.out::println);

        List<Integer> list= new ArrayList<Integer>(){{
            add(1);
            add(2);
        }};

        list.forEach(System.out::println);
    }

    @Test
    public void entry(){
        Map.Entry<String, String> entry = new AbstractMap.SimpleEntry<>("key", "value");
        System.out.println(entry);
    }


    @Test
    public void test() throws Exception {
        HashMap m = new HashMap();
        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(m);
        System.out.println(table == null ? 0 : table.length);
    }
}
