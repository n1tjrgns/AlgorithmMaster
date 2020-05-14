package leetcode.easy;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        //두 배열의 요소의 차이가 가장 큰 값을 리턴
        int max = 0;
        for(int i=0; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[i] < prices[j]){
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        System.out.println(b.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
