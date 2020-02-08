package codinginterview.dynamicprogramming;
/*
* 어떤 아이가 n개의 계단을 오른다. 한 번에 1계단, 2계단, 3계단을 오르기도 한다. 계단을 오르는 방법이 몇 가지가 있는지 계산하는 메소드를 구현하라*/
public class TrippleStep1 {

    //TODO 결국 피보나치 문제
    // 하지만 아래처럼 풀 경우 시간 복잡도는 O(3의 n승) => 재귀를 3번 호출 함.
    public int solution(int n){

        if( n < 0){
            return 0;
        }else if(n==0){
            return 1;
        }else{
            return solution(n-1) + solution(n-2) + solution(n-3);
        }
    }

    public static void main(String[] args) {
        TrippleStep1 t = new TrippleStep1();
        int n = 3;

        System.out.println(t.solution(n));
    }

}
