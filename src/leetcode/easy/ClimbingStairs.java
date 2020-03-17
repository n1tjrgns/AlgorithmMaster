package leetcode.easy;

/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step*/
public class ClimbingStairs {

    public int climbStairs(int n) {
        //아래와 같이 풀었으니 시간초과로 실패
        //피보나치 수열 재귀 문제는 위와 같이 풀면 시간 복잡도가 O(2의 n승)이 되어버린다.
        //말단 노드에 도착하기까지 두 개의 자식 노드를 가지고 있기 때문에 n번 반복하게되면..
        // n이 40이 넘어가는 순간 기하 급수적으로 늘어난다.

        /*if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs(n-2) + climbStairs(n-1);*/


        //메모제이션을 사용한 피보나치 수열 리팩토링
        return climbStairs(n, new int[n+1]);
    }

    private int climbStairs(int n, int[] memozation) {
        if(n==0 || n==1){
            return 1;
        }
        if(memozation[n] == 0){
            memozation[n] = climbStairs(n-1, memozation ) + climbStairs(n-2, memozation);
        }

        return memozation[n];
    }

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.println(c.climbStairs(3));
        System.out.println(c.climbStairs(2));
    }
}
