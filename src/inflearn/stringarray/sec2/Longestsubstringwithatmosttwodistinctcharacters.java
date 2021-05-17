package inflearn.stringarray.sec2;

import java.util.HashMap;
import java.util.Map;

//String에서 2개의 문자를 골라서 길이를 쟀을 때 가장 긴 길이 측정
//문자가 연속적으로 오지않아도 되지만 해당 길이 안에 포함되어있어야함.
public class Longestsubstringwithatmosttwodistinctcharacters {
    //단어의 개수를 저장해서 문자를 탐색하다가 2개보다 크면 start ++해서 앞으로 이동시키고
    // 그전까지는 end를 계속 이동시키고, end가 멈추는 순간 길이를 저장해두고 Max로 비교해야한다.
    //start, end 두 포인터를 사용해야함.
    public int lengthOfLongestSubMostTwoDist(String s) {

        int start = 0;
        int end = 0;
        int count=0; //알파벳 개수
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()){
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar,0)+1);

            if (map.get(endChar) == 1) count++;

            end++;
            //count가 2보다 크다는 것은 알파벳이 3개인것이므로 start를 앞으로 당겨야한다.
            if (count > 2){
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar)-1);
                if (map.get(startChar) == 0) count--; // 0이 되면 더이상 해당 알파벳이 없기 때문에 count를 마이너스 해준다.
                start++;
            }
            maxLength = Math.max(maxLength, end - start);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Longestsubstringwithatmosttwodistinctcharacters l = new Longestsubstringwithatmosttwodistinctcharacters();
        System.out.println(l.lengthOfLongestSubMostTwoDist("ccaabbb")); //5
        System.out.println(l.lengthOfLongestSubMostTwoDist("eceba")); //3
    }
}
