package Day16_sort;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                return false;
            }
            if (i != 0 && nums[i - 1] != 0) {
                diff += nums[i] - nums[i - 1];
            }
        }
        return diff <= 4;
    }

    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

    void quickSort(String[] strs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.isStraight(new int[]{0, 0, 1, 2, 5}));
        System.out.println(solution.isStraight(new int[]{0, 0, 1, 2, 3}));
        System.out.println(solution.isStraight(new int[]{0, 0, 1, 2, 6}));
    }
}
