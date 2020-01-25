package programmers.skillchecktest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KakaoScoville {
    static boolean[] visited;
    public int solution(int[] scoville, int K) {
        //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        visited = new boolean[scoville.length];
        ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;
        for(int i=0; i<scoville.length; i++){
            if(!visited[i]){
                bfs(i, scoville, K, list);
                answer++;
            }
        }

        return answer;
    }

    public void bfs(int idx, int[] scoville, int k, ArrayList<Integer> list) {
        Queue<Integer> que = new LinkedList<>();

        que.add(idx);
        visited[idx] = true;
        //{1,2,3,9,10,12};
        while(!que.isEmpty()){
            for(int i=0; i<scoville.length; i++){
                    visited[i] = true;
                    int temp = que.poll();
                    if(temp >= k){
                        //k보다 크면 섞을 필요 없어 뒤로보내
                        que.add(temp);
                    }else{
                        //k보다 작은 수가 왔어, 근데 작은 수가 하나 더 필요하잖아?
                        //배열을 하나 더 만들어서 거기에 temp를 넣어놓고
                        //배열의 길이 2가 되면 스코빌을 태워?

                        if(list.size() < 2){
                            list.add(temp);
                            bfs(i, scoville, k , list);
                        }else if(list.size() == 2){
                            int hot = 0;
                            //스코빌 공식
                            for(int j=0; j<2; i++){
                                hot = Math.min(list.get(0),list.get(1)) + (Math.max(list.get(0),list.get(1))*2);
                            }
                            que.remove(list.get(0));
                            que.remove(list.get(1));
                            que.add(hot);
                        }
                    }

            }
        }
    }

    public static void main(String[] args) {
        KakaoScoville k = new KakaoScoville();
        int[] arr = {1,2,3,9,10,12};
        System.out.println(k.solution(arr,7));
    }
}
