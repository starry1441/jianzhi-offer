package Work4_24;

import work3_7.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * User: starry
 * Date: 2021 -04 -24
 * Time: 21:04
 */
public class Work1 {
    int count = 0;
    TreeNode res;
    public int kthLargest(TreeNode root, int k) {
        TreeNode cur = root;
        TreeNode parent = root;
        perOrder(cur,parent,k);
        return res.val;
    }

    public void perOrder(TreeNode cur, TreeNode parent, int k) {
        if(cur == null) return;
        if(cur.right == null) {
            count++;
            if(count == k) {
                res = cur;
            }
        }
        parent = cur;
        perOrder(cur.right,parent,k);
        perOrder(cur.left,parent,k);
        count++;
        if(count == k) {
            res = parent;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.right = t2;

        Work1 a = new Work1();
        System.out.println(a.kthLargest(t1, 2));
    }

}
