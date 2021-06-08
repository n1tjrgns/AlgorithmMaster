package inflearn.stringarray.sec2StringArray2;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //다 char 값으로 만들어서 더한다음에 값이 같은것끼리 묶으면 되지않을까??
        if (strs == null || strs.length ==0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray); //char 배열로 변환해서 오름차순 정렬
            String key = String.valueOf(charArray);
            if (map.containsKey(key)){
                map.get(key).add(str);
                System.out.println("map = " + map);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        answer.addAll(map.values());

        return answer;
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        System.out.println(g.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
