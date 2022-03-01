package Day8_dynamicProgramming;

public class Solution {

    public static final int MOD = 1000000007;

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        for (int i = 2; i <= n; i++) {
            int f2 = (f0 + f1) % MOD;
            f0 = f1;
            f1 = f2;
        }
        return f1;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     */
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            int f3 = (f1 + f2) % MOD;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }

    /**
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // 定义状态，第i天卖出的最大收益
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int cost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - cost);
            cost = Math.min(cost, prices[i]);
        }

        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(5));
        System.out.println(solution.fib(45));
        System.out.println(solution.numWays(2));
        System.out.println(solution.numWays(7));
    }
}
