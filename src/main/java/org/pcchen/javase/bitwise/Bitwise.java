package org.pcchen.javase.bitwise;

/**
 * 位运算
 *
 * @author ceek
 * @create 2020-09-29 11:08
 **/
public class Bitwise {
    public static void main(String[] args) {
//        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~"));
//        System.out.println("pwwkew".substring(0,0));

//         b = 1000000000000;
//        String s = Integer.toBinaryString(1024);
//        int a = 1024 << 70;
//        int b = 1024 >> 2;
//        System.out.println(s);
//        System.out.println(a);
//        System.out.println(b);

        int abc = 45700;
        System.out.println(Integer.toBinaryString(20));

        int a = 1000;       //定义变量默认为10进制
        int b = 1010;       //定义变量默认为10进制
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));

        int c = a ^ b;
//        System.out.println(Integer.toBinaryString(20));
        System.out.println(c);  //26
    }
}
