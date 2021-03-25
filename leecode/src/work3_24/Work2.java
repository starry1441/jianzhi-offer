package work3_24;

import work3_7.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 28. 对称的二叉树
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * User: starry
 * Date: 2021 -03 -24
 * Time: 16:00
 */
public class Work2 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricChild(root.left,root.right);
    }

    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree == null && rightTree == null) {
            return true;
        }
        if(leftTree == null && rightTree != null || leftTree != null && rightTree == null) {
            return false;
        }
        if(leftTree.val != rightTree.val) {
            return false;
        }
        return isSymmetricChild(leftTree.left,rightTree.right) && isSymmetricChild(leftTree.right,rightTree.left);
    }

}
