package Day15_searchBacktrace;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * <p>
     * 叶子节点 是指没有子节点的节点。
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        DFS(root, target, cur, res);
        return res;
    }

    private void DFS(TreeNode root, int left, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        if (left == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(cur));
        }
        DFS(root.left, left - root.val, cur, res);
        DFS(root.right, left - root.val, cur, res);
        cur.remove(cur.size() - 1);
    }

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。
     * 还需要返回链表中的第一个节点的指针。
     * <p>
     * 思路，遇到链表 就整两个指针 一个指向前节点 一个指向后节点
     */
    private Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        DFS(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void DFS(Node cur) {
        if (cur == null) {
            return;
        }
        DFS(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        DFS(cur.right);
    }

    /**
     * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
     */
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res.get(res.size() - k);
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(1);
        Node node5 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        Solution solution = new Solution();
        solution.treeToDoublyList(node1);
    }
}
