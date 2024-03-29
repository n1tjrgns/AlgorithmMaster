package leetcode.medium;

// Given a string s, find the length of the longest substring without repeating characters.

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j =0;
        int max =0;

        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar l = new LongestSubstringWithoutRepeatingChar();
        System.out.println(l.lengthOfLongestSubstring("dvdf"));;
    }
}
