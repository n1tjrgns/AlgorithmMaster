package programmers.fullsearch;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/42842
public class Carpet {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];

        int width = brown + red;

        for(int i=1; i<=width; i++){
            if(width % i == 0){
                int temp = width / i;
                if((temp-2) * (i-2) == red){
                    answer[0] = temp;
                    answer[1] = i;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Carpet c = new Carpet();
        System.out.println(Arrays.toString(c.solution(8, 1)));
    }
}
