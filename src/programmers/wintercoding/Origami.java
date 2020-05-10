package programmers.wintercoding;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/62049#
public class Origami {
    public int[] solution(int n) {
        StringBuilder sb = new StringBuilder("0");

        while(n > 1){
            String str = sb.toString();

            sb.append(0); // 항상 기준점은 0이기 때문에 매번 반복하기전에 0을 추가해줌

            System.out.println("length : " + sb.toString().length());

            for(int i=str.length() -1; i>=0; i--){
                if(str.charAt(i) == '1'){
                    sb.append(0);
                }else{
                    sb.append(1);
                }
            }

            n--;
        }

        System.out.println(sb.toString());


        int[] answer = new int[sb.length()];

        for (int i=0; i<answer.length; i++){
            answer[i] = sb.charAt(i) - '0';
        }
        return answer;
    }

    public static void main(String[] args) {
        Origami o = new Origami() ;
        System.out.println(Arrays.toString(o.solution(2)));
    }
}
