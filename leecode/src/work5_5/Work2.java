package work5_5;

import work3_7.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * User: starry
 * Date: 2021 -05 -05
 * Time: 20:21
 */
public class Work2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
            }else if(root.val < p.val && root.val < q.val) {
                root = root.right;
            }else break;
        }
        return root;
    }

}
