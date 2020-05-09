package programmers.greedy;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42885
public class LifeBoat {
    /*
        한 번에 최대 2명씩, 무게 제한 있음
        무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
        각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
        구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
        구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
        [70, 50, 80, 50]	100	 -> 3
        [40, 70, 50, 80, 50, 40, 30]	100	 -> 4
    * */
    public int solution(int[] people, int limit) {

        //빠른 탈출
        if(people.length < 1 && people.length > 50000 && limit < 40 && limit > 240){
            return -1;
        }

        int answer = 0;

        Arrays.sort(people);
        int index = 0, i;

        //정렬 후 가장 큰 값과, 가장 작은 값이 limit 을 초과하면 태우지 못하는 원리
        for(i=people.length-1; index<i; i--){
            //초과하면 카운트를 증가시키고 i-1
            if(people[index] + people[i] > limit){
                answer++;
            }else{ //초과하지 않으면 2명을 태운셈이니 카운트와 index를 같이 증가
                index++;
                answer++;
            }
        }

        //한명만 남은 경우
        if(index == i){
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {

        LifeBoat l = new LifeBoat();
        System.out.println(l.solution(new int[]{70,50,80,50}, 100)); // 3
        System.out.println(l.solution(new int[]{70,80,50}, 100)); // 3
    }
}
