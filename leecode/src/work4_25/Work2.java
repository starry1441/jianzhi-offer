package work4_25;

import work3_7.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 55 - II. 平衡二叉树
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * User: starry
 * Date: 2021 -04 -25
 * Time: 9:07
 */
public class Work2 {

    public boolean isBalanced(TreeNode root) {
        if(hight(root) >= 0) return true;
        return false;
    }
    public int hight(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = hight(root.left);
        int right = hight(root.right);
        if(left == -1 || right == -1 || Math.abs(right-left) > 1) {
            return -1;
        }
        return Math.max(left,right)+1;
    }

}
