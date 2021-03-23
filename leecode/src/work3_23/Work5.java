package work3_23;

import work3_7.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * User: starry
 * Date: 2021 -03 -23
 * Time: 17:08
 */
public class Work5 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null) return false;
        if(isKid(A,B)) return true;
        return false;
    }
    public boolean isKid(TreeNode A, TreeNode B) {
        if(A == null) return false;
        boolean s = isSame(A,B);
        boolean l = isKid(A.left,B);
        boolean r = isKid(A.right,B);
        return s || l || r;
    }
    public boolean isSame(TreeNode A,TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) {
            return false;
        }
        boolean l = isSame(A.left,B.left);
        boolean r = isSame(A.right,B.right);
        return l && r;
    }

    //创建A树
    public TreeNode createA() {
        TreeNode headA = new TreeNode(1);
        TreeNode cur4 = new TreeNode(0);
        TreeNode cur5 = new TreeNode(1);
        TreeNode cur1 = new TreeNode(-4);
        TreeNode cur2 = new TreeNode(-3);
        headA.left = cur4;
        headA.right = cur5;
        cur4.left = cur1;
        cur4.right = cur2;
        return headA;
    }
    public TreeNode createB() {
        TreeNode headB = new TreeNode(1);
        TreeNode cur1 = new TreeNode(-4);
        headB.left = cur1;
        return headB;
    }

    public static void main(String[] args) {
        Work5 a = new Work5();
        TreeNode A = a.createA();
        TreeNode B = a.createB();
        System.out.println(a.isSubStructure(A, B));
    }

}
