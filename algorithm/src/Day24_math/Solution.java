package Day24_math;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * <p>
     * 等分成3的倍数即为乘积最大
     * 剩下的余数分开讨论
     * 余0 则刚好等分
     * 余1 3^x * 1 < 3^(x-1) * 2 * 2
     * 余2 增长计算乘法
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }

    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * <p>
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<int[]>();
        for (int i = 1; i < target; i++) {
            int tmp = 0;
            int column = 0;
            for (int j = i; j < target; j++) {
                tmp += j;
                if (tmp == target) {
                    int[] tmpRes = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        tmpRes[column++] = k;
                    }
                    res.add(tmpRes);
                    break;
                }
                if (tmp > target) {
                    break;
                }
            }
        }
        return res.toArray(new int[0][]);
    }

    /**
     * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
     * <p>
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     */
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int removeIndex = 0;
        while (list.size() > 1) {
            removeIndex = (removeIndex + m) % list.size();
            if (removeIndex == 0) {
                list.remove(list.size() - 1);
            } else {
                list.remove(--removeIndex);
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(Arrays.deepToString(solution.findContinuousSequence(9)));
        System.out.println(solution.lastRemaining(5, 3));
        System.out.println(solution.lastRemaining(10, 17));
    }
}
