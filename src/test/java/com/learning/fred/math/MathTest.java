package com.learning.fred.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fred
 * @date 2020/9/24 10:16 上午
 * @description todo
 */
public class MathTest {

    @Test
    public void test() {
        BigDecimal recommend1 = new BigDecimal("0.1");
        BigDecimal recommend2 = BigDecimal.valueOf(0.1);


        Map<String, Object> map = new HashMap<>();
        if (map.isEmpty()) {
            System.out.println("no element in this map.");
        }
// 第一种情况:在闰年 366 天时，出现数组越界异常
        int[] dayArray = new int[365];
// 第二种情况:一年有效期的会员制，今年 1 月 26 日注册，硬编码 365 返回的却是 1 月 25 日
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 1, 26);
        calendar.add(Calendar.DATE, 365);
    }
}
