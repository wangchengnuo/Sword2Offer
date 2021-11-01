package Day6SearchBacktrace_Easy;

import java.util.*;

/**
 * 广度优先搜索 打印二叉树
 */
public class LevelOrder {

    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     */
    public int[] levelOrder_1(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> resList = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode tmp = queue.poll();
                resList.add(tmp.val);
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
                size--;
            }
        }
        return resList.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     */
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> resList = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelRes = new ArrayList<>();
            while(size > 0){
                TreeNode tmp = queue.poll();
                levelRes.add(tmp.val);
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
                size--;
            }
            resList.add(levelRes);
        }
        return resList;
    }

    /**
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     */
    public List<List<Integer>> levelOrder_3(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> resList = new ArrayList<>();
        boolean direction = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelRes = new ArrayList<>();
            while(size > 0){
                TreeNode tmp = queue.poll();
                levelRes.add(tmp.val);
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
                size--;
            }
            List<Integer> levelRealRes = new ArrayList<>();
            if (!direction) {
                for (int i = levelRes.size() - 1; i >= 0; i--) {
                    levelRealRes.add(levelRes.get(i));
                }
            }else {
                levelRealRes = levelRes;
            }
            direction = !direction;
            resList.add(levelRealRes);
        }
        return resList;
    }

}
