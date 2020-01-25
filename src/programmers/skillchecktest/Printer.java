package programmers.skillchecktest;

import java.util.Collections;
import java.util.PriorityQueue;
class Printer {
    public int solution(int[] priorities, int location) {

        //출력되는 차례는 0이 없기 때문에 1부터 시작
        int answer = 1;

        //최대힙을 가지는 내림차순으로 우선순위 큐 선언. 큐의 내용이 바뀔 때 마다 우선 순위가 바뀌어야 하기 때문에
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for(int priority : priorities){
            que.add(priority);
        }
        System.out.println(que);

        while (!que.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                //우선순위와 현재 대기중인 목록이 같으면
                if(priorities[i] == que.peek()){
                    //정답과 현재 목록의 위치가 같다면 바로 리턴
                    if(i == location){
                        return answer;
                    }
                    //아니면 다음 수와 비교를 위해 꺼냄(=프린트함) 카운트 ++
                    que.poll();
                    answer++;
                }
            }

        }



        return answer;
    }

    public static void main(String[] args) {
        Printer s = new Printer();
        System.out.println(s.solution(new int[]{2,5,4,1,3}, 2));
    }
}