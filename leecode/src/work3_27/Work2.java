package work3_27;

import work3_7.TreeNode;

import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 32 - III. 从上到下打印二叉树 III
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * User: starry
 * Date: 2021 -03 -27
 * Time: 15:21
 */
public class Work2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        Stack<TreeNode> a = new Stack<>();
        List<List<Integer>> out = new ArrayList<>();
        a.push(root);
        Stack<TreeNode> b = new Stack<>();
        int step = 0;
        while(!a.empty() || !b.empty()) {
            List<Integer> in = new ArrayList<>();
            if(step%2 == 0) {
                while(!a.empty()) {
                    TreeNode cur = a.pop();
                    in.add(cur.val);
                    if(cur.left != null) {
                        b.push(cur.left);
                    }
                    if(cur.right != null) {
                        b.push(cur.right);
                    }
                }
            }
            if(step%2 == 1) {
                while(!b.empty()) {
                    TreeNode cur = b.pop();
                    in.add(cur.val);
                    if(cur.right != null) {
                        a.push(cur.right);
                    }
                    if(cur.left != null) {
                        a.push(cur.left);
                    }
                }
            }
            step++;
            out.add(in);
        }
        return out;
    }

}
