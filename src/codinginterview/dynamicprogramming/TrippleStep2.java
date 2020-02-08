package codinginterview.dynamicprogramming;

import java.util.Arrays;

/*
* 어떤 아이가 n개의 계단을 오른다. 한 번에 1계단, 2계단, 3계단을 오르기도 한다. 계단을 오르는 방법이 몇 가지가 있는지 계산하는 메소드를 구현하라*/
public class TrippleStep2 {

    //메모제이션을 사용한 피보나치 문제 풀이
    // n을 이전에 이미 계산을 했다면, 캐시에 저장된 값 반환
    // 일반적으로 캐시는 HashMap 을 사용
    public int solution(int n){

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return solution(n, memo);

    }

    private int solution(int n, int[] memo) {
        if(n<0){
            return 0;
        }else if(n==0) {
            return 1;
        }else if(memo[n] > -1){
            return memo[n];
        }else{
            return memo[n] = solution(n-1, memo) + solution(n-2, memo) + solution(n-3, memo);
        }
    }

    public static void main(String[] args) {
        TrippleStep2 t = new TrippleStep2();
        int n = 4;

        System.out.println(t.solution(n));
    }

}
