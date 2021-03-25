package work3_25;

import work3_7.TreeNode;

import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 32 - I. 从上到下打印二叉树
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * User: starry
 * Date: 2021 -03 -25
 * Time: 20:42
 */
public class Work3 {

    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            root = queue.poll();
            list.add(root);
            if(root.left != null) {
                queue.offer(root.left);
            }
            if(root.right != null) {
                queue.offer(root.right);
            }
        }
        int len = list.size();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = list.get(i).val;
        }
        return arr;
    }

}
