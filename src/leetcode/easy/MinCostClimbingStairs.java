package leetcode.easy;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 *
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbingStairs {
    //1칸 또는 2칸씩 움직일 수 있다.
    //인덱스 0번부터 시작이 아닌, 인덱스 0은 1칸, 인덱스 1은 2칸의 의미를 가진다.
    //1칸 또는 2칸을 움직이면서 해당하는 숫자들의 가장 작은 값을 구하는 문제
    //계단오르는 문제와 약간 비슷
    public int minCostClimbingStairs(int[] cost) {
        int f1 = cost[0], f2 = cost[1];
        for (int i = 2; i < cost.length; i++) {

            int f_current = cost[i] + Math.min(f1, f2);
            f1 = f2;
            f2 = f_current;
        }
        return Math.min(f1, f2);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        System.out.println(m.minCostClimbingStairs(new int[]{10,15,20}));
    }
}
