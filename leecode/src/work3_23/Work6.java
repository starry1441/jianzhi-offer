package work3_23;

import work3_7.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:另一个树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * User: starry
 * Date: 2021 -03 -23
 * Time: 19:42
 */
public class Work6 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(isSameTree(s,t)) return true;
        if(isSubtree(s.left,t)) return true;
        if(isSubtree(s.right,t)) return true;
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p !=null && q == null) return false;
        if(p == null && q == null) {
            return true;
        }
        if(p.val != q.val) {
            return false;
        }
        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);
        return (left && right);
    }

    public TreeNode createA() {
        TreeNode headA = new TreeNode(3);
        TreeNode cur4 = new TreeNode(4);
        TreeNode cur5 = new TreeNode(5);
        TreeNode cur1 = new TreeNode(1);
        TreeNode cur2 = new TreeNode(2);
        headA.left = cur4;
        headA.right = cur5;
        cur4.left = cur1;
        cur4.right = cur2;
        return headA;
    }
    public TreeNode createB() {
        TreeNode headB = new TreeNode(4);
        TreeNode cur1 = new TreeNode(1);
        TreeNode cur2 = new TreeNode(2);
        headB.left = cur1;
        headB.right = cur2;
        return headB;
    }

    public static void main(String[] args) {
        Work6 a = new Work6();
        TreeNode A = a.createA();
        TreeNode B = a.createB();
        System.out.println(a.isSubtree(A, B));
    }

}
