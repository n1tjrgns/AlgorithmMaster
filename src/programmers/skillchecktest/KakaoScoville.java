package programmers.skillchecktest;

import java.util.Collections;
import java.util.PriorityQueue;

public class KakaoScoville {
    public int solution(int[] scoville, int K) {
        //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        //우선 순위 큐에 넣으면 자동으로 최소힙 기준으로 정렬된다.
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; i++) {
            que.offer(scoville[i]);
        }


        PriorityQueue<Integer> third = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : scoville){
            third.add(a);
        }

        while(que.peek() < K){
            int hotSource = que.poll() + que.poll()*2;
            que.offer(hotSource);
            answer++;

            if (que.peek() >= K){
                break;
            }

            if(que.size() == 1 && que.peek() < K){
                answer = -1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        KakaoScoville k = new KakaoScoville();
        int[] arr = {1,2,3,9,10,12};
        System.out.println(k.solution(arr,7));
    }
}
