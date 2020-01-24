package programmers.skillchecktest;

import java.util.Arrays;

public class Carpet {

    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int width = brown + red;

        //주어진 갈색 + 빨강 = 사각형의 넓이
        //red = m x n -> (m-2) x (n-2) 를 파악하는 것이 핵심
        //m x n을 구하기 위해 약수 인지 % 연산으로 확인하고
        //약수일 경우 m에 몫을 집어 넣어 red를 구하기 위한 연산을 한 후
        //red와 같은 경우 정답

        for(int i=1; i<=width; i++){
            if(width%i ==0){
                int temp = width/i;
                if(((temp-2)*(i-2)) == red){
                    answer[0] = temp;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Carpet c = new Carpet();
        int brown = 10;
        int red = 2;
        System.out.println(Arrays.toString(c.solution(brown,red)));
    }
}
