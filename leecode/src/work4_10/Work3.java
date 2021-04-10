package work4_10;

import work3_7.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * User: starry
 * Date: 2021 -04 -10
 * Time: 14:50
 */
public class Work3 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = size(headA);
        int sizeB = size(headB);
        int step = sizeA-sizeB;
        ListNode curA = headA;
        ListNode curB = headB;
        if(step > 0) {
            while(step != 0) {
                curA = curA.next;
                step--;
            }
        }else {
            while(step != 0) {
                curB = curB.next;
                step++;
            }
        }
        while(curA != null) {
            if(curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    public int size(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

}
