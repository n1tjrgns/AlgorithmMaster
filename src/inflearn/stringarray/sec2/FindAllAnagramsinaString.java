package inflearn.stringarray.sec2;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 아나그램 : 순서가바뀐 문자열
 * 주어진 두 문자열이 있을 때 p를 가지고 s에서 만들 수 있는 문자열인 경우 시작점을 리턴
 * SlideWindow 알고리즘 : 일정한 범위를 가지고 있는 것을 유지하면서 이동하는 경우
 * Longestsubstringwithatmosttwodistinctcharacters.java 문제와 유사한 유
 */
public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        //이 문제도 start, end로 나눠서
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> reference = new HashMap<>(); //reference map for p
        for(int i=0; i<p.length(); i++)
            reference.put(p.charAt(i), reference.getOrDefault(p.charAt(i),0)+1);

        Map<Character, Integer> map = new HashMap<>(); //map to cache the chars in sliding window
        int start=0, end=0, match=0;
        while(end<s.length())
        {
            char c1 = s.charAt(end);
            if(reference.containsKey(c1))
            {
                map.put(c1, map.getOrDefault(c1,0)+1);
                if(map.get(c1).equals(reference.get(c1))) match++;
                System.out.println("match = " + match);
            }
            while(match==reference.size())
            {
                if(end-start+1==p.length())
                    ans.add(start);

                char c2 = s.charAt(start);
                if(reference.containsKey(c2))
                {
                    map.put(c2, map.get(c2)-1);
                    if(map.get(c2)<reference.get(c2))
                        match--;
                }
                start++;
            }
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAllAnagramsinaString f = new FindAllAnagramsinaString();
        System.out.println(f.findAnagrams("cbaebabacd","abc"));
    }
}
