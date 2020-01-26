package leetcode.easy;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int length = s.length();

        //i가 i+1보다 작은경우 -를 해준다,  "IV" => 1 - 5
        //i가 i+1보다 큰 경우  +를 해준다,  "XV" => 5+10
        //뺄셈을 위해 맨 뒷 항을 미리 구해놓는다.
        int result = map.get(s.charAt(length - 1));

        System.out.println(result);
        for(int i=length-2; i>=0; i--){
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1))){
                result = result + map.get(s.charAt(i));
            }else{
                result = result - map.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();
        System.out.println(r.romanToInt("IV"));
    }
}
