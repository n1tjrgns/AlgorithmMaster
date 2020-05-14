package leetcode.easy.dp;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i] < prices[i+1]){
                sum += prices[i+1] - prices[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 b = new BestTimeToBuyAndSellStock2();
        System.out.println(b.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(b.maxProfit(new int[]{1,2,3,4,5}));
    }
}
