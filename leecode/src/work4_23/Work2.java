package work4_23;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * User: starry
 * Date: 2021 -04 -23
 * Time: 18:31
 */
public class Work2 {

    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length < 2) return true;
        return verify(postorder,0,postorder.length-1);
    }
    public boolean verify(int[] postorder,int left,int right) {
        if(left >= right) return true;
        int root = postorder[right];
        int k = left;
        while(k < right) {
            if(postorder[k] > root) {
                break;
            }
            k++;
        }
        while(k < right) {
            if(postorder[k] < root) {
                return false;
            }
            k++;
        }
        if(!verify(postorder,left,k-1)) return false;
        if(!verify(postorder,k,right-1)) return false;
        return true;
    }

}
