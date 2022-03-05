package Day10_dynamicProgramming2;

public class Solution {


    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int lastNum = Integer.parseInt(str.substring(i - 2, i));
            if (lastNum >= 10 && lastNum < 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < s.length(); i++) {
            String subStr = s.substring(i - dp[i - 1], i);
            int index = subStr.indexOf(s.charAt(i));
            if (index == -1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1] - index;
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(12258));
    }
}
