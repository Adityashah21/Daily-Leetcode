class Solution {
    public int maxProfit(int[] prices) {
        int buy= Integer.MAX_VALUE;
        int sell=0;
        for(int i=0; i<prices.length;i++){
            if(buy>prices[i]){
                buy=prices[i];
            }
            int profit = prices[i] - buy;

            if(profit > sell) {
                sell = profit;
            }
        }
        return sell;
    }
}