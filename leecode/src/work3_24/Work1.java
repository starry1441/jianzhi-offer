package work3_24;

import work3_7.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 27. 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * User: starry
 * Date: 2021 -03 -24
 * Time: 16:00
 */
public class Work1 {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
