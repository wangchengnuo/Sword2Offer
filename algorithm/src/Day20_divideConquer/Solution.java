package Day20_divideConquer;

public class Solution {

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     * <p>
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = buildTree(preorder, 0, inorder.length - 1, inorder, 0, inorder.length - 1);
        return node;
    }

    private TreeNode buildTree(int[] preorder, int preorderLeft, int preorderRight, int[] inorder, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        int preorderRoot = preorderLeft;
        int inorderRoot = indexof(inorder, preorder[preorderRoot]);
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        int sizeOfLeftTree = inorderRoot - inorderLeft;
        root.left = buildTree(preorder, preorderLeft + 1, preorderLeft + sizeOfLeftTree, inorder, inorderLeft, inorderRoot - 1);
        root.right = buildTree(preorder, preorderLeft + sizeOfLeftTree + 1, preorderRight, inorder, inorderRoot + 1, inorderRight);
        return root;
    }

    private int indexof(int[] order, int num) {
        for (int i = 0; i < order.length; i++) {
            if (order[i] == num) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n % 2 == 0) {
            double tmp = myPow(x, n / 2);
            return tmp * tmp;
        }
        double tmp = myPow(x, (n - 1) / 2);
        return x * tmp * tmp;
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     */
    public boolean verifyPostorder(int[] postorder) {
        return verifyHelper(postorder, 0, postorder.length - 1);
    }

    private boolean verifyHelper(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int rootValue = postorder[end];
        int splitIndex = end;
        for (int i = start; i <= end; i++) {
            if (postorder[i] > rootValue) {
                splitIndex = i;
                break;
            }
        }
        for (int i = splitIndex + 1; i < end; i++) {
            if (postorder[i] < rootValue) {
                return false;
            }
        }
        return verifyHelper(postorder, start, splitIndex - 1) && verifyHelper(postorder, splitIndex, end - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.myPow(2.0, 10));
        //System.out.println(solution.myPow(2.1, 3));
        //System.out.println(solution.myPow(2.0, -2));
        //System.out.println(solution.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        //System.out.println(solution.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
        System.out.println(solution.verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3}));
    }
}
