package Day19_searchBacktrace;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public int sumNums(int n) {
        return IntStream.range(1, n + 1).sum();
    }

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        if (p.val < root.val && q.val > root.val) {
            return root;
        }
        if (q.val <= root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 与上一题不同的是参数为普通的二叉树 而不是二叉搜索树
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //根节点到p节点的路径
        List<TreeNode> path1 = new ArrayList<>();
        //根节点到q节点的路径
        List<TreeNode> path2 = new ArrayList<>();
        getPath(root, p, path1);
        getPath(root, q, path2);

        TreeNode res = null;
        int len = Math.min(path1.size(), path2.size());
        //保留最后一个相等的节点即为公共节点
        for (int i = 0; i < len; i++) {
            if (path1.get(i) == path2.get(i)) {
                res = path1.get(i);
            }
        }
        return res;
    }

    //前序遍历搜索节点p或q
    private void getPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null)
            return;
        path.add(root);
        if (root == node) {
            return;
        }
        if (path.get(path.size() - 1) != node) {
            getPath(root.left, node, path);
        }
        if (path.get(path.size() - 1) != node) {
            getPath(root.right, node, path);
        }
        if (path.get(path.size() - 1) != node) {
            path.remove(path.size() - 1);
        }
    }
}
