package inflearn.stringarray.sec6DP;

import java.util.Arrays;

//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    //1또는 2칸씩 움직일 수 있을 때 n에 도달 할 수 있는 방법은 총 몇가지?

    //bruteforce
    public int climbStairsBruteforce(int n) {
        return backtrack(0, n);
    }

    private int backtrack(int i, int n) {
        if (i > n) return 0;

        if (i == n) return 1;

        return backtrack(i + 1, n) + backtrack(i + 2, n);
    }

    //bruteforce 메모제이션
    private int climbStairsMemozation(int i) {
        int[] memo = new int[i+1];
        return recursive(0, i, memo);
    }

    private int recursive(int climbCount, int target, int[] memo) {
        if (climbCount > target) return 0;
        if (climbCount == target) return 1;
        if (memo[climbCount] > 0){
            return memo[climbCount];
        }

        memo[climbCount] = recursive(climbCount+1, target, memo) + recursive(climbCount+2, target, memo);
        System.out.println("memo = " + Arrays.toString(memo));
        return memo[climbCount];
    }

    //DP 풀이
    private int climbStairsDP(int i) {
        if (i==1) return 1;

        int[] dp = new int[i + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int n = 3; n <= i; n++) {
            dp[n] = dp[n - 1] + dp[n - 2];
        }

        return dp[i];
    }

    private int climbStairsFibonacci(int i) {
        if (i == 1) {
            return 1;
        }

        int first = 1;
        int second = 2;
        for (int n = 3; n <= i; n++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.println(c.climbStairsMemozation(3));
        System.out.println(c.climbStairsDP(3));
        System.out.println(c.climbStairsFibonacci(3));
    }


}
