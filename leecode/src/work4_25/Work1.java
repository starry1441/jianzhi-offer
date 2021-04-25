package work4_25;

import work3_7.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * User: starry
 * Date: 2021 -04 -25
 * Time: 9:00
 */
public class Work1 {

    //递归方法一
    int deep = 0;
    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root);
        return max;
    }
    public void dfs(TreeNode root) {
        deep++;
        if(root == null) {
            return;
        }
        dfs(root.left);
        deep--;
        dfs(root.right);
        deep--;
        if(max < deep) {
            max = deep;
        }
    }

    //递归方法二
    public int maxDepth3(TreeNode root) {
        if(root == null) return 0;
        int nLeft = maxDepth(root.left);
        int nRight = maxDepth(root.right);
        return nLeft > nRight ? nLeft + 1 : nRight + 1;
    }

    //层序遍历
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.add(root);
        int deep = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                cur = queue.poll();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
                size--;
            }
            deep++;
        }
        return deep;
    }

}
