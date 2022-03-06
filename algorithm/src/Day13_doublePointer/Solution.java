package Day13_doublePointer;

public class Solution {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     */
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < nums.length && nums[left] % 2 == 1) {
                left++;
            }
            while (right >= 0 && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return nums;
    }

    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }

    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
     * 例如输入字符串"I am a student. "，则输出"student. a am I"。
     */
    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        String[] strs = s.trim().split(" ");
        int left = 0;
        int right = strs.length - 1;
        while (left < right) {
            String tmp = strs[left];
            strs[left] = strs[right];
            strs[right] = tmp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            if (str.trim().length() != 0) {
                sb.append(str).append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(Arrays.toString(solution.exchange(new int[]{1, 2, 3, 4})));
        System.out.println(solution.reverseWords("a good   example"));
    }
}
