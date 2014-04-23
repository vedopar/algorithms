public class Solution {
    /*
    * Greedy version of doing this.
    */
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1) return 0;
        int res=0;
        int begin=0;
        for(int end=1;end<prices.length;end++){
            if(prices[begin]>prices[end]) begin=end;
            else res=Math.max(res,prices[end]-prices[begin]);
        }
        return res;
    }
}
