package com.Algorithms.Array;

/**
 * @Description TODO
 * @Author ZY
 * @Date 2021/1/7 16:32
 **/
public class test {
    public static void main(String[] args) {
        System.out.println("====开始生成图片：============");
        Long startTime = System.currentTimeMillis();
        String sealid = "2616199893913903237";
        //String sealid = "9223372036854775807";
        Long l_sealid = Long.valueOf(sealid);
        System.out.println(l_sealid);
        Long endTime = System.currentTimeMillis();
        System.out.println("====图片生成完成，总耗时："+ String.valueOf((endTime - startTime) / 1000)+"秒 ======================");

    }
}
