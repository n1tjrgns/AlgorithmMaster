package programmers.greedy;

import java.util.HashSet;
import java.util.Set;

public class TrainingCloth {

    //체육복은 바로 앞, 뒤만 빌려줄 수 있음
    //여벌이 있으면 빌려줄 수 있어
    //여벌이 있는데 도난당하면 못빌려줘
    //최대 체육복을 가지고 있는 수 리턴

    // 잃어버린 사람과 여벌있는 사람 인덱스가 같으면 + 1
    // 한쪽으로만 빌려주도록 체크는 어떻게 하지?
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; //잃어버린 사람 제외

        Set<Integer> set = new HashSet<>();
        for(int r : reserve){
            set.add(r);
        }
        for(int i=0; i<lost.length; i++){
            if(set.contains(lost[i])){
                answer++;
                set.remove(lost[i]);
                lost[i] = -1;
            }
        }
        for(int i=0; i<lost.length; i++){
            if(set.contains(lost[i]-1)){
                answer++;
                set.remove(lost[i]-1);
            }else if(set.contains(lost[i]+1)){
                answer++;
                set.remove(lost[i]+1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        TrainingCloth t = new TrainingCloth();
        System.out.println(t.solution(5,new int[]{2,4}, new int[]{1,3,5}));
        System.out.println(t.solution(5,new int[]{1,3,4,6}, new int[]{2,4,6,7}));
    }
}
