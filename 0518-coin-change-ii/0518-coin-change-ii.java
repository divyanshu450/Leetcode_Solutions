class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] memo = new Integer[coins.length][amount + 1];
        return coinChange(amount, coins, 0, 0, memo);
    }

    int coinChange(int amount, int[] coins, int i, int sum, Integer[][] memo) {
        if (sum == amount) return 1;
        if (sum > amount || i == coins.length) return 0;

        if (memo[i][sum] != null) return memo[i][sum];

        // pick (stay at same index)
        int pick = coinChange(amount, coins, i, sum + coins[i], memo);

        // skip (move to next coin)
        int skip = coinChange(amount, coins, i + 1, sum, memo);

        memo[i][sum] = pick + skip;
        return memo[i][sum];
    }
}