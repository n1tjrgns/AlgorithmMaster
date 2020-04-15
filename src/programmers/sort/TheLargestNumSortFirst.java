package programmers.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TheLargestNumSortFirst {
    public String solution(int[] numbers){
       String answer = "";
       List<String> list = new ArrayList<>();

       for(int i=0; i<numbers.length; i++){
           list.add(Integer.toString(numbers[i]));
       }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //System.out.println("o1 : "+ o1 + "  o2 : " + o2);
                return (o2+o1).compareTo(o1+o2);
            }
        });

       if(list.get(0).equals("0")){
           return "0";
       }
       for(int i=0; i<list.size(); i++){
           answer = answer + list.get(i);
       }

       return answer;
    }

    public static void main(String[] args) {
        TheLargestNumSortFirst t = new TheLargestNumSortFirst();
        System.out.println(t.solution(new int[]{6,10,2})); //"6210"
        //System.out.println(t.solution(new int[]{3,34,30})); //"34330"
        //System.out.println(t.solution(new int[]{0, 9, 8, 7, 96})); //"996870"
        //System.out.println(t.solution(new int[]{3,30,34,5,9})); //"9534330"
    }
}
