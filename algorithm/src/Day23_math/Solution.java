package Day23_math;

public class Solution {

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     */
    public int majorityElement(int[] nums) {
        Integer res = null;
        int count = 0;
        for (int i : nums) {
            if (res == null || count == 0) {
                res = i;
            }
            if (res == i) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
     * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
     */
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
