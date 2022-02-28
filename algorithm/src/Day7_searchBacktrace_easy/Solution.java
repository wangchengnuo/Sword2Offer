package Day7_searchBacktrace_easy;

class Solution {

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * <p>
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        if (isSubTree(A, B)) {
            return true;
        }
        return (A.left != null && isSubStructure(A.left, B))
                || (A.right != null && isSubStructure(A.right, B));
    }

    private boolean isSubTree(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSubTree(a.left, b.left) && isSubTree(a.right, b.right);
    }

    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetricHelper(root.left, root.right);
    }

    private boolean symmetricHelper(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null || A.val != B.val) {
            return false;
        }
        return symmetricHelper(A.left, B.right) && symmetricHelper(A.right, B.left);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(node1));
    }
}