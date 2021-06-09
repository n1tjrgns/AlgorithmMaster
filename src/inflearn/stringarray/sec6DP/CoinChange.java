package inflearn.stringarray.sec6DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/coin-change/
//https://kimchanjung.github.io/algorithm/2020/05/08/Coin-Change/
public class CoinChange {
    //코인을 조합해서 amount와 일치하면 사용된 개수를 리턴
    //원소 중복 사용 가능, 최소 개수 반환해야함
    //조합 불가능하면 -1, 양이 없으면 0
    //목표 수에서 현재 배열의 값을 빼서 0이 되면 만족하는 조합임.

    //시간 초과
    List<Integer> minArr = new ArrayList<>();
    public int coinChangeTimeOver(int[] coins, int amount) {
        if (amount < 1) return 0;

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, coins, new ArrayList<>(), amount,0);
        System.out.println("minArr = " + minArr);
        if (minArr == null || minArr.size() == 0) return -1;
        Collections.sort(minArr);
        return minArr.get(0);
    }

    private void backtrack(List<List<Integer>> result, int[] coins, ArrayList<Integer> tempList, int amount, int start) {
        if (amount < 0) return;
        else if (amount == 0) {
            result.add(new ArrayList<>(tempList));
            int maxValue = Integer.MAX_VALUE;
            minArr.add(Math.min(maxValue, tempList.size()));

        }else {
            for(int i=start; i<coins.length; i++){
                tempList.add(coins[i]);
                backtrack(result, coins, tempList, amount-coins[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    /*
     * 동전이 없다

dp[0]=0 이라는 뜻

===============================

1원 동전이 있을려면, 1원 1개가 필요

dp[1]=1개 이렇게 되야겠죠? 이걸 구할려면 맨오른쪽에 +1일 필요하다는걸 알게됩니다.

dp[1] = Math.min(dp[1], dp[1 - coins[j]] + 1);

1-1 = dp[0]=0(앞에서 구한거 이용->재사용이죠?)+1

1-2 = (X)(1 보다 크므로 위에 소스코드 조건절 걸림)

1-5 = (X)(1 보다 크므로  위에 소스코드 조건절 걸림)

dp[1] = Math.min(12, 1) 이렇게 나오니까

dp[1] =1을 구한거죠? 이해되시죠?

============================

2원 동전이 있을려면,2원 1개가 필요

dp[2]=1개 이런 답을 구해야겠죠?

dp[2] = Math.min(dp[2], dp[2 - coins[j]] + 1);

2-1 = dp[1]=1+1(앞에서 구한거 이용->재사용이죠?)

2-2 = dp[0]=0+1(앞에서 구한거 이용->재사용이죠?)

2-5 = (X)(-값이 나오므로 패스)

dp[2] = Math.min(12, 2) 이렇게 나오니까

dp[2] = Math.min(12, 1) 이렇게 나오니까

결론은, 1원짜리 2개를 쓸거냐, 2원짜리 1개를 쓸거냐 결국

dp[2]=1개

====================================

3원 동전이 있을려면,1원 1개가 필요 2원 1개가 필요

dp[3]=2개

dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);

dp[3] = Math.min(dp[3], dp[3 - coins[j]] + 1);

3-1 = dp[2]=1(앞에서 구한거 이용->재사용이죠?)

3-2 = dp[1]=1(앞에서 구한거 이용->재사용이죠?)

3-5 = (X)(-값이 나오므로 패스)

====================================

4원 동전이 있을려면, 2원 2개가 필요

dp[4]=2개

dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);

dp[4] = Math.min(dp[4], dp[4 - coins[j]] + 1);

4-1 = dp[3]=2(앞에서 구한거 이용->재사용이죠?)

4-2 = dp[2]=1(앞에서 구한거 이용->재사용이죠?)

4-5 = (X)(-값이 나오므로 패스)


     */
    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max); //max 값으로 초기화 시켜
        dp[0] = 0; //0원을 만들 수 있는 경우는 0개 이므로

        for (int i = 1; i <= amount; i++) {
            for(int j=0; j<coins.length; j++){
                if (i >= coins[j]){ //빼서 음수가 나온다는 것은 만들 수 없다는것. 양수가 나오면 아직 더 조합이 가능하다는것
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        System.out.println("dp = " + Arrays.toString(dp));
        //각 dp의 인덱스가 의미하는 것은 인덱스 자리별 최소로 만들 수 있는 조합의 개수를 의미함.
        return dp[amount] > amount ? -1 : dp[amount]; //만약에 코인으로 조합을 하지 못한다면, maxValue가 남아있으테니 if문이 이렇게 됨.
    }
    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{1,2,5},11));
        System.out.println(c.coinChange(new int[]{2},3));
        //System.out.println(c.coinChange(new int[]{2},3));
    }
}
