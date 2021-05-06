package work5_6;

import work3_7.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 68 - II. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * User: starry
 * Date: 2021 -05 -06
 * Time: 15:38
 */
public class Work2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == q || root == p) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null) return root;

        if(left != null) return left;

        if(right != null) return right;

        return null;
    }

}
