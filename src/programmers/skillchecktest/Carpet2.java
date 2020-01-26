package programmers.skillchecktest;

import java.util.Arrays;

public class Carpet2 {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int width = brown + red;

        // width = m x n을 만족하는 수를 찾아야 함
        for(int i=1; i<width; i++){
            if(width % i == 0){
                int temp = width / i;
                if((temp-2) * (i-2) == red){
                    answer[0] = temp;
                    answer[1] = i;
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Carpet2 c= new Carpet2();
        System.out.println(Arrays.toString(c.solution(10,2)));
    }
}
