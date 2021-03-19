package work3_19;

import work3_7.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * User: starry
 * Date: 2021 -03 -19
 * Time: 17:22
 */
public class Work1 {

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) {
            head = head.next;
            return head;
        }
        ListNode cur = head;
        ListNode pre = cur;
        while(cur.next != null) {
            if(cur.val == val) {
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        if(cur.val == val) {
            pre.next = null;
        }
        return head;
    }

}
