package Day4_searchAlgorithm;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Search {
    public static int search(int[] nums, int target) {
        int index = findIndex(nums, target);
        if (index < 0 || index >= nums.length || nums[index] != target) {
            return 0;
        }
        int res = 0;
        int left = index;
        int right = index;
        while (left >= 0 && nums[left] == target) {
            left--;
            res++;
        }
        while (right < nums.length && nums[right] == target) {
            right++;
            res++;
        }
        return res - 1;
    }

    private static int findIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 2}, 3));
        System.out.println(search(new int[]{}, 0));
    }
}
