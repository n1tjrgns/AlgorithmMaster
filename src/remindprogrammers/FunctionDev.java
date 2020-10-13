package remindprogrammers;

import java.util.*;

public class FunctionDev {
    public int[] solution(int[] progresses, int[] speeds) {
        // 작업이 걸리는 일수 계산
        Queue<Integer> que = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            int mok = (100 - progresses[i]) / speeds[i];
            int mod = (100 - progresses[i]) % speeds[i];

            if (mod != 0){
                que.add(mok+1);
            }else{
                que.add(mok);
            }
        }

        List<Integer> result = new ArrayList<>();

        int cnt=0;
        while (!que.isEmpty()){
            int current = que.poll();
            cnt++;

            while (!que.isEmpty()){
                if (que.peek() > current){
                    result.add(cnt);
                    cnt = 0;
                    break;
                }else{
                    que.poll();
                    cnt++;
                }
            }
        }

        if(cnt !=0 ){
            result.add(cnt);
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        FunctionDev f = new FunctionDev();
        System.out.println(Arrays.toString(f.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }
}
