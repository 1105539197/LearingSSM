package com.example.demo;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * @author ZhangChen
 * @classname MonthArray
 * @description TODO
 * @date 2021/9/1 16:22
 */
@SuppressWarnings("unused")
public class MonthArray {

    public static String[] getLatest12MonthDesc() {
        String[] result = new String[12];
        Calendar cal = Calendar.getInstance();
        // java.util.GregorianCalendar
        // System.out.println(cal);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        for (int i = 0; i < 12; i++) {
            // Calendar.MONTH 月份从0开始 0-11
            // result[i] = cal.get(Calendar.YEAR) + "-" + int2StrMonth(cal.get(Calendar.MONTH)+1);
            result[i] = format.format(cal.getTime());
            cal.add(Calendar.MONTH, -1);
        }
        return result;
    }

    private static String int2StrMonth(int i) {
        return i < 10 ? "0" + i : "" + i;
    }

    @Test
    public void testMon12() {

        String[] latest12MonthDesc = getLatest12MonthDesc();
        System.out.println(Arrays.toString(latest12MonthDesc));
    }
}
