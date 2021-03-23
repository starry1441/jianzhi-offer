package work3_23;

import work3_7.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * User: starry
 * Date: 2021 -03 -23
 * Time: 16:24
 */
public class Work3 {

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = head;
        ListNode cur = head;
        ListNode curNext;
        while(cur != null) {
            curNext = cur.next;
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        pre.next = null;
        return head;
    }

}
