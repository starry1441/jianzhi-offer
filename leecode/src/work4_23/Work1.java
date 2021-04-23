package work4_23;

import work3_7.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 34. 二叉树中和为某一值的路径
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * User: starry
 * Date: 2021 -04 -23
 * Time: 16:29
 */
public class Work1 {

    List<List<Integer>> out = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        perOrder(root,target);
        return out;
    }

    public void perOrder(TreeNode root, int target) {
        if(root == null) return;
        in.add(root.val);
        if(sum(in) == target) {
            out.add(new ArrayList<>(in));
            //out.add(in);
        }
        perOrder(root.left,target);
        perOrder(root.right,target);
        in.remove(in.size()-1);
    }

    public int sum(List<Integer> in) {
        int sum = 0;
        for(int i = 0; i < in.size(); i++) {
            sum = sum + in.get(i);
        }
        return sum;
    }


    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t8 = new TreeNode(8);
        TreeNode t11 = new TreeNode(11);
        TreeNode t13 = new TreeNode(13);
        TreeNode t44 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t2 = new TreeNode(2);
        TreeNode t55 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        t5.left = t4;
        t5.right = t8;
        t4.left = t11;
        t8.left = t13;
        t8.right = t44;
        t11.left = t7;
        t11.right = t2;
        t44.left = t55;
        t44.right = t1;

        Work1 a = new Work1();
        System.out.println(a.pathSum(t5, 22));
    }

}
