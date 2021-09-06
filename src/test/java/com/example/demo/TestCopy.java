package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangChen
 * @classname TestCopy
 * @description TODO
 * @date 2021/9/6 8:34
 */

public class TestCopy {

    @Data
    @NoArgsConstructor
    private static class OS implements Cloneable {
        String name;

        public OS(String name) {
            this.name = name;
        }
    }

    @Data
    @NoArgsConstructor
    private static class Phone implements Cloneable {
        String brand;
        OS OS;

        Phone(String brand, String screen) {
            this.brand = brand;
            this.OS = new OS(screen);
        }

        @Override
        public Phone clone() {
            Phone clone = null;
            try {
                clone = (Phone) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return clone;
        }
    }

    @Data
    @NoArgsConstructor
    private static class Student implements Cloneable {
        String name;
        Integer age;
        Phone phone;

        Student(String name, Integer age, String phone, String screen) {
            this.name = name;
            this.age = age;
            this.phone = new Phone(phone, screen);
        }

        @Override
        public Student clone() {
            Student clone = null;
            try {
                clone = (Student) super.clone();
                clone.phone = this.phone.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return clone;
        }
    }

    @Test
    public void testRefCopy() {
        Student s1 = new Student("Tom", 18, "SamSung", "Android");
        Student s2;
        s2 = s1;
        System.out.println(s1 == s2);
        System.out.println(s1.phone == s2.phone);
        System.out.println(s1.phone.OS == s2.phone.OS);

    }

    @Test
    public void testShadowClone() {
        Student s1 = new Student("Tom", 18, "SamSung", "Android");
        Student s2 = s1.clone();
        System.out.println(s1 == s2);
        System.out.println(s1.phone == s2.phone);
        System.out.println(s1.name == s2.name);
        System.out.println(s1.phone.OS == s2.phone.OS);
    }

    @Test
    public void testDeepClone() throws JsonProcessingException {
        Student s1 = new Student("Tom", 18, "SamSung", "Android");

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(s1);
        Student s2 = mapper.readValue(jsonStr, Student.class);

        System.out.println(s1 == s2);
        System.out.println(s1.phone == s2.phone);
        System.out.println(s1.name == s2.name);
        System.out.println(s1.phone.OS == s2.phone.OS);

    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Foo{
        String bar;
    }
    @Test
    public void testCloneList() throws JsonProcessingException {
        List<Foo> list1 = Arrays.asList(new Foo("1"), new Foo("2"), new Foo("3"));
        System.out.println(list1);

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(list1);
        System.out.println(jsonStr);
        List<Foo> list3 = mapper.readValue(jsonStr,
                mapper.getTypeFactory().constructParametricType(List.class, Foo.class));
        System.out.println(list3);

    }

}
