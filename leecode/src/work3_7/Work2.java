package work3_7;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -03 -07
 * Time: 14:00
 */
public class Work2 {

    public HashMap<Integer,Integer> map;

    public TreeNode build(int[] preorder, int[] inorder, int pleft, int pright, int ileft, int iright) {
        if(pleft > pright) return null;
        int proot = pleft;
        int iroot = map.get(preorder[proot]);
        TreeNode root = new TreeNode(preorder[proot]);
        int iroot_leftsize = iroot-ileft;
        root.left = build(preorder,inorder,pleft+1,pleft+iroot_leftsize,ileft,iroot-1);
        root.right = build(preorder,inorder,pleft+iroot_leftsize+1,pright,iroot+1,iright);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,len-1,0,len-1);
    }

    public static void main(String[] args) {
        Work2 a = new Work2();
        int[] p = {3,9,20,15,7};
        int[] i = {9,3,15,20,7};
        System.out.println(a.buildTree(p, i).val);
    }

}

