package Work4_24;

import work3_7.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:优化刚才的题
 * User: starry
 * Date: 2021 -04 -25
 * Time: 8:25
 */
public class Work2 {

    int count = 0;
    TreeNode res;
    public int kthLargest(TreeNode root, int k) {
        perOrder(root,k);
        return res.val;
    }

    public void perOrder(TreeNode cur,int k) {
        if(cur == null) return;
        perOrder(cur.right,k);
        count++;
        if(count == k) {
            res = cur;
        }
        perOrder(cur.left,k);
    }

}
