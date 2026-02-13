class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;// filling it with max val;
        int op = 0;
        int pist = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){
                lsf = prices[i];// updating and storing the max price
            }
            pist = prices[i] - lsf;//getting the difference
            if(op < pist){
                op = pist;//updating the ans for max value;
            }
        }
        return op;
    }
}