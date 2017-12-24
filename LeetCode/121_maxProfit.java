class Solution {
    // best time to buy and sell stock
    public int maxProfit(int[] prices) {
        int best = 0, low = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < low)
                low = prices[i];
            if (prices[i] - low > best)
                best = prices[i] - low;
        }
        return best;
    }
}
