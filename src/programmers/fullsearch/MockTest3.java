package programmers.fullsearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MockTest3 {
    //1번 : 1, 2, 3, 4, 5
    //2번 : 2, 1, 2, 2, 2, 3, 2, 4, 2, 5
    //3번 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5

    //정답지가 주어질 때, 누가 제일 많이 맞췄는지, 같으면 여러명 출력
    public int[] solution(int[] answers) {
        //3명에 대한 결과 값
        int[] answer = {};

        //맞춘 갯수 카운트
        int[] count = new int[3];

        int num1[] = {1,2,3,4,5};
        int num2[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int num3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i=0; i<answers.length; i++){
            if(answers[i] == num1[i%num1.length]){
                count[0]++;
            }
            if(answers[i] == num2[i%num2.length]){
                count[1]++;
            }
            if(answers[i] == num3[i%num3.length]){
                count[2]++;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        int max = Math.max(Math.max(count[0],count[1]), count[2]);

        if(max == count[0]) list.add(1);
        if(max == count[1]) list.add(2);
        if(max == count[2]) list.add(3);

        answer = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void main (String[]args){
        MockTest3 m = new MockTest3();
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(m.solution(arr)));
    }
}
