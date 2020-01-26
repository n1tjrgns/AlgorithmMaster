package programmers.skillchecktest;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer2 {

    public int solution(int[] priorities, int location) {
        //뽑을 때 마다 우선순위가 바뀜, 우선순위 큐를 사용해야함.
        int answer = 1;

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for(int priority : priorities){
            que.add(priority);
        }

        while(!que.isEmpty()) {
            for(int i=0; i<priorities.length; i++){
                //우선순위가 같고
                if(priorities[i] == que.peek() ) {
                    //위치까지 같으면
                    if( i == location){
                        //바로 리턴
                        return answer;
                    }
                    //같지 않으면 우선순위가 높다는 소리기때문에 출력해버림
                    que.poll();
                    answer++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Printer2 p = new Printer2();
        System.out.println(p.solution(new int[]{2, 1, 3, 2},2));
    }

}
