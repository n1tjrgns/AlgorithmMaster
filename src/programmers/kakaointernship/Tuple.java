package programmers.kakaointernship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/64065
//https://cheonjoosung.github.io/blog/pg-tuple
public class Tuple {
    public int[] solution(String s) {
        //순서가 다르면 다른 튜플이다
        /*예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는
        {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
         갯수에 따라서 정렬이 필요하다

         1개짜리가 2이므로 2개 제일 먼저오는 튜플
         그 다음 2,1이 왔으므로 2번째는 1*/

        String str = s.substring(2,s.length()-2).replace("},{","-");
        String[] regStr = str.split("-");

        System.out.println(Arrays.toString(regStr));

        Arrays.sort(regStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        List<Integer> list = new ArrayList<>();
        for(String splitStr : regStr){
            String[] temp = splitStr.split(",");
            System.out.println(Arrays.toString(temp));

            for(int i=0; i<temp.length; i++){
                if(!list.contains(Integer.parseInt(temp[i]))){
                    list.add(Integer.parseInt(temp[i]));
                }
            }
        }

        System.out.println(list);
        int[] answer = new int[list.size()];

        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Tuple t = new Tuple();
        System.out.println(Arrays.toString(t.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}
