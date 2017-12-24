class Solution {
    // best time to buy and sell stock
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int best = 0, low = prices[0], hi = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
                hi = prices[i];
            }
            if (prices[i] > hi)
                hi = prices[i];
            if (hi - low > best)
                best = hi - low;
        }
        return best;
    }
}
