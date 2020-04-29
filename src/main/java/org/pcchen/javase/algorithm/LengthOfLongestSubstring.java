package org.pcchen.javase.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 获取无重复字符的最长子串长度
 *
 * @author ceek
 * @date 2020/1/5 11:10
 */
public class LengthOfLongestSubstring {
//    public int lengthOfLongestSubstring(String s) {
//        int maxLength = 0;
//        for(int i = 0; i < s.length(); i++) {
//            for(int j = i+1; j <= s.length(); j++) {
//                String substring = s.substring(i, j);
//                if(!hasRepeatString(substring)) {
//                    maxLength = Math.max(maxLength, j - i);
//                }
////                System.out.println(substring + "--->" + maxLength);
//            }
//        }
//        return maxLength;
//    }
//
//    public boolean hasRepeatString(String s) {
//        Set<String> tmpSet = new HashSet<String>();
//        for(int i = 0; i < s.length(); i++) {
//            if(tmpSet.contains(s.substring(i, i+1))){
//                return true;
//            }
//            tmpSet.add(s.substring(i,i+1));
//        }
//        return false;
//    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~"));
//        System.out.println("pwwkew".substring(0,0));
    }
}