package com.Algorithms.知行软件;

/**
 * 给任意整数字符串，输出该整数的中文读音
 */
public class NumToZH {

    public static void main(String[] args) {
        System.out.println("-2: " + int2chineseNum("-2"));
        System.out.println("0: " + int2chineseNum("0"));
        System.out.println("10: " + int2chineseNum("10"));
        System.out.println("101: " + int2chineseNum("101"));
        System.out.println("10001: " + int2chineseNum("100001"));
        System.out.println("203001: " + int2chineseNum("203001"));
        System.out.println("1000000000: " + int2chineseNum("1000000000"));
        System.out.println("1300006000: " + int2chineseNum("1300006000"));
    }

    public static String int2chineseNum(String s) {
        final String[] num = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        final String[] unit = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};
        StringBuilder dst = new StringBuilder();
        String sign = "";
        int count = 0;
        if (s.charAt(0) == '-') {
            sign = "负";
            s = s.substring(1);
        }
        int i = Integer.parseInt(s);
        if (i == 0) {
            return "零";
        }
        while(i > 0) {
            dst.insert(0, (num[i % 10] + unit[count]));
            i = i / 10;
            count++;
        }
        return sign + dst.toString().replaceAll("零[千百十]", "零").replaceAll("零+万", "万")
                .replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
                .replaceAll("零+", "零").replaceAll("零$", "")
                .replace("一十","十");
    }
}
