package remindprogrammers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public int solution(int[] priorities, int location) {
        //해당 location에 해당하는 숫자의 인덱스를 계속 가지고 가야함.
        int answer = 0;

        Queue<Integer> que = new LinkedList<>();

        for (int priority : priorities) {
            que.add(priority);
        }

        Arrays.sort(priorities);
        int length = priorities.length-1;

        while (!que.isEmpty()){
            int current = que.poll();
            System.out.println("current = " + current);

            if (current == priorities[length - answer]){
                answer++;
                location--;
                if (location < 0){
                    break;
                }
            }else{
                que.add(current);
                System.out.println("que = " + que);
                location--;
                if (location<0){
                    location = que.size()-1;
                }
            }

        }


        return answer;
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        System.out.println(p.solution(new int[]{1,1,9,1,1,1}, 0));
    }
}
