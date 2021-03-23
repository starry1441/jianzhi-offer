package work3_23;

import work3_7.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:合并两个排序的链表
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * User: starry
 * Date: 2021 -03 -23
 * Time: 16:41
 */
public class Work4 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null) {
            cur.next = l2;
        }else {
            cur.next = l1;
        }
        return head.next;
    }

}
