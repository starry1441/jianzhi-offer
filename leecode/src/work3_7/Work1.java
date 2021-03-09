package work3_7;
/**
 * Created with IntelliJ IDEA.
 * Description:从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * User: starry
 * Date: 2021 -03 -07
 * Time: 10:52
 */
public class Work1 {

    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        int[] arr = new int[count];
        cur = head;
        for(int i = count-1; i >= 0; i--) {
            arr[i] = cur.val;
            cur = cur.next;
        }
        return arr;
    }

}
