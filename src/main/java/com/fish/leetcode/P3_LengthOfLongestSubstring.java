package com.fish.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2020:09:16 16:06
 */
public class P3_LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "dvsdfghjklvsdifn";
        // System.err.println(Arrays.toString(str.toCharArray()));
        // System.err.println(lengthOfLongestSubstring(str));
        System.err.println(lengthOfLongestSubstring2(str));
    }

    // 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    //
    // 示例 1:
    //
    // 输入: "abcabcbb"
    // 输出: 3
    // 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //
    //
    // 示例 2:
    //
    // 输入: "bbbbb"
    // 输出: 1
    // 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //
    //
    // 示例 3:
    //
    // 输入: "pwwkew"
    // 输出: 3
    // 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    //
    // Related Topics 哈希表 双指针 字符串 Sliding Window
    // 👍 4317 👎 0
    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();

        int index = 0;
        int longestLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (index < arr.length) {
            char c = arr[index];
            if (map.containsKey(c)) {
                longestLength = Math.max(map.size(), longestLength);
                index = map.get(c) + 1;
                map.clear();
                continue;
            }
            map.put(c, index);
            index++;
        }
        return Math.max(longestLength, map.size());
    }

    /**
     * 时间复杂度 更小的解法
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        int maxLen = 0, i = 0, left = 0, count = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> usedMap = new HashMap<>(s.length());
        while (left < s.length() && i < s.length() ){
            char c = chars[i];
            if (usedMap.containsKey(c) && usedMap.get(c) >= left){
                maxLen = Math.max(maxLen, count);
                left = usedMap.get(c)+1;
                count = i - left + 1;
            } else{
                count++;
            }
            usedMap.put(c, i);
            i++;
        }
        return Math.max(count, maxLen);
    }

}
