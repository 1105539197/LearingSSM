package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;

/**
 * @author ZhangChen
 * @classname MonthArray
 * @description TODO
 * @date 2021/9/1 16:22
 */

public class MonthArray {
    @Test
    public void testMonthArray(){
        String[] latest12MonthDesc = getLatest12MonthDesc();
        System.out.println(Arrays.toString(latest12MonthDesc));
    }
    public static String[] getLatest12MonthDesc() {
        String[] latest12Months = new String[12];
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1); //要先+1,才能把本月的算进去
        for (int i = 11; i >=0; i--) {
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); //逐次往前推1个月
            latest12Months[11 - i] = cal.get(Calendar.YEAR) + "-" + fillZero(cal.get(Calendar.MONTH) + 1);
        }
        return latest12Months;
    }

    private static String fillZero(int i) {
        String month = "";
        if (i < 10) {
            month = "0" + i;
        } else {
            month = String.valueOf(i);
        }
        return month;
    }
}
